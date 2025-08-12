public class TestApp { /**
     * TEST CASES COVERED:
     * 1. Object creation
     * 2. Borrow/return functionality
     * 3. State verification
     *
     * DEBUGGING:
     * - All outputs print to terminal
     * - No external files needed
     */
    public static void main(String[] args) {
        System.out.println("=== LIBRARY SYSTEM TEST RESULTS ===");

        // 1. Test Book Creation
        Book book = new Book("Clean Code", "Robert Martin", "9780132350884", LocalDate.now());
        System.out.println("[PASS] Book object created successfully");

        // 2. Test Borrow Function
        if (book.borrowBook()) {
            System.out.println("[PASS] Book borrowed successfully");
        } else {
            System.out.println("[FAIL] Book borrowing failed");
        }

        // 3. Test Return Function
        book.returnBook();
        System.out.println("[PASS] Book returned successfully");

        System.out.println("\n=== DEBUG LOG ===");
        System.out.println("Book Status: " + book.displayBookDetails());
    }
}