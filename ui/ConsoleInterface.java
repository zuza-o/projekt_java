package ui;

import model.Book;
import model.User;
import model.BorrowRecord;
import service.LibraryService;

import java.util.Scanner;

/**
 * ui
 */
public class ConsoleInterface {
    private LibraryService library;
    private Scanner scanner;
    private User currentUser;

    public ConsoleInterface() {
        this.library = new LibraryService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Witaj w systemie bibliotecznym ===");
        System.out.print("Podaj swoje imię: ");
        currentUser = new User(scanner.nextLine());

        seedBooks();

        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showBooks();
                    break;
                case "2":
                    borrowBook();
                    break;
                case "3":
                    returnBook();
                    break;
                case "4":
                    showHistory();
                    break;
                case "5":
                    System.out.println("Do zobaczenia!");
                    running = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }

    private void seedBooks() {
        library.addBook(new Book("Zbrodnia i kara", "Fiodor Dostojewski"));
        library.addBook(new Book("Wiedźmin", "Andrzej Sapkowski"));
        library.addBook(new Book("1984", "George Orwell"));
    }

    private void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Pokaż książki");
        System.out.println("2. Wypożycz książkę");
        System.out.println("3. Zwróć książkę");
        System.out.println("4. Historia wypożyczeń");
        System.out.println("5. Wyjście");
        System.out.print("Wybierz: ");
    }

    private void showBooks() {
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }
    }

    private void borrowBook() {
        System.out.print("Podaj tytuł książki do wypożyczenia: ");
        String title = scanner.nextLine();
        boolean success = library.borrowBook(title, currentUser);
        if (success) {
            System.out.println("Wypożyczono pomyślnie!");
        } else {
            System.out.println("Książka niedostępna lub nie istnieje.");
        }
    }

    private void returnBook() {
        System.out.print("Podaj tytuł książki do zwrotu: ");
        String title = scanner.nextLine();
        boolean success = library.returnBook(title);
        if (success) {
            System.out.println("Zwrócono pomyślnie!");
        } else {
            System.out.println("Nie znaleziono takiej wypożyczonej książki.");
        }
    }

    private void showHistory() {
        System.out.println("Historia wypożyczeń:");
        for (BorrowRecord record : library.getHistory()) {
            System.out.println(record);
        }
    }
}