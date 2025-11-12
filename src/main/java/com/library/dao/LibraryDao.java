package com.library.dao;

import com.library.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LibraryDao {

   // Basic Retrieval
   List<Book> getAllBooks();
   Optional<Book> getBookById(int id);
   Optional<Book> findBookByTitle(String title);

   // Filtering
   List<Book> getBooksByGenre(String genre);
   List<Book> getBooksByAuthor(String author);
   List<Book> getBooksByPriceRange(double min, double max);
   List<Book> getBooksByLanguage(String language);
   List<Book> getAvailableBooks();
   List<Book> getBooksByPublicationYear(int year);

   // Sorting
   List<Book> getBooksSortedByTitleAsc();
   List<Book> getBooksSortedByTitleDesc();
   List<Book> getBooksSortedByPriceAsc();
   List<Book> getBooksSortedByPriceDesc();
   List<Book> getBooksSortedByPublicationYear();

   // Grouping & Aggregation
   Map<String, List<Book>> getBooksGroupedByAuthor();
   Map<String, List<Book>> getBooksGroupedByGenre();
   double calculateAverageBookPrice();
   Map<String, Long> getBookCountByGenre();

   // Optional & Analytical
   Optional<Book> getMostExpensiveBook();
   Optional<Book> getCheapestBook();
   Optional<Book> getNewestBook();
   Optional<Book> getOldestBook();
   long getTotalBookCount();
   boolean checkBookAvailability(String title);

   // Update & Maintenance
   void addBook(Book book);
   boolean removeBook(int id);
   boolean updateBookAvailability(int id, boolean status);

   // Utility
   List<String> getDistinctAuthors();
   List<String> getDistinctGenres();
   void printBooksSummary();
}
 


