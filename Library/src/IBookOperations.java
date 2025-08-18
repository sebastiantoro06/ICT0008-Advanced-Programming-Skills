import java.time.LocalDate;

public interface IBookOperations {
    String getISBN();
    void setBookDetails(String title, String author, String ISBN, LocalDate dateAdded);
    void displayBookDetails();
    boolean borrowBook();
    void returnBook();
}