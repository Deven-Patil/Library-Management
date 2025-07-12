import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service class for managing book operations.
 * Uses in-memory storage with thread-safe operations.
 */
public class BookService {
    
    // In-memory storage using ConcurrentHashMap for thread safety
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    
    // Atomic counter for generating unique IDs
    private final AtomicInteger idCounter = new AtomicInteger(1);
    
    /**
     * Add a new book to the catalog
     * @param book the book to add
     * @return the added book with generated ID
     */
    public Book addBook(Book book) {
        // Generate unique ID
        Integer newId = idCounter.getAndIncrement();
        book.setId(newId);
        
        // Set default availability if not specified
        if (book.getAvailable() == null) {
            book.setAvailable(true);
        }
        
        books.put(newId, book);
        return book;
    }
    
    /**
     * Get all books in the catalog
     * @return list of all books
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    
    /**
     * Get a book by its ID
     * @param id the book ID
     * @return the book if found, null otherwise
     */
    public Book getBookById(Integer id) {
        return books.get(id);
    }
    
    /**
     * Delete a book by its ID
     * @param id the book ID to delete
     * @return true if book was deleted, false if not found
     */
    public boolean deleteBook(Integer id) {
        return books.remove(id) != null;
    }
    
    /**
     * Update book availability
     * @param id the book ID
     * @param available the new availability status
     * @return the updated book if found, null otherwise
     */
    public Book updateBookAvailability(Integer id, Boolean available) {
        Book book = books.get(id);
        if (book != null) {
            book.setAvailable(available);
            return book;
        }
        return null;
    }
    
    /**
     * Toggle book availability
     * @param id the book ID
     * @return the updated book if found, null otherwise
     */
    public Book toggleBookAvailability(Integer id) {
        Book book = books.get(id);
        if (book != null) {
            book.toggleAvailability();
            return book;
        }
        return null;
    }
    
    /**
     * Update an existing book
     * @param id the book ID
     * @param updatedBook the updated book data
     * @return the updated book if found, null otherwise
     */
    public Book updateBook(Integer id, Book updatedBook) {
        Book existingBook = books.get(id);
        if (existingBook != null) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return updatedBook;
        }
        return null;
    }
    
    /**
     * Check if a book exists by ID
     * @param id the book ID
     * @return true if book exists, false otherwise
     */
    public boolean bookExists(Integer id) {
        return books.containsKey(id);
    }
    
    /**
     * Get total number of books in catalog
     * @return the count of books
     */
    public int getBookCount() {
        return books.size();
    }
} 