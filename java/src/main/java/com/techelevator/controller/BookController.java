package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.dao.UserSqlDAO;
import com.techelevator.model.ActiveBook;
import com.techelevator.model.Book;
import com.techelevator.model.BookLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookDAO bookDAO;
    private UserDAO userDAO;

    @RequestMapping (path = "/account/logs", method  = RequestMethod.GET)
    public List<BookLog> listAllBookLogs() {
        return bookDAO.listAllBookLogs();
    }

    @RequestMapping (path = "/account/{childId}/active-books", method  = RequestMethod.GET)
    public List<Book> listActiveBooks(@PathVariable int childId) {
        return bookDAO.listActiveBooks(childId);
    }

    @RequestMapping (path = "/account/library", method  = RequestMethod.GET)
    public List<Book> listAllBooks(Principal userId) {
        int tempID = 1;
        return bookDAO.listAllBooks(tempID);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/add-log", method = RequestMethod.POST)
    public BookLog addBookLog(@RequestBody BookLog bookLog) {
        bookDAO.addBookLog(bookLog);
        return bookLog;
    }

    @RequestMapping(path = "/add-active-book", method = RequestMethod.POST)
    public ActiveBook addActiveBook(@RequestBody ActiveBook book) {
        bookDAO.addActiveBook(book);
        return book;
    }

    @RequestMapping(path = "/delete-active-book", method = RequestMethod.DELETE)
    public void deleteActiveBook(@RequestBody ActiveBook book) {
        bookDAO.deleteActiveBook(book);
    }


    @RequestMapping(path = "/account/library/add-book", method = RequestMethod.POST)
    public Book addBookToLibrary(@RequestBody Book book, Principal user) {
        int userId = userDAO.findIdByUsername(user.getName());
        bookDAO.addBookToLibrary(book, userId);
        return book;
    }

}
