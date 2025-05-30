package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * dodawanie, wypozyczanie i zwracanie ksiazek
 */
public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<BorrowRecord> history = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public boolean borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.borrow();
                history.add(new BorrowRecord(book, user));
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                return true;
            }
        }
        return false;
    }

    public List<BorrowRecord> getHistory() {
        return history;
    }
}