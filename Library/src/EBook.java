import java.time.LocalDate;

// EBook.java
public class EBook extends Book {
    private final LocalDate licenseExpiryDate;

    public EBook(String title, String author, String ISBN, LocalDate dateAdded, LocalDate licenseExpiryDate) {
        super(title, author, ISBN, dateAdded);
        this.licenseExpiryDate = licenseExpiryDate;
    }

    @Override
    public void displayBookDetails() {
        super.displayBookDetails();
        System.out.println("License Expiry Date: " + licenseExpiryDate);
    }
}