package com.library.service;
import com.library.model.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LibraryService {

// 1. Basic Retrieval
    List<Book> getAllBooks();
    Optional<Book> getBookById(int id);
    Optional<Book> findBookByTitle(String title);

// 2. Filtering and Searching
    List<Book> filterByGenre(String genre);
    List<Book> filterByAuthor(String author);
    List<Book> filterByPriceRange(double min, double max);
    List<Book> filterByLanguage(String language);
    List<Book> filterByPublicationYear(int year);
    List<Book> filterAvailableBooks();

// 3. Sorting
    List<Book> sortByTitleAsc();
    List<Book> sortByTitleDesc();
    List<Book> sortByPriceAsc();
    List<Book> sortByPriceDesc();
    List<Book> sortByPublicationYear();

// 4. Grouping and Aggregation
    Map<String,List<Book>>    groupBooksByAuthor();
    Map<String, List<Book>> groupBooksByGenre();
    double getAverageBookPrice();
    Map<String, Long> getBookCountByGenre();

// 5. Optional and Analytical Operations
    Optional<Book> findMostExpensiveBook();
    Optional<Book> findCheapestBook();
    Optional<Book> findNewestBook();
    Optional<Book> findOldestBook();
    long getTotalBookCount();
    boolean isBookAvailable(String title);

// 6. Update and Raintenance (In-Memory)
    void addBook(Book book);
    boolean updateBookAvailability(int id, boolean status);
    boolean removeBook(int id);

//7. Utility / Miscellaneous
    List<String> getDistinctAuthors();
    List<String> getDistinctGenres();
    void getBooksSummary();

}

 