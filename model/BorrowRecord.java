package model;

import java.time.LocalDate;

/**
 * Wypozyczenie ksiazki
 */
public class BorrowRecord {
    private Book book;
    private User user;
    private LocalDate borrowDate;

    public BorrowRecord(Book book, User user) {
        this.book = book;
        this.user = user;
        this.borrowDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public String toString() {
        return user.getName() + " wypożyczył \"" + book.getTitle() + "\" dnia " + borrowDate;
    }
}