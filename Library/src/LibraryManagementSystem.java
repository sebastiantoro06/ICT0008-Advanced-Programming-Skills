import java.time.LocalDate;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Initialize 5 sample books
        Book[] books = new Book[5];
        books[0] = new Book("Clean Code", "Robert C. Martin", "9780132350884", LocalDate.of(2023, 6, 18));
        books[1] = new HardcopyBook("Design Patterns", "Erich Gamma", "9780201633610", LocalDate.of(2023, 7, 22), "C5-9");
        books[2] = new EBook("The Pragmatic Programmer", "Andrew Hunt", "9780132119177", LocalDate.of(2023, 8, 30), LocalDate.of(2025, 6, 15));
        books[3] = new Book("Effective Java", "Joshua Bloch", "9780134685991", LocalDate.of(2023, 9, 10));
        books[4] = new HardcopyBook("Head First Java", "Kathy Sierra", "9780596009205", LocalDate.of(2023, 10, 5), "D3-1");


         /*
        // ❌ Invalid ISBN (too short)
        Book invalidISBN = new Book("Atomic Habits", "James Clear", "12345", LocalDate.now());

        // ❌ Future purchase date (illogical)
        Book invalidDate = new HardcopyBook("Deep Work", "Cal Newport", "9781455586691",
                                          LocalDate.of(2025, 12, 31), "B7-2");

        // ❌ Type errors (won't compile)
        Book typeError = new Book(null, "42", "212122", LocalDate.of(2023, 10, 5));



        System.out.println("\n=== INVALID BOOKS ===");
        invalidISBN.displayBookDetails();  // Throws IllegalArgumentException
        invalidDate.displayBookDetails();  // Logic error (future date)
        typeError.displayBookDetails(); // Won't compile
          */
        Scanner scanner = new Scanner(System.in);
        String inputISBN;

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Show Available Books");
            System.out.println("2. Sort Books by ISBN");
            System.out.println("3. Borrow a Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            inputISBN = scanner.nextLine();

            switch (inputISBN) {
                case "1":
                    displayBooks(books);
                    break;

                case "2":
                    sortBooksByISBN(books);
                    System.out.println("\nBooks sorted by ISBN!");
                    displayBooks(books);
                    break;

                case "3":
                    System.out.print("\nEnter ISBN to borrow a book: ");
                    inputISBN = scanner.nextLine();
                    borrowBook(books, inputISBN);
                    break;

                case "0":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Display all books
    private static void displayBooks(Book[] books) {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println("-----------------------------");
        }
    }

    // Sort books by ISBN using Bubble Sort
    private static void sortBooksByISBN(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (books[j].getISBN().compareTo(books[j + 1].getISBN()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    // Handle book borrowing
    private static void borrowBook(Book[] books, String isbn) {
        if (isbn.equals("0")) return;

        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("\nBook borrowed successfully!");
                    book.displayBookDetails();
                } else {
                    System.out.println("\nBook is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("\nBook not found in the system.");
    }
}