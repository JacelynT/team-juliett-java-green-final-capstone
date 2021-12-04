package com.techelevator.controller;


import com.techelevator.dao.BookDAO;
import com.techelevator.model.Book;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private BookDAO bookDAO;

    @RequestMapping (path = "/child", method  = RequestMethod.GET)
    public List<Book> listAllBooks() {
        return bookDAO.listAllBooks();
    }

}
