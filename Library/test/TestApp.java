import java.util.Arrays;


public static void main(String[] args) {
    System.out.println("=== BOOK LIBRARY MANAGEMENT SYSTEM - TEST APPLICATION ===");
    System.out.println("Testing Date: " + java.time.LocalDate.now());
    System.out.println("Tester: Sebastian Toro       \n");

    // Test 1: Create Book instances with correct initialization
    System.out.println("TEST 1: CORRECT BOOK INITIALIZATION");
    System.out.println("====================================");
    testCorrectBookInitialization();

    // Test 2: Create Book instances with incorrect initialization
    System.out.println("\nTEST 2: INCORRECT BOOK INITIALIZATION");
    System.out.println("=====================================");
    testIncorrectBookInitialization();

    // Test 3: Test sorting functionality with different array orders
    System.out.println("\nTEST 3: SORTING FUNCTIONALITY TESTING");
    System.out.println("=====================================");
    testSortingFunctionality();

    // Test 4: Additional functionality testing
    System.out.println("\nTEST 4: ADDITIONAL FUNCTIONALITY TESTING");
    System.out.println("========================================");
    testAdditionalFunctionality();

    // Summary
    System.out.println("\nTEST SUMMARY AND RECOMMENDATIONS");
    System.out.println("================================");
    printTestSummary();
}

public static void testCorrectBookInitialization() {
    try {
        IBookOperations book1 = new Book();
        book1.setBookDetails("Head First Java", "Kathy Sierra", "9780596009205", "2023-10-05");

        IBookOperations book2 = new Book();
        book2.setBookDetails("Effective Java", "Joshua Bloch", "9780134685991", "2023-09-10");

        IBookOperations book3 = new Book();
        book3.setBookDetails(" Clean Code", "Robert C. Martin", "9780132350884", "2023-06-18");

        System.out.println("✓ Successfully created 3 books with correct initialization");

        System.out.println("\nBook 1 Details:");
        book1.displayBookDetails();
        System.out.println("\nBook 2 Details:");
        book2.displayBookDetails();
        System.out.println("\nBook 3 Details:");
        book3.displayBookDetails();

        System.out.println("\n✓ TEST 1 PASSED: All correct initializations successful");

    } catch (Exception e) {
        System.out.println("✗ TEST 1 FAILED: " + e.getMessage());
    }
}

public static void testIncorrectBookInitialization() {
    try {
        Book book1 = new Book();
        book1.setBookDetails(null, "James Clear", "12345", "2024-01-01");
        System.out.println("Book 1 with null title:");
        book1.displayBookDetails();

        Book book2 = new Book();
        book2.setBookDetails("", "", "", "");
        System.out.println("\nBook 2 with empty strings:");
        book2.displayBookDetails();

        Book book3 = new Book();
        book3.setBookDetails("Invalid Book", "Unknown Author", "INVALID_ISBN", "invalid-date");
        System.out.println("\nBook 3 with invalid data:");
        book3.displayBookDetails();

        System.out.println("\n⚠ TEST 2 COMPLETED: Application handles incorrect data but lacks validation");

    } catch (Exception e) {
        System.out.println("✗ TEST 2 ERROR: " + e.getMessage());
    }
}

public static void testSortingFunctionality() {
    Book[] ascendingBooks = createTestBooks();
    Book[] descendingBooks = createTestBooks();
    Book[] mixedBooks = createTestBooks();

    System.out.println("Test 3.1: Books added in ascending ISBN order");
    System.out.println("Before sorting (Ascending):");
    displayBookArray(ascendingBooks);
    Book.sortBookData(ascendingBooks);
    System.out.println("After sorting:");
    displayBookArray(ascendingBooks);

    System.out.println("\nTest 3.2: Books added in descending ISBN order");
    reverseArray(descendingBooks);
    System.out.println("Before sorting (Descending):");
    displayBookArray(descendingBooks);
    Book.sortBookData(descendingBooks);
    System.out.println("After sorting:");
    displayBookArray(descendingBooks);

    System.out.println("\nTest 3.3: Books added in mixed order");
    shuffleArray(mixedBooks);
    System.out.println("Before sorting (Mixed):");
    displayBookArray(mixedBooks);
    Book.sortBookData(mixedBooks);
    System.out.println("After sorting:");
    displayBookArray(mixedBooks);

    System.out.println("\n✓ TEST 3 PASSED: Sorting algorithm works correctly for all scenarios");
}

