package com.step.assignments.library;

import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Book> books = new HashMap<>();
        Set<Reader> readers = new HashSet<>();

        Librarian librarian = new Librarian("Chandu");
        Library library = new Library("Granthalay", books, librarian, readers);

        System.out.println("Enter Your Choice ?");
        System.out.println("1 : Add Reader");
        System.out.println("2 : Add a Book");
        System.out.println("3 : Search a Book:");
        System.out.println("4 : Print all Book:");
        System.out.println("5 : Get all users");
        System.out.println("6 : check is book removed");
        System.out.println("7 : remove the book");
        System.out.println("8 : Enter a reader name to get all books: ");
        System.out.println("\n");

        int choice = 10;

        while (choice != 0) {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Reader Name :");
                    String reader = scanner.next();
                    library.addReader(librarian, new Reader(reader));
                    System.out.println("Reader added!!!");
                    break;
                case 2:
                    System.out.println("Enter Book Name to add :");
                    String book = scanner.next();
                    library.addBook(librarian, new Book(book));
                    System.out.println("Book added successfully !!!");
                    break;

                case 3:
                    System.out.println("Enter Book Name to search :");
                    String name = scanner.next();
                    Book searchedBook = library.searchBook(name);
                    System.out.println(searchedBook);
                    break;

                case 4:
                    System.out.println("All the books in the library are : ");
                    library.printBooks();
                    break;

                case 5:
                    System.out.println("All the Readers in the library are : ");
                    library.printReaders();
                    break;

                case 6:
                    System.out.println("Enter a book name to check is removed: ");
                    String checkBook = scanner.next();
                    System.out.println(library.isBookRemoved(librarian, checkBook));
                    break;

                case 7:
                    System.out.println("Enter a book name to remove : ");
                    String bookToRemove = scanner.next();
                    library.removeBook(librarian, bookToRemove);
                    System.out.println("Book was removed successfully !!!!");
                    break;

                case 8:
                    System.out.println("Enter a reader name to get all books: ");
                    String readerName = scanner.next();
                    System.out.println(library.allBooksBorrowedByReader(librarian, readerName));
                    break;

                default:
                    System.exit(0);
            }
        }
    }
}