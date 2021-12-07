package com.techelevator.controller;

import com.techelevator.dao.BookDAO;
import com.techelevator.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private BookDAO bookDAO;

    @RequestMapping (path = "/account/{childId}", method  = RequestMethod.GET)
    public List<Book> listAllBookLogs(@PathVariable int childId) {
        return bookDAO.listAllBookLogs(childId);
    }

}
