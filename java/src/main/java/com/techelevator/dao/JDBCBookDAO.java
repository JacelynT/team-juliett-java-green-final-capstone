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
    public List<Book> listAllBookLogs() {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT book.*, book_log.*\n" +
                "FROM book\n" +
                "JOIN book_log ON book.isbn = book_log.isbn\n";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setMinutes(result.getInt("minutes"));
            book.setAuthor(result.getString("book_author"));
            bookList.add(book);
        }

        return bookList;
    }

    //Lists all books that have been read by a specific child and their summed minutes (no copies of a book)
    public List<Book> listActiveBooks(int childId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT active_book.isbn, book.book_title, sum(book_log.minutes)\n" +
                "FROM active_book\n" +
                "JOIN book ON active_book.isbn = book.isbn\n" +
                "LEFT JOIN book_log ON book.isbn = book_log.isbn\n" +
                "WHERE active_book.child_id = ?\n" +
                "GROUP BY active_book.isbn, book.book_title;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, childId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setMinutes(result.getInt("sum"));
            bookList.add(book);
        }

        return bookList;
    }


    public List<Book> listAllBooks(int userId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT * FROM book\n" +
                "JOIN library_book ON book.isbn = library_book.isbn\n" +
                "JOIN library ON library_book.library_id = library.library_id\n" +
                "WHERE library.user_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setAuthor(result.getString("book_author"));
            bookList.add(book);
        }

        return bookList;
    }



    public BookLog addBookLog(BookLog bookLog) {
        String sql = "INSERT INTO book_log (isbn, child_id, minutes, entry_date) VALUES (?,?,?,?);";

        jdbcTemplate.update(sql, bookLog.getIsbn(), bookLog.getChildId(), bookLog.getMinutes(), bookLog.getDate());
        return bookLog;
    }


    //TODO Add book to library (by isbn?)



    private Book mapRowToBook(SqlRowSet result){
        Book book = new Book();
        book.setIsbn(result.getString("isbn"));
        book.setTitle(result.getString("book_title"));

        return book;
    }

}