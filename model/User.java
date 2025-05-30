package model;

/**
 * Klasa czytelnik
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}