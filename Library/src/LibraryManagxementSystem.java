import java.time.LocalDate;
import java.util.Scanner;

public class LibraryManagxementSystem {
    public static void main(String[] args) {
        // Initialize 5 sample books
        Book[] books = new Book[5];
        books[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", LocalDate.of(2023, 1, 15));
        books[1] = new HardcopyBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", LocalDate.of(2023, 2, 20), "A12-3");
        books[2] = new EBook("1984", "George Orwell", "9780451524935", LocalDate.of(2023, 3, 10), LocalDate.of(2024, 12, 31));
        books[3] = new Book("Pride and Prejudice", "Jane Austen", "9780141439518", LocalDate.of(2023, 4, 5));
        books[4] = new HardcopyBook("The Hobbit", "J.R.R. Tolkien", "9780547928227", LocalDate.of(2023, 5, 12), "B7-2");

        Scanner scanner = new Scanner(System.in);
        String inputISBN;

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
