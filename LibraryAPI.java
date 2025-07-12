import java.util.List;
import java.util.Scanner;

/**
 * Library API - Simulates REST endpoints through method calls.
 * Demonstrates the complete library management functionality.
 */
public class LibraryAPI {
    
    private static BookService bookService = new BookService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("REST API Simulation");
        System.out.println("================================");
        
        // Add some sample books
        addSampleBooks();
        
        // Demonstrate all operations
        demonstrateOperations();
        
        scanner.close();
    }
    
    /**
     * Simulates POST /api/books - Add a new book
     */
    public static Book addBook(Book book) {
        System.out.println("\n--- POST /api/books (Add Book) ---");
        Book addedBook = bookService.addBook(book);
        System.out.println("✅ Book added successfully:");
        System.out.println(addedBook);
        return addedBook;
    }
    
    /**
     * Simulates GET /api/books - Get all books
     */
    public static List<Book> getAllBooks() {
        System.out.println("\n--- GET /api/books (Get All Books) ---");
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("📚 No books found in catalog");
        } else {
            System.out.println("📚 All books in catalog:");
            books.forEach(System.out::println);
        }
        return books;
    }
    
    /**
     * Simulates GET /api/books/{id} - Get book by ID
     */
    public static Book getBookById(Integer id) {
        System.out.println("\n--- GET /api/books/" + id + " (Get Book by ID) ---");
        Book book = bookService.getBookById(id);
        if (book != null) {
            System.out.println("📖 Book found:");
            System.out.println(book);
        } else {
            System.out.println("❌ Book with ID " + id + " not found");
        }
        return book;
    }
    
    /**
     * Simulates DELETE /api/books/{id} - Delete book
     */
    public static boolean deleteBook(Integer id) {
        System.out.println("\n--- DELETE /api/books/" + id + " (Delete Book) ---");
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            System.out.println("✅ Book with ID " + id + " deleted successfully");
        } else {
            System.out.println("❌ Book with ID " + id + " not found");
        }
        return deleted;
    }
    
    /**
     * Simulates PATCH /api/books/{id}/availability - Update book availability
     */
    public static Book updateBookAvailability(Integer id, Boolean available) {
        System.out.println("\n--- PATCH /api/books/" + id + "/availability (Update Availability) ---");
        Book updatedBook = bookService.updateBookAvailability(id, available);
        if (updatedBook != null) {
            System.out.println("✅ Book availability updated:");
            System.out.println(updatedBook);
        } else {
            System.out.println("❌ Book with ID " + id + " not found");
        }
        return updatedBook;
    }
    
    /**
     * Simulates PATCH /api/books/{id}/toggle-availability - Toggle book availability
     */
    public static Book toggleBookAvailability(Integer id) {
        System.out.println("\n--- PATCH /api/books/" + id + "/toggle-availability (Toggle Availability) ---");
        Book updatedBook = bookService.toggleBookAvailability(id);
        if (updatedBook != null) {
            System.out.println("✅ Book availability toggled:");
            System.out.println(updatedBook);
        } else {
            System.out.println("❌ Book with ID " + id + " not found");
        }
        return updatedBook;
    }
    
    /**
     * Simulates PUT /api/books/{id} - Update book
     */
    public static Book updateBook(Integer id, Book updatedBook) {
        System.out.println("\n--- PUT /api/books/" + id + " (Update Book) ---");
        Book book = bookService.updateBook(id, updatedBook);
        if (book != null) {
            System.out.println("✅ Book updated successfully:");
            System.out.println(book);
        } else {
            System.out.println("❌ Book with ID " + id + " not found");
        }
        return book;
    }
    
    /**
     * Add sample books to demonstrate functionality
     */
    private static void addSampleBooks() {
        System.out.println("📚 Adding sample books...");
        
        Book book1 = new Book();
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        book1.setIsbn("978-0743273565");
        book1.setAvailable(true);
        addBook(book1);
        
        Book book2 = new Book();
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setIsbn("978-0446310789");
        book2.setAvailable(false);
        addBook(book2);
        
        Book book3 = new Book();
        book3.setTitle("1984");
        book3.setAuthor("George Orwell");
        book3.setIsbn("978-0451524935");
        book3.setAvailable(true);
        addBook(book3);
    }
    
    /**
     * Demonstrate all API operations
     */
    private static void demonstrateOperations() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMONSTRATING ALL API OPERATIONS");
        System.out.println("=".repeat(50));
        
        // 1. Get all books
        getAllBooks();
        
        // 2. Get book by ID
        getBookById(1);
        getBookById(999); // Non-existent book
        
        // 3. Update book availability
        updateBookAvailability(1, false);
        
        // 4. Toggle book availability
        toggleBookAvailability(2);
        
        // 5. Update book
        Book updatedBook = new Book();
        updatedBook.setTitle("The Great Gatsby (Updated)");
        updatedBook.setAuthor("F. Scott Fitzgerald");
        updatedBook.setIsbn("978-0743273565");
        updatedBook.setAvailable(true);
        updateBook(1, updatedBook);
        
        // 6. Get all books again to see changes
        getAllBooks();
        
        // 7. Delete a book
        deleteBook(3);
        
        // 8. Final state
        System.out.println("\n" + "=".repeat(50));
        System.out.println("FINAL STATE");
        System.out.println("=".repeat(50));
        getAllBooks();
        
        // 9. Show statistics
        System.out.println("\n📊 Statistics:");
        System.out.println("Total books: " + bookService.getBookCount());
        System.out.println("Book 1 exists: " + bookService.bookExists(1));
        System.out.println("Book 3 exists: " + bookService.bookExists(3));
    }
} 