import java.time.LocalDate;

//Create book Object
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;
    private LocalDate dateAdded;

    // Constructor
    public Book(String title, String author, String ISBN, LocalDate dateAdded) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
        this.dateAdded = dateAdded;
    }

    // Set book details
    public void setBookDetails(String title, String author, String ISBN, LocalDate dateAdded) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.dateAdded = dateAdded;
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println("Date Added: " + dateAdded);
    }

    // Borrow book
    public boolean borrowBook() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    // Return book
    public void returnBook() {
        available = true;
    }

    // Getters
    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }
}
