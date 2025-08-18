import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//Create book Object
public class Book implements IBookOperations {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;
    private LocalDate dateAdded;

    public Book() {
        this.available = true;
    }


    public Book(String title, String author, String ISBN, LocalDate dateAdded) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.dateAdded = dateAdded;
        this.available = true;
    }

    @Override
    public String getISBN() {
        return this.ISBN;
    }

    // Set book details
    @Override
    public void setBookDetails(String title, String author, String ISBN, LocalDate dateAdded) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.dateAdded = dateAdded;
        this.available = true;
    }

    public void setBookDetails(String title, String author, String ISBN, String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        setBookDetails(title, author, ISBN, date);
    }

    // Display book details
    @Override
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println("Date Added: " + dateAdded);
    }

    // Borrow book
    @Override
    public boolean borrowBook() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    // Return book
    @Override
    public void returnBook() {
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public static void sortBooksByISBN(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if (books[i].getISBN().compareTo(books[j].getISBN()) > 0) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
    public String getTitle() {
        return this.title;
    }
}