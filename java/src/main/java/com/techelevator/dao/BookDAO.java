package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> listAllBookLogs(int childId);

    public List<Book> listAllBooks(int childId);

    public void addBook(String isbn, String title, String author, int minutes, int childId);

}
