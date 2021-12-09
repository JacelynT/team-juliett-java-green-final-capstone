package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    //Lists all books that have been read by a specific child and their summed minutes (no copies of a book)
    public List<Book> listCurrentBooks(int childId) {
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

    //TODO make library based on user (family account)
    public List<Book> listAllBooks(int userId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM book "
                + "JOIN library ON book.isbn = library.isbn "
                + "WHERE user_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setMinutes(0);
            bookList.add(book);
        }

        return bookList;
    }





    public BookLog addBookLog(BookLog bookLog) {
        String sql = "INSERT INTO child_book (isbn, child_id, minutes, entry_date) VALUES (?,?,?,?);";

        jdbcTemplate.update(sql, bookLog.getIsbn(), bookLog.getChildId(), bookLog.getMinutes(), bookLog.getDate());
        return bookLog;
    }



    private Book mapRowToBook(SqlRowSet result){
        Book book = new Book();
        book.setAuthor(result.getString("book_author"));
        book.setIsbn(result.getString("isbn"));
        book.setTitle(result.getString("book_title"));

        return book;
    }

}