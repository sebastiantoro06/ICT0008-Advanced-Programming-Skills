import java.time.LocalDate;
import java.util.Scanner;

public class HardcopyBook extends Book {
    private final String shelfNumber;

    public HardcopyBook(String title, String author, String ISBN, LocalDate dateAdded, String shelfNumber) {
        super(title, author, ISBN, dateAdded);
        this.shelfNumber = shelfNumber;
    }

    @Override
    public void displayBookDetails() {
        super.displayBookDetails();
        System.out.println("Shelf Number: " + shelfNumber);
    }
}



