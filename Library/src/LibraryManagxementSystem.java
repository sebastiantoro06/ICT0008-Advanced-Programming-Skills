import java.time.LocalDate;
import java.util.Scanner;

public class LibraryManagxementSystem {
    public static void main(String[] args) {
        // Initialize 5 sample books
        Book[] books = new Book[5];
        books[0] = new Book("Clean Code", "Robert C. Martin", "9780132350884", LocalDate.of(2023, 6, 18));
        books[1] = new HardcopyBook("Design Patterns", "Erich Gamma", "9780201633610", LocalDate.of(2023, 7, 22), "C5-9");
        books[2] = new EBook("The Pragmatic Programmer", "Andrew Hunt", "9780132119177", LocalDate.of(2023, 8, 30), LocalDate.of(2025, 6, 15));
        books[3] = new Book("Effective Java", "Joshua Bloch", "9780134685991", LocalDate.of(2023, 9, 10));
        books[4] = new HardcopyBook("Head First Java", "Kathy Sierra", "9780596009205", LocalDate.of(2023, 10, 5), "D3-1");
        Scanner scanner = new Scanner(System.in);
        String inputISBN;
// Show Available books
        while (true) {
           System.out.println("Available Books:");
            for (Book book : books) {
                book.displayBookDetails();
                System.out.println("-----------------------------");
            }
            System.out.print("\nEnter ISBN to borrow a book (0 to exit): ");
            inputISBN = scanner.nextLine();

            if (inputISBN.equals("0")) {
                System.out.println("Exiting program...");
                break;
            }

            boolean bookFound = false;
            for (Book book : books) {
                if (book.getISBN().equals(inputISBN)) {
                    bookFound = true;
                    if (book.isAvailable()) {
                        book.borrowBook();
                        System.out.println("Book borrowed successfully!");
                        book.displayBookDetails();
                    } else {
                        System.out.println("Book is not available for borrowing.");
                    }
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("Book not found in the system.");
            }
        }
        scanner.close();
    }
}
