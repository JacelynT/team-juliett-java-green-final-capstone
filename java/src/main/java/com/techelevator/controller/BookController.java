package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.model.Book;
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
    public List<Book> listAllBooks(@PathVariable int childId) {
        return bookDAO.listAllBooks(childId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/book-log", method = RequestMethod.POST)
    public void addBookLog(String isbn, Integer minutes, Integer childID, LocalDate date) {
        bookDAO.addBookLog(isbn, minutes, childID, date);
    }

}
