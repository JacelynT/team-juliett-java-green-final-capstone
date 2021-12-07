package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCBookDAO implements BookDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Lists all books that have been logged in the child_book join table
    public List<Book> listAllBookLogs(int childId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT book.*, child_book.*\n" +
                "FROM book\n" +
                "JOIN child_book ON book.isbn = child_book.isbn\n" +
                "WHERE child_id = ?\n";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, childId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setMinutes(result.getInt("minutes"));
            bookList.add(book);
        }

        return bookList;
    }

    //Lists all books that have been read and their summed minutes (no copies of a book)
    public List<Book> listAllBooks(int childId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT book.book_title, book.book_author, child_book.isbn, sum(minutes) "
        + "FROM book JOIN child_book ON book.isbn = child_book.isbn "
        + "WHERE child_id = ? "
        + "GROUP BY child_book.isbn, book.book_title, book.book_author";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, childId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setMinutes(result.getInt("sum"));
            bookList.add(book);
        }

        return bookList;
    }


    public void addBook(String isbn, String title, String author, int minutes, int childId) {
        String sqlBook = "INSERT INTO book (isbn, book_title, book_author) VALUES (?,?,?);";

        jdbcTemplate.update(sqlBook, isbn, title, author);

        String sqlChildBook = "INSERT INTO child_book (isbn, child_id, minutes) VALUES (?,?,?);";

        jdbcTemplate.update(sqlChildBook, isbn, 1, minutes);
    }



    private Book mapRowToBook(SqlRowSet result){
        Book book = new Book();
        book.setAuthor(result.getString("book_author"));
        book.setIsbn(result.getString("isbn"));
        book.setTitle(result.getString("book_title"));

        return book;
    }

}