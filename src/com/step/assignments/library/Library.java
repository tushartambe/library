package com.step.assignments.library;

import javax.print.DocFlavor;
import java.util.*;

public class Library {
    private final String name;
    private Map<String, Book> books;
    private Librarian librarian;
    private Set<Reader> readers;
    private Map<String, Book> borrowedBooks;
    private Map<String, Book> removedBooks;

    public Library(String name, Map<String, Book> books, Librarian librarian, Set<Reader> readers) {
        this.name = name;
        this.books = new HashMap<>(books);
        this.librarian = librarian;
        this.readers = new HashSet<>(readers);

        this.borrowedBooks = new HashMap<>();
        this.removedBooks = new HashMap<>();
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
    }

    public void printBooks() {
        System.out.println("======ALL BOOKS=======");
        System.out.println(this.books);
        System.out.println("======ALL BOOKS=======");
    }

    //methods for reader

    public void borrowBook(Reader reader, Book book) {
        reader.borrowBook(book);
        book.borrow(reader);
        this.borrowedBooks.put(book.getName(), book);
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        book.addBackToLibrary();
        this.borrowedBooks.remove(book.getName());
    }


    public Book searchBook(String bookName) {
        if (this.books.containsKey(bookName)) {
            return this.books.get(bookName);
        }
        return null;
    }


    //methods for librarian
    public void addReader(Librarian librarian,Reader reader){
        this.readers.add(reader);
    }

    public void addBook(Librarian librarian, Book book) {
        this.books.put(book.getName(), book);
    }

    public void removeBook(Librarian librarian, String bookName) {
        this.removedBooks.put(bookName, books.get(bookName));
        this.books.remove(bookName);
    }

    public boolean isBookRemoved(Librarian librarian, String bookName) {
        return this.removedBooks.containsKey(bookName);
    }

    public Map<String, Book> booksBorrowedBy(Librarian librarian, Reader reader) {
        return reader.getBorrowedBooks();
    }

    public Reader whoBorrowedBook(Librarian librarian, String bookName) {
        if (this.books.containsKey(bookName)) {
            return this.books.get(bookName).getReader();
        }
        return null;
    }

    public Map<String, Book> allBooksBorrowedByReader(Librarian librarian, String readerName) {
        for (Reader reader : this.readers) {
            if (reader.getName().equals(readerName)){
                return reader.getBorrowedBooks();
            }
        }
        return null;
    }

    public void printReaders() {
        System.out.println(this.readers);
    }
}

