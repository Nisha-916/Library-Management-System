import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book issued successfully.");
                    return;
                } else {
                    System.out.println("Book is not available for issuing.");
                    return;
                }
            }
        }
        System.out.println("Book not found in the library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Engineering Mathematics", "Das&Pal"));
        library.addBook(new Book("Discrete Mathematics", "Das&Pal"));
        library.addBook(new Book("Calculus", "Das&Pal"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Library Book Issue and Return System");
            System.out.println("1. Issue a book");
            System.out.println("2. Return a book");
            System.out.println("3. Display available books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book to issue: ");
                    scanner.nextLine(); // Consume the newline character
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 2:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine(); // Consume the newline character
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 3:
                    library.displayAvailableBooks();
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
