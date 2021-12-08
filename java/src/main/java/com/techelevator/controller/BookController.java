package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.model.Book;
import com.techelevator.model.BookLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping (path = "/account/{childId}", method  = RequestMethod.GET)
    public List<Book> listAllBookLogs(@PathVariable int childId) {
        return bookDAO.listAllBookLogs(childId);
    }

    @RequestMapping (path = "/account/{childId}/books", method  = RequestMethod.GET)
    public List<Book> listCurrentBooks(@PathVariable int childId) {
        return bookDAO.listCurrentBooks(childId);
    }

    @RequestMapping (path = "/account/library", method  = RequestMethod.GET)
    public List<Book> listAllBooks() {
        return bookDAO.listAllBooks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/book-log", method = RequestMethod.POST)
    public BookLog addBookLog(@RequestBody BookLog bookLog) {
        bookDAO.addBookLog(bookLog);
        return bookLog;
    }

}
