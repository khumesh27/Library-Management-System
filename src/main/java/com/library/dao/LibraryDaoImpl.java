package com.library.dao;

import com.library.datasource.LibraryDataSource;
import com.library.model.Book;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LibraryDaoImpl implements LibraryDao {

   private static final Logger logger = Logger.getLogger(LibraryDaoImpl.class.getName());
   private final List<Book> books = LibraryDataSource.getBooks();

   @Override
   public List<Book> getAllBooks() {
       logger.info("Fetching all books...");
       return new ArrayList<>(books);
   }

   @Override
   public Optional<Book> getBookById(int id) {
       logger.info("Searching book by ID: " + id);
       return books.stream()
               .filter(book -> book.getId() == id)
               .findFirst();
   }

   @Override
   public Optional<Book> findBookByTitle(String title) {
       logger.info("Searching book by title: " + title);
       return books.stream()
               .filter(book -> book.getTitle().equalsIgnoreCase(title))
               .findFirst();
   }

   @Override
   public List<Book> getBooksByGenre(String genre) {
       logger.info("Filtering books by genre: " + genre);
       return books.stream()
               .filter(book -> book.getGenre().equalsIgnoreCase(genre))
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksByAuthor(String author) {
       logger.info("Filtering books by author: " + author);
       return books.stream()
               .filter(book -> book.getAuthor().equalsIgnoreCase(author))
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksByPriceRange(double min, double max) {
       logger.info("Filtering books by price range: " + min + " - " + max);
       return books.stream()
               .filter(book -> book.getPrice() >= min && book.getPrice() <= max)
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksByLanguage(String language) {
       logger.info("Filtering books by language: " + language);
       return books.stream()
               .filter(book -> book.getLanguage().equalsIgnoreCase(language))
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getAvailableBooks() {
       logger.info("Filtering available books...");
       return books.stream()
               .filter(Book::isAvailable)
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksByPublicationYear(int year) {
       logger.info("Filtering books by publication year: " + year);
       return books.stream()
               .filter(book -> book.getPublicationYear() == year)
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksSortedByTitleAsc() {
       logger.info("Sorting books by title (A-Z)");
       return books.stream()
               .sorted(Comparator.comparing(Book::getTitle))
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksSortedByTitleDesc() {
       logger.info("Sorting books by title (Z-A)");
       return books.stream()
               .sorted(Comparator.comparing(Book::getTitle).reversed())
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksSortedByPriceAsc() {
       logger.info("Sorting books by price (Low to High)");
       return books.stream()
               .sorted(Comparator.comparingDouble(Book::getPrice))
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksSortedByPriceDesc() {
       logger.info("Sorting books by price (High to Low)");
       return books.stream()
               .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
               .collect(Collectors.toList());
   }

   @Override
   public List<Book> getBooksSortedByPublicationYear() {
       logger.info("Sorting books by publication year");
       return books.stream()
               .sorted(Comparator.comparingInt(Book::getPublicationYear))
               .collect(Collectors.toList());
   }

   @Override
   public Map<String, List<Book>> getBooksGroupedByAuthor() {
       logger.info("Grouping books by author");
       return books.stream()
               .collect(Collectors.groupingBy(Book::getAuthor));
   }

   @Override
   public Map<String, List<Book>> getBooksGroupedByGenre() {
       logger.info("Grouping books by genre");
       return books.stream()
               .collect(Collectors.groupingBy(Book::getGenre));
   }

   @Override
   public double calculateAverageBookPrice() {
       double avg = books.stream()
               .mapToDouble(Book::getPrice)
               .average()
               .orElse(0.0);
       logger.info("Average book price: " + avg);
       return avg;
   }

   @Override
   public Map<String, Long> getBookCountByGenre() {
       logger.info("Counting books by genre");
       return books.stream()
               .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
   }

   @Override
   public Optional<Book> getMostExpensiveBook() {
       Optional<Book> book = books.stream()
               .max(Comparator.comparingDouble(Book::getPrice));
       logger.info(book.map(b -> "Most expensive book: " + b).orElse("No book found"));
       return book;
   }

   @Override
   public Optional<Book> getCheapestBook() {
       Optional<Book> book = books.stream()
               .min(Comparator.comparingDouble(Book::getPrice));
       logger.info(book.map(b -> "Cheapest book: " + b).orElse("No book found"));
       return book;
   }

   @Override
   public Optional<Book> getNewestBook() {
       Optional<Book> book = books.stream()
               .max(Comparator.comparingInt(Book::getPublicationYear));
       logger.info(book.map(b -> "Newest book: " + b).orElse("No book found"));
       return book;
   }

   @Override
   public Optional<Book> getOldestBook() {
       Optional<Book> book = books.stream()
               .min(Comparator.comparingInt(Book::getPublicationYear));
       logger.info(book.map(b -> "Oldest book: " + b).orElse("No book found"));
       return book;
   }

   @Override
   public long getTotalBookCount() {
       long count = books.size();
       logger.info("Total book count: " + count);
       return count;
   }

   @Override
   public boolean checkBookAvailability(String title) {
       boolean available = books.stream()
               .anyMatch(book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable());
       logger.info("Book '" + title + "' availability: " + available);
       return available;
   }

   @Override
   public void addBook(Book book) {
       books.add(book);
       logger.info("Book added: " + book);
   }

   @Override
   public boolean removeBook(int id) {
       boolean removed = books.removeIf(book -> book.getId() == id);
       logger.info("Book removal (ID: " + id + "): " + (removed ? "Success" : "Failed"));
       return removed;
   }

   @Override
   public boolean updateBookAvailability(int id, boolean status) {
       Optional<Book> bookOpt = getBookById(id);
       if (bookOpt.isPresent()) {
           bookOpt.get().setAvailable(status);
           logger.info("Updated availability for book ID " + id + " to " + status);
           return true;
       } else {
           logger.warning("Book ID " + id + " not found for availability update.");
           return false;
       }
   }

   @Override
   public List<String> getDistinctAuthors() {
       logger.info("Fetching distinct authors");
       return books.stream()
               .map(Book::getAuthor)
               .distinct()
               .collect(Collectors.toList());
   }

   @Override
   public List<String> getDistinctGenres() {
       logger.info("Fetching distinct genres");
       return books.stream()
               .map(Book::getGenre)
               .distinct()
               .collect(Collectors.toList());
   }

   @Override
   public void printBooksSummary() {
       logger.info("Printing books summary...");
       System.out.println("Total Books: " + getTotalBookCount());
       System.out.println("Average Price: " + calculateAverageBookPrice());
       System.out.println("Books by Genre: " + getBookCountByGenre());
   }
}