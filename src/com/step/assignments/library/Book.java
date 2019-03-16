package com.step.assignments.library;

public class Book {
    private String name;
    private boolean isBorrowed = false;
    private Reader reader = null;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Reader getReader() {
        return reader;
    }

    private void changeReader(Reader reader) {
        this.reader = reader;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void addBackToLibrary() {
        this.isBorrowed = false;
        this.reader = null;
    }

    public void borrow(Reader reader) {
        this.isBorrowed = true;
        changeReader(reader);
    }

    @Override
    public String toString() {
        if (this.isBorrowed()) {
            return "{ name : " + this.getName() + "\nBorrowed by : " + this.getReader().getName() +
                    " }\n";
        }

        return "{ name : " + this.getName() + "\nBorrowed by : " + "null }\n";

    }
}
