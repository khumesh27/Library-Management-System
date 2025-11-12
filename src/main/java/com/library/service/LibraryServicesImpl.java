package com.library.service;

import com.library.dao.LibraryDao;
import com.library.dao.LibraryDaoImpl;
import com.library.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class LibraryServicesImpl implements LibraryService {

   private static final Logger logger = Logger.getLogger(LibraryServicesImpl.class.getName());
   private final LibraryDao dao;

   public LibraryServicesImpl() {
       this.dao = new LibraryDaoImpl();
       logger.info("LibraryService initialized with DAO implementation.");
   }

   @Override
   public List<Book> getAllBooks() {
       return dao.getAllBooks();
   }

   @Override
   public Optional<Book> getBookById(int id) {
       return dao.getBookById(id);
   }

   @Override
   public Optional<Book> findBookByTitle(String title) {
       return dao.findBookByTitle(title);
   }

   @Override
   public List<Book> filterByGenre(String genre) {
       return dao.getBooksByGenre(genre);
   }

   @Override
   public List<Book> filterByAuthor(String author) {
       return dao.getBooksByAuthor(author);
   }

   @Override
   public List<Book> filterByPriceRange(double min, double max) {
       return dao.getBooksByPriceRange(min, max);
   }

   @Override
   public List<Book> filterByLanguage(String language) {
       return dao.getBooksByLanguage(language);
   }

   @Override
   public List<Book> filterAvailableBooks() {
       return dao.getAvailableBooks();
   }

   @Override
   public List<Book> filterByPublicationYear(int year) {
       return dao.getBooksByPublicationYear(year);
   }

   @Override
   public List<Book> sortByTitleAsc() {
       return dao.getBooksSortedByTitleAsc();
   }

   @Override
   public List<Book> sortByTitleDesc() {
       return dao.getBooksSortedByTitleDesc();
   }

   @Override
   public List<Book> sortByPriceAsc() {
       return dao.getBooksSortedByPriceAsc();
   }

   @Override
   public List<Book> sortByPriceDesc() {
       return dao.getBooksSortedByPriceDesc();
   }

   @Override
   public List<Book> sortByPublicationYear() {
       return dao.getBooksSortedByPublicationYear();
   }

   @Override
   public Map<String, List<Book>> groupBooksByAuthor() {
       return dao.getBooksGroupedByAuthor();
   }

   @Override
   public Map<String, List<Book>> groupBooksByGenre() {
       return dao.getBooksGroupedByGenre();
   }

   @Override
   public double getAverageBookPrice() {
       return dao.calculateAverageBookPrice();
   }

   @Override
   public Map<String, Long> getBookCountByGenre() {
       return dao.getBookCountByGenre();
   }

   @Override
   public Optional<Book> findMostExpensiveBook() {
       return dao.getMostExpensiveBook();
   }

   @Override
   public Optional<Book> findCheapestBook() {
       return dao.getCheapestBook();
   }

   @Override
   public Optional<Book> findNewestBook() {
       return dao.getNewestBook();
   }

   @Override
   public Optional<Book> findOldestBook() {
       return dao.getOldestBook();
   }

   @Override
   public long getTotalBookCount() {
       return dao.getTotalBookCount();
   }

   @Override
   public boolean isBookAvailable(String title) {
       return dao.checkBookAvailability(title);
   }

   @Override
   public void addBook(Book book) {
       dao.addBook(book);
   }

   @Override
   public boolean removeBook(int id) {
       return dao.removeBook(id);
   }

   @Override
   public boolean updateBookAvailability(int id, boolean status) {
       return dao.updateBookAvailability(id, status);
   }

   @Override
   public List<String> getDistinctAuthors() {
       return dao.getDistinctAuthors();
   }

   @Override
   public List<String> getDistinctGenres() {
       return dao.getDistinctGenres();
   }

   @Override
   public void getBooksSummary() {
       dao.printBooksSummary();
   }
}