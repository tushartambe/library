package com.step.assignments.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {
    private String name;
    private Map<String,Book> borrowedBooks;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String,Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.put(book.getName(),book);
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book.getName());
    }

    public boolean isBookAlreadyBorrowed(Book book){
        return this.borrowedBooks.containsKey(book.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
