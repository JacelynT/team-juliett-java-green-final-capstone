package com.techelevator.dao;

import com.techelevator.model.ActiveBook;
import com.techelevator.model.Book;
import com.techelevator.model.BookLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCBookDAO implements BookDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Lists all books that have been logged in the child_book join table
    public List<BookLog> listAllBookLogs() {
        List<BookLog> bookList = new ArrayList<>();

        String sql = "SELECT book.*, book_log.*, child.icon_name\n" +
                "FROM book\n" +
                "JOIN book_log ON book.isbn = book_log.isbn\n" +
                "JOIN child ON book_log.child_id = child.child_id\n" +
                "ORDER BY book_log.entry_date DESC, book_log.entry_time DESC";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            BookLog book = new BookLog();
            book.setIsbn(result.getString("isbn"));
            book.setMinutes(result.getInt("minutes"));
            book.setDate(result.getDate("entry_date").toLocalDate());
            book.setTitle(result.getString("book_title"));
            book.setChildId(result.getInt("child_id"));
            book.setIcon(result.getString("icon_name"));
            bookList.add(book);
        }

        return bookList;
    }

    //Lists all books that have been read by a specific child and their summed minutes (no copies of a book)
    public List<Book> listActiveBooks(int childId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT book.book_title, active_book.isbn, active_book.child_id, sum(book_log.minutes)\n" +
                "FROM book_log\n" +
                "RIGHT JOIN active_book ON book_log.isbn = active_book.isbn\n" +
                "JOIN book ON book.isbn = active_book.isbn\n" +
                "WHERE active_book.child_id = ?\n" +
                "GROUP BY book.book_title, active_book.isbn, active_book.child_id";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, childId);
        while (result.next()){
            Book book = mapRowToBook(result);
            try {
                book.setMinutes(result.getInt("sum"));
            } catch (Exception e){
                book.setMinutes(0);
            }
            bookList.add(book);
        }

        return bookList;
    }


    public List<Book> listAllBooks(int userId) {
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT * FROM book\n" +
                "JOIN library_book ON book.isbn = library_book.isbn\n" +
                "WHERE library_book.user_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while (result.next()){
            Book book = mapRowToBook(result);
            book.setAuthor(result.getString("book_author"));
            bookList.add(book);
        }

        return bookList;
    }



    public BookLog addBookLog(BookLog bookLog) {
        LocalDateTime time = LocalDateTime.now();
        String sql = "INSERT INTO book_log (isbn, child_id, minutes, entry_date, entry_time) VALUES (?,?,?,?,?);";

        jdbcTemplate.update(sql, bookLog.getIsbn(), bookLog.getChildId(), bookLog.getMinutes(), bookLog.getDate(), time);
        return bookLog;
    }


    public ActiveBook addActiveBook(ActiveBook book) {
        String sql = "INSERT INTO active_book (isbn, child_id) VALUES (?,?);";

        jdbcTemplate.update(sql, book.getIsbn(), book.getChildId());

        return book;
    }


    public void deleteActiveBook(ActiveBook book) {
        String sql = "DELETE FROM active_book WHERE child_id = ? AND isbn = ?;";

        jdbcTemplate.update(sql, book.getChildId(), book.getIsbn());
    }


    //TODO Add book to library (by isbn?)
    public Book addBookToLibrary(Book book, int userId) {
        String sqlBook = "INSERT INTO book (isbn, book_title, book_author, total_minutes) VALUES (?,?,?,?);";
        jdbcTemplate.update(sqlBook, book.getIsbn(), book.getTitle(), book.getAuthor(), 0);

        String sqlLibrary = "INSERT INTO library_book (user_id, isbn) VALUES (?,?);";
        jdbcTemplate.update(sqlLibrary, userId, book.getIsbn());

        return book;
    }


    private Book mapRowToBook(SqlRowSet result){
        Book book = new Book();
        book.setIsbn(result.getString("isbn"));
        book.setTitle(result.getString("book_title"));

        return book;
    }

}