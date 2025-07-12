import java.util.Objects;

/**
 * Book entity representing a book in the library catalog.
 * Demonstrates encapsulation with private fields and public getters/setters.
 */
public class Book {
    
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Boolean available;
    
    // Default constructor
    public Book() {
        this.available = true; // Default to available
    }
    
    // Constructor with all fields
    public Book(Integer id, String title, String author, String isbn, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available != null ? available : true;
    }
    
    // Getters and Setters (Encapsulation)
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Boolean getAvailable() {
        return available;
    }
    
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
    // Utility method to update availability
    public void toggleAvailability() {
        this.available = !this.available;
    }
    
    // Override equals and hashCode for proper object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
               Objects.equals(title, book.title) &&
               Objects.equals(author, book.author) &&
               Objects.equals(isbn, book.isbn) &&
               Objects.equals(available, book.available);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn, available);
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
} 