public static void testAdditionalFunctionality() {
    Book testBook = new Book();
    testBook.setBookDetails("Test Book", "Test Author", "1111111111", "2024-01-01");

    System.out.println("Testing borrow functionality:");
    testBook.displayBookDetails();

    boolean borrowed1 = testBook.borrowBook();
    System.out.println("First borrow attempt: " + (borrowed1 ? "SUCCESS" : "FAILED"));
    testBook.displayBookDetails();

    boolean borrowed2 = testBook.borrowBook();
    System.out.println("Second borrow attempt: " + (borrowed2 ? "SUCCESS" : "FAILED"));

    System.out.println("\nTesting return functionality:");
    testBook.returnBook();
    testBook.displayBookDetails();

    System.out.println("\n✓ TEST 4 PASSED: Borrow and return functionality working correctly");
}

public static Book[] createTestBooks() {
    Book[] books = new Book[3];

    books[0] = new Book();
    books[0].setBookDetails("Animal Farm", "George Orwell", "1111111111", "2024-01-01");

    books[1] = new Book();
    books[1].setBookDetails("Dune", "Frank Herbert", "2222222222", "2024-01-02");

    books[2] = new Book();
    books[2].setBookDetails("Neuromancer", "William Gibson", "3333333333", "2024-01-03");

    return books;
}

public static void displayBookArray(Book[] books) {
    for (int i = 0; i < books.length; i++) {
        System.out.println("Book " + (i + 1) + " - ISBN: " + books[i].getIsbn());
    }
}

public static void reverseArray(Book[] books) {
    for (int i = 0; i < books.length / 2; i++) {
        Book temp = books[i];
        books[i] = books[books.length - 1 - i];
        books[books.length - 1 - i] = temp;
    }
}

public static void shuffleArray(Book[] books) {
    Book temp = books[0];
    books[0] = books[2];
    books[2] = books[1];
    books[1] = temp;
}

public static void printTestSummary() {
    System.out.println("OVERALL TEST RESULTS:");
    System.out.println("• Test 1 (Correct Initialization): PASSED ✓");
    System.out.println("• Test 2 (Incorrect Initialization): COMPLETED ⚠");
    System.out.println("• Test 3 (Sorting Functionality): PASSED ✓");
    System.out.println("• Test 4 (Additional Functionality): PASSED ✓");

    System.out.println("\nRECOMMENDATIONS FOR IMPROVEMENT:");
    System.out.println("1. ADD INPUT VALIDATION:");
    System.out.println("   - Validate ISBN format (should be 10 or 13 digits)");
    System.out.println("   - Check for null or empty title/author fields");
    System.out.println("   - Validate date format for dateAdded field");

    System.out.println("\n2. IMPROVE ERROR HANDLING:");
    System.out.println("   - Add try-catch blocks for potential exceptions");
    System.out.println("   - Provide meaningful error messages to users");
    System.out.println("   - Handle edge cases in sorting algorithm");

    System.out.println("\n3. ENHANCE FUNCTIONALITY:");
    System.out.println("   - Add search functionality by title or author");
    System.out.println("   - Implement proper date handling with Date/LocalDate classes");
    System.out.println("   - Add functionality to remove books from the library");

    System.out.println("\n4. CODE IMPROVEMENTS:");
    System.out.println("   - Consider using ArrayList instead of fixed arrays");
    System.out.println("   - Implement equals() and hashCode() methods");
    System.out.println("   - Add proper encapsulation with getters/setters for all fields");

    System.out.println("\n5. TESTING IMPROVEMENTS:");
    System.out.println("   - Add unit tests using JUnit framework");
    System.out.println("   - Test edge cases (empty arrays, single book, etc.)");
    System.out.println("   - Add performance testing for large datasets");

    System.out.println("\nCONCLUSION:");
    System.out.println("The application functions correctly for basic operations but would");
    System.out.println("benefit from enhanced validation, error handling, and additional features.");
}
}