import java.time.LocalDate;
import java.util.Scanner;



import java.util.Arrays;
import java.util.Comparator;

public class BookSorter {
    // Sort books by ISBN using Comparator
    public static void sortBooksByISBN(Book[] books) {
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getISBN().compareTo(b2.getISBN());
            }
        });
    }
}
