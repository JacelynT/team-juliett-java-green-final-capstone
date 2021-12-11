package com.techelevator.dao;

import com.techelevator.model.ActiveBook;
import com.techelevator.model.Book;
import com.techelevator.model.BookLog;

import java.time.LocalDate;
import java.util.List;

public interface BookDAO {

    public List<BookLog> listAllBookLogs();

    public List<Book> listActiveBooks(int childId);

    public BookLog addBookLog(BookLog bookLog);

    public List<Book> listAllBooks(int userId);

    public ActiveBook addActiveBook(ActiveBook book);

    public void deleteActiveBook(ActiveBook book);
}
