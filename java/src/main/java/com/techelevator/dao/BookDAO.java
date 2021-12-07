package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookLog;

import java.time.LocalDate;
import java.util.List;

public interface BookDAO {

    public List<Book> listAllBookLogs(int childId);

    public List<Book> listAllBooks(int childId);

    public BookLog addBookLog(BookLog bookLog);

}
