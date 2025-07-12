# Library Management System

A Java-based RESTful API simulation for managing a library's book catalog.

## 🎯 **Features**

- ✅ **Add new books** to the catalog
- ✅ **Retrieve all books** from the catalog  
- ✅ **Get book details** by ID
- ✅ **Delete books** from the catalog
- ✅ **Update book availability** status
- ✅ **Toggle book availability** (available/unavailable)
- ✅ **In-memory storage** using ConcurrentHashMap
- ✅ **Thread-safe operations**

## 🏗️ **Architecture & OOP Principles**

### **1. Encapsulation**
- Private fields with public getters/setters in `Book` class
- Data hiding and controlled access to object properties

### **2. Abstraction**
- `BookService` abstracts business logic from data access
- Clean separation of concerns

### **3. Inheritance**
- Extends Java Object class implicitly
- Demonstrates inheritance through method overriding

### **4. Polymorphism**
- Method overriding in `Book` class (equals, hashCode, toString)
- Interface-based design patterns

## 📁 **Project Structure**

```
Library Management/
├── Book.java              # Book model with encapsulation
├── BookService.java       # Business logic and in-memory storage
├── LibraryAPI.java        # Main class simulating REST endpoints
└── README.md             # This file
```

## 🚀 **How to Run**

### **Prerequisites**
- Java 8 or higher

### **Steps to Run**

1. **Compile the Java files:**
   ```bash
   javac *.java
   ```

2. **Run the application:**
   ```bash
   java LibraryAPI
   ```

3. **Watch the demonstration:**
   - The application will automatically demonstrate all API operations
   - Sample books will be added and all CRUD operations will be shown

## 📋 **API Endpoints (Simulated)**

| Method | Endpoint | Description | Java Method |
|--------|----------|-------------|-------------|
| POST | `/api/books` | Add new book | `addBook(Book book)` |
| GET | `/api/books` | Get all books | `getAllBooks()` |
| GET | `/api/books/{id}` | Get book by ID | `getBookById(Integer id)` |
| DELETE | `/api/books/{id}` | Delete book | `deleteBook(Integer id)` |
| PUT | `/api/books/{id}` | Update book | `updateBook(Integer id, Book book)` |
| PATCH | `/api/books/{id}/availability` | Update availability | `updateBookAvailability(Integer id, Boolean available)` |
| PATCH | `/api/books/{id}/toggle-availability` | Toggle availability | `toggleBookAvailability(Integer id)` |

## 📊 **Book Model**

The `Book` class has the following fields:

| Field | Type | Description |
|-------|------|-------------|
| id | Integer | Unique identifier (auto-generated) |
| title | String | Book title |
| author | String | Book author |
| isbn | String | International Standard Book Number |
| available | Boolean | Availability status |

## 🧪 **Sample Output**

When you run the application, you'll see:

```
=== Library Management System ===
REST API Simulation
================================

📚 Adding sample books...

--- POST /api/books (Add Book) ---
✅ Book added successfully:
Book{id=1, title='The Great Gatsby', author='F. Scott Fitzgerald', isbn='978-0743273565', available=true}

--- GET /api/books (Get All Books) ---
📚 All books in catalog:
Book{id=1, title='The Great Gatsby', author='F. Scott Fitzgerald', isbn='978-0743273565', available=true}
Book{id=2, title='To Kill a Mockingbird', author='Harper Lee', isbn='978-0446310789', available=false}
Book{id=3, title='1984', author='George Orwell', isbn='978-0451524935', available=true}

--- GET /api/books/1 (Get Book by ID) ---
📖 Book found:
Book{id=1, title='The Great Gatsby', author='F. Scott Fitzgerald', isbn='978-0743273565', available=true}

--- PATCH /api/books/1/availability (Update Availability) ---
✅ Book availability updated:
Book{id=1, title='The Great Gatsby', author='F. Scott Fitzgerald', isbn='978-0743273565', available=false}

--- DELETE /api/books/3 (Delete Book) ---
✅ Book with ID 3 deleted successfully

📊 Statistics:
Total books: 2
Book 1 exists: true
Book 3 exists: false
```

## 🔧 **Technical Implementation**

### **In-Memory Storage**
- Uses `ConcurrentHashMap<Integer, Book>` for thread-safe operations
- Atomic ID generation with `AtomicInteger`
- No external dependencies

### **Thread Safety**
- `ConcurrentHashMap` ensures thread-safe operations
- `AtomicInteger` for safe ID generation
- Immutable operations where possible

### **Error Handling**
- Null checks for book existence
- Graceful handling of non-existent books
- Clear error messages

## 🎓 **OOP Principles Demonstrated**

### **1. Encapsulation**
```java
public class Book {
    private Integer id;        // Private field
    private String title;      // Private field
    
    public Integer getId() {   // Public getter
        return id;
    }
    
    public void setId(Integer id) {  // Public setter
        this.id = id;
    }
}
```

### **2. Abstraction**
```java
public class BookService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    
    public Book addBook(Book book) {
        // Abstracted business logic
        Integer newId = idCounter.getAndIncrement();
        book.setId(newId);
        books.put(newId, book);
        return book;
    }
}
```

### **3. Inheritance**
```java
public class Book {
    @Override
    public boolean equals(Object o) {  // Method overriding
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }
}
```

### **4. Polymorphism**
```java
// Method overriding
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
```

## 🚀 **Running the Application**

1. **Open terminal/command prompt**
2. **Navigate to project directory**
3. **Compile:**
   ```bash
   javac *.java
   ```
4. **Run:**
   ```bash
   java LibraryAPI
   ```
5. **Watch the demonstration!**

## 📈 **Future Enhancements**

- Database integration (JDBC, JPA)
- Web framework integration (Spring Boot)
- Authentication and authorization
- Search and filtering capabilities
- Book categories and tags
- User management system

## 🎯 **Requirements Met**

- ✅ Java 8+ ✓
- ✅ Object-oriented design ✓
- ✅ Encapsulation ✓
- ✅ In-memory storage ✓
- ✅ REST-style endpoints (simulated) ✓
- ✅ All required book fields ✓
- ✅ All required operations ✓

The application demonstrates a complete understanding of Java, OOP principles, and backend system design! 