package com.library.main;

import com.library.filesystem.FileManager;
import com.library.model.Book;

import com.library.service.LibraryService;
import com.library.service.LibraryServicesImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class LibraryApp {

   private static final Logger logger = Logger.getLogger(LibraryApp.class.getName());
   private static final Scanner scanner = new Scanner(System.in);
   private static final LibraryService service = new LibraryServicesImpl();
   private static final FileManager file = new FileManager();
   
   public static void main(String[] args) {
       logger.info("Library Management System started.");
       boolean running = true;

       while (running) {
           printMenu();
           System.out.println();
           System.out.print("Enter your choice:  ");
           int choice = scanner.nextInt();
           scanner.nextLine(); // consume newline

           switch (choice) {
           
       //  LIBRARY MANAGEMENT SYSTEM
           case 1:
               getAllBooks();
               break;
           case 2:
               searchBookByid();
               break;
           case 3:
               searchBookByTitle();
               break;
           case 4:
               filterBooksByGenre();
               break;
           case 5:
               filterBooksByauthor();
               break;
           case 6:
               filterBooksBylanguage();
               break;
           case 7:
               filterBooksBypublicationyear();
               break;
           case 8:
               filterAvailableBooks();
               break;
               
           //  Sorting Operations
           case 9:
               sortByTitleAsc();
               break;
           case 10:
               sortByTitleDesc();
               break;
           case 11:
               sortBooksByPriceltoh();
               break;
           case 12:
               sortBooksByPrice();
               break;
           case 13:
               sortByPublicationYear();
               break;
               
          // Grouping and Statistics      
           case 14:
               groupBooksByAuthor();
               break;
           case 15:
               groupBooksBygenre();
               break;
           case 16:
               getAverageBookPrice();
               break;
           case 17:
               getBookCountByGenre();
               break;
               
           // Analytical Operation
               
           case 18:
               findMostExpensiveBook();
               break;
           case 19:
               findCheapestBook();
               break;
           case 20:
               findNewestBook();
               break;
           case 21:
               findOldestBook();
               break;
           case 22:
               checkBookAvailability();
               break;
           case 23 :
               getTotalBookCount();
               break;
               
           // Book Management
               
           case 24:
               addNewBook();
               break;
           case 25:
               removeBook();
               break;
           case 26:
               updateAvailability();
               break;
               
           // Utility and Summary    
           case 27:
               getDistinctAuthors();
               break;    
           case 28:
               getDistinctGenres();
               break;
           case 29:
               showSummary();
               break;
           case 30:
               addOrUpdateBookLocally();
               break;
           case 31:
               loadBooks();
               break;
           case 32:
               logger.info("Exiting Library Management System.");
               running = false;
               break;
               
           default:
               System.out.println("Invalid choice. Please try again.");
       }
       }
   }

   private static void printMenu() {
       System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
       System.out.println();
       
       System.out.println("1. View all books");
       System.out.println("2. Search book by Id ");
       System.out.println("3. Search book by title");
       System.out.println("4. Filter books by genre");
       System.out.println("5. Filter books by Author ");
       System.out.println("6. Filter books by language ");
       System.out.println("7. Filter books by publication year ");
       System.out.println("8. View available books ");

       System.out.println("\n=== Sorting Operation ===");
       System.out.println();
       
       System.out.println("9. Sort books by title (A-Z)");
       System.out.println("10. Sort books by title (Z-A)");
       System.out.println("11. Sort books by price (Low to High)");
       System.out.println("12. Sort books by price (High to Low)");
       System.out.println("13. Sort books by publication year");
       
       System.out.println("\n=== Grouping and Statistics ===");
       System.out.println();
       
       System.out.println("14. Group books by author");
       System.out.println("15. Group books by genre");
       System.out.println("16. Get average book price");
       System.out.println("17. Get book count by genre");
      
       System.out.println("\n=== Analytical Operatins ===");
       System.out.println();
       
       System.out.println("18. Find most expensive bok ");
       System.out.println("19. Find cheapest book");
       System.out.println("20. Find newest book");
       System.out.println("21. Find oldest book");
       System.out.println("22. Check if a book is available by title");
       System.out.println("23. Get total number of books");
       
       System.out.println("\n=== Book Management ===");
       System.out.println();
       
       System.out.println("24. Add a new book");
       System.out.println("25. Remove a book by ID");
       System.out.println("26. Update book availability");
       
       System.out.println("\n=== Utility and Summary ===");
       System.out.println();
       System.out.println("27. View distinct authors");
       System.out.println("28. View district genres");
       System.out.println("29. Show summary");        
       
       System.out.println("30. Add or update book locally (file)");
       System.out.println("31. show book locally (file)");
       
       System.out.println("\n=== 31. Exit Application ! ===");

   }
   
   //  LIBRARY MANAGEMENT SYSTEM
   
   
   
   public static List<Book> getAllBooks() {
       return service.getAllBooks();
   }
   
   
//    private static void getAllBooks() {
//        List<Book> books = service.getAllBooks();
//        books.forEach(System.out::println);
//        logger.info("Listed all books. Count: " + books.size());
//    }
//    private static void getAllBooks() {
//        List<Book> books = service.getAllBooksdata();
//    }
   

    private static void searchBookByid() {
       System.out.print("Enter Book Id : ");
       int id = scanner.nextInt();
       Optional<Book> book = service.getBookById(id);
       book.ifPresentOrElse(
               System.out::println,
               () -> System.out.println("Book not found.")
       );
   }
   
   private static void searchBookByTitle() {
       System.out.print("Enter book title: ");
       String title = scanner.nextLine();
       Optional<Book> book = service.findBookByTitle(title);
       book.ifPresentOrElse(
               System.out::println,
               () -> System.out.println("Book not found.")
       );
   }
   
   private static void filterBooksByGenre() {
       System.out.print("Enter genre: ");
       String genre = scanner.nextLine();
       List<Book> books = service.filterByGenre(genre);
       books.forEach(System.out::println);
       logger.info("Filtered books by genre: " + genre + ". Count: " + books.size());
   }
   
   private static void filterBooksByauthor() {
       System.out.print("Enter Author: ");
       String author = scanner.nextLine();
       List<Book> books = service.filterByAuthor(author);
       books.forEach(System.out::println);
       logger.info("Filtered books by author: " + author + ". Count: " + books.size());
   }
   
   private static void filterBooksBylanguage() {
       System.out.print("Enter Language: ");
       String language = scanner.nextLine();
       List<Book> books = service.filterByLanguage(language);
       books.forEach(System.out::println);
       logger.info("Filtered books by language: " + language + ". Count: " + books.size());
   }
   
   private static void filterBooksBypublicationyear() {
       System.out.print("Enter Publication Year: ");
       int publicationyear = scanner.nextInt();
       List<Book> books = service.filterByPublicationYear(publicationyear);
       books.forEach(System.out::println);
       logger.info("Filtered books by Publication Year: " + publicationyear + ". Count: " + books.size());
   }
   
   private static void filterAvailableBooks() {
       List<Book> books = service.filterAvailableBooks();
       books.forEach(System.out::println);
       logger.info("View available books. " + books.size());
   }
   
   //  Sorting Operations
   
   private static void sortByTitleAsc() {
       List<Book> books = service.sortByTitleAsc();
       books.forEach(System.out::println);
   }
   
   private static void sortByTitleDesc() {
       List<Book> books = service.sortByTitleDesc();
       books.forEach(System.out::println);
   }
   
   private static void sortBooksByPriceltoh() {
       List<Book> books = service.sortByPriceAsc();
       books.forEach(System.out::println);
   }
   
   private static void sortByPublicationYear() {
       List<Book> books = service.sortByPublicationYear();
       books.forEach(System.out::println);
   }
   
   // Grouping and Statistics  
   
   private static void groupBooksByAuthor() {
       Map<String, List<Book>> grouped = service.groupBooksByAuthor();
       grouped.forEach((author, books) -> {
           System.out.println("\nAuthor: " + author);
           books.forEach(System.out::println);
       });
   }

   private static void groupBooksBygenre() {
       Map<String, List<Book>> grouped = service.groupBooksByGenre();
       grouped.forEach((genre, books) -> {
           System.out.println("\nGenre: " + genre);
           books.forEach(System.out::println);
       });
   }
   
   private static double getAverageBookPrice() {
       return service.getAverageBookPrice();
   }
   
   private static void getBookCountByGenre() {
       Map<String, Long> grouped = service.getBookCountByGenre();
       
       grouped.forEach((genre, count) -> {
           System.out.println("Genre: " + genre + ", Count: " + count);
       });
   }
   
   //  Analytical Operations
   private static void findMostExpensiveBook() {
       Optional<Book> book = service.findMostExpensiveBook();
       book.ifPresentOrElse(
               b -> System.out.println("Most expensive book:\n" + b),
               () -> System.out.println("No book found.")
       );
   }
   
   private static void findCheapestBook() {
       Optional<Book> book = service.findCheapestBook();
       book.ifPresentOrElse(
               b -> System.out.println("Most cheapest book:\n" + b),
               () -> System.out.println("No book found.")
       );
   }
   
   private static void findNewestBook() {
       Optional<Book> book = service.findNewestBook();
       book.ifPresentOrElse(
               b -> System.out.println("Most newest book:\n" + b),
               () -> System.out.println("No book found.")
       );
   }
   
   private static void findOldestBook() {
       Optional<Book> book = service.findOldestBook();
       book.ifPresentOrElse(
               b -> System.out.println("Most eoldest book:\n" + b),
               () -> System.out.println("No book found.")
       );
   }

   private static void sortBooksByPrice() {
       List<Book> books = service.sortByPriceDesc();
       books.forEach(System.out::println);
   }

   private static void checkBookAvailability() {
       System.out.print("Enter book title: ");
       String title = scanner.nextLine();
       boolean available = service.isBookAvailable(title);
       System.out.println("Availability: " + (available ? "Available" : "Not Available"));
   }
   
   private static long getTotalBookCount() {
       return service.getTotalBookCount();
   }
   
   
// Book Management
   
   private static void addNewBook() {
       System.out.print("Enter ID: ");
       int id = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter title: ");
       String title = scanner.nextLine();
       System.out.print("Enter author: ");
       String author = scanner.nextLine();
       System.out.print("Enter genre: ");
       String genre = scanner.nextLine();
       System.out.print("Enter price: ");
       double price = scanner.nextDouble();
       System.out.print("Enter publication year: ");
       int year = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter language: ");
       String language = scanner.nextLine();
       System.out.print("Enter total pages: ");
       int pages = scanner.nextInt();
       System.out.print("Is available (true/false): ");
       boolean available = scanner.nextBoolean();

       Book book = new Book(id, title, author, genre, price, year, language, pages, available);
       service.addBook(book);
       System.out.println("Book added successfully.");
       
       
          
       

   }

   private static void removeBook() {
       System.out.print("Enter book ID to remove: ");
       int id = scanner.nextInt();
       boolean removed = service.removeBook(id);
       System.out.println(removed ? "Book removed." : "Book not found.");
   }

   private static void updateAvailability() {
       System.out.print("Enter book ID: ");
       int id = scanner.nextInt();
       System.out.print("Enter new availability (true/false): ");
       boolean status = scanner.nextBoolean();
       boolean updated = service.updateBookAvailability(id, status);
       System.out.println(updated ? "Availability updated." : "Book not found.");
   }

// Utility and Summary    
   
   private static void getDistinctAuthors() {
       List<String> grouped = service.getDistinctAuthors();
       grouped.forEach((author) -> {
           System.out.println("\nAuthor: " + author);
          // books.forEach(System.out::println);
       });
   }
   
   private static void getDistinctGenres() {
       List<String> grouped = service.getDistinctGenres();
       grouped.forEach((genre) -> {
           System.out.println("\nGenre: " + genre);
        //   books.forEach(System.out::println);
       });
   }
   private static void showSummary() {
       service.getBooksSummary();
   }
   
   
   private static void addOrUpdateBookLocally() {
       System.out.print("Enter ID: ");
       int id = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter title: ");
       String title = scanner.nextLine();
       System.out.print("Enter author: ");
       String author = scanner.nextLine();
       System.out.print("Enter genre: ");
       String genre = scanner.nextLine();
       System.out.print("Enter price: ");
       double price = scanner.nextDouble();
       System.out.print("Enter publication year: ");
       int year = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter language: ");
       String language = scanner.nextLine();
       System.out.print("Enter total pages: ");
       int pages = scanner.nextInt();
       System.out.print("Is available (true/false): ");
       boolean available = scanner.nextBoolean();

       Book book = new Book(id, title, author, genre, price, year, language, pages, available);
       FileManager.addOrUpdateBook(book);
   }
   
   private static void loadBooks() {
       file.loadBooks();
   }
   
   
   
}

 

 