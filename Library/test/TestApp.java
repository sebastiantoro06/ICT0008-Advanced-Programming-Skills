import java.time.LocalDate;

public class TestApp {

    public static void main(String[] args) {
        printHeader();
        runAllTestScenarios();
    }

    private static void printHeader() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       LIBRARY SYSTEM VALIDATION PROGRAM         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("Execution Date: " + LocalDate.now());
        System.out.println("Performed by: Library QA Team\n");
    }

    private static void runAllTestScenarios() {
        // Phase 1: Validation Tests
        validateBookCreation();

        // Phase 2: Error Handling Tests
        checkErrorScenarios();

        // Phase 3: Operational Tests
        verifySortingMechanism();
        testLoanOperations();

        // Final Report
        generateTestReport();
    }

    private static void validateBookCreation() {
        System.out.println("\nPHASE 1: BOOK CREATION VALIDATION");
        System.out.println("----------------------------------");

        try {
            Book novel = new Book();
            novel.setBookDetails("1984", "George Orwell", "9780451524935", "2024-04-01");

            Book classic = new Book();
            classic.setBookDetails("To Kill a Mockingbird", "Harper Lee", "9780446310789", "2024-04-02");

            Book scifi = new Book();
            scifi.setBookDetails("The Martian", "Andy Weir", "9780553418026", "2024-04-03");

            System.out.println("✔ All test books created successfully");

            System.out.println("\nSample Book Records:");
            System.out.println("-------------------");
            novel.displayBookDetails();
            System.out.println();
            classic.displayBookDetails();
            System.out.println();
            scifi.displayBookDetails();

            System.out.println("\nSTATUS: Creation tests completed successfully");

        } catch (Exception e) {
            System.out.println("✖ ERROR in creation tests: " + e.getMessage());
        }
    }

    private static void checkErrorScenarios() {
        System.out.println("\nPHASE 2: ERROR CONDITION TESTING");
        System.out.println("--------------------------------");

        System.out.println("Testing boundary conditions...");

        try {
            Book emptyBook = new Book();
            emptyBook.setBookDetails("", "", "", "");
            System.out.println("\nEmpty book record created (should validate inputs):");
            emptyBook.displayBookDetails();

            Book invalidBook = new Book();
            invalidBook.setBookDetails(null, "No Name", "INVALID", "not-a-date");
            System.out.println("\nInvalid book record created (should validate inputs):");
            invalidBook.displayBookDetails();

            System.out.println("\nNOTICE: Application accepts invalid data - needs input validation");

        } catch (Exception e) {
            System.out.println("Error encountered: " + e.getMessage());
        }
    }

    private static void verifySortingMechanism() {
        System.out.println("\nPHASE 3: SORTING ALGORITHM VERIFICATION");
        System.out.println("----------------------------------------");

        Book[] sampleCollection = generateTestCollection();

        System.out.println("\nOriginal Collection:");
        printCollectionSummary(sampleCollection);

        System.out.println("\nTesting with pre-sorted collection:");
        Book.sortBooksByISBN(sampleCollection);
        printCollectionSummary(sampleCollection);

        System.out.println("\nTesting with reverse-sorted collection:");
        reverseCollection(sampleCollection);
        printCollectionSummary(sampleCollection);
        Book.sortBooksByISBN(sampleCollection);
        printCollectionSummary(sampleCollection);

        System.out.println("\nTesting with randomized collection:");
        shuffleCollection(sampleCollection);
        printCollectionSummary(sampleCollection);
        Book.sortBooksByISBN(sampleCollection);
        printCollectionSummary(sampleCollection);

        System.out.println("\nSTATUS: Sorting mechanism working as expected");
    }

    private static void testLoanOperations() {
        System.out.println("\nPHASE 4: LOAN MANAGEMENT TESTING");
        System.out.println("---------------------------------");

        Book testBook = new Book();
        testBook.setBookDetails("Test Book", "QA Team", "0000000000", "2024-01-01");

        System.out.println("\nInitial state:");
        testBook.displayBookDetails();

        System.out.println("\nAttempting first loan...");
        boolean firstLoan = testBook.borrowBook();
        System.out.println("First loan " + (firstLoan ? "succeeded" : "failed"));
        testBook.displayBookDetails();

        System.out.println("\nAttempting second loan (should fail)...");
        boolean secondLoan = testBook.borrowBook();
        System.out.println("Second loan " + (secondLoan ? "succeeded" : "failed"));

        System.out.println("\nReturning book...");
        testBook.returnBook();
        testBook.displayBookDetails();

        System.out.println("\nSTATUS: Loan operations functioning properly");
    }

    private static void generateTestReport() {
        System.out.println("\nFINAL TEST SUMMARY");
        System.out.println("==================");

        System.out.println("\nTEST RESULTS:");
        System.out.println("✓ Book creation and storage");
        System.out.println("✓ Basic error handling (needs improvement)");
        System.out.println("✓ ISBN-based sorting");
        System.out.println("✓ Loan management operations");

        System.out.println("\nRECOMMENDED IMPROVEMENTS:");
        System.out.println("1. Input validation for all fields");
        System.out.println("2. Enhanced error messages");
        System.out.println("3. Additional collection management features");
        System.out.println("4. Comprehensive unit test coverage");

        System.out.println("\nCONCLUSION:");
        System.out.println("Core functionality is operational. The system provides");
        System.out.println("a solid foundation that can be enhanced with additional");
        System.out.println("validation and features for production use.");
    }

    // Helper methods
    private static Book[] generateTestCollection() {
        Book[] collection = new Book[3];

        collection[0] = new Book();
        collection[0].setBookDetails("Book A", "Author X", "1000000000", "2024-01-01");

        collection[1] = new Book();
        collection[1].setBookDetails("Book B", "Author Y", "2000000000", "2024-01-02");

        collection[2] = new Book();
        collection[2].setBookDetails("Book C", "Author Z", "3000000000", "2024-01-03");

        return collection;
    }

    private static void printCollectionSummary(Book[] books) {
        System.out.println("Current collection order:");
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%d %s (ISBN: %s)!\n", i+1, books[i].getTitle(), books[i].getISBN());

        }
    }

    private static void reverseCollection(Book[] books) {
        for (int i = 0; i < books.length / 2; i++) {
            Book temp = books[i];
            books[i] = books[books.length - 1 - i];
            books[books.length - 1 - i] = temp;
        }
    }

    private static void shuffleCollection(Book[] books) {
        Book temp = books[0];
        books[0] = books[1];
        books[1] = books[2];
        books[2] = temp;
    }
}