package com.library.main;

import com.library.model.Book;

import com.library.service.LibraryService;

import com.library.service.LibraryServicesImpl;

import java.util.List;

import java.util.Map;

import java.util.Optional;

import java.util.Scanner;

import java.util.logging.Logger;

public class App {

	private static final Logger logger = Logger.getLogger(LibraryApp.class.getName());

	private static final Scanner scanner = new Scanner(System.in);

	private static final LibraryService service = new LibraryServicesImpl();

	public static void main(String[] args) {

		logger.info("Library Management System started.");

		boolean running = true;

		while (running) {

			printMenu();

			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			scanner.nextLine(); // consume newline

			switch (choice) {

			case 1:

				listAllBooks();

				break;

			case 2:

				searchBookByTitle();

				break;

			case 3:

				filterBooksByGenre();

				break;

			case 4:

				groupBooksByAuthor();

				break;

			case 5:

				findMostExpensiveBook();

				break;

			case 6:

				sortBooksByPrice();

				break;

			case 7:

				checkBookAvailability();

				break;

			case 8:

				addNewBook();

				break;

			case 9:

				removeBook();

				break;

			case 10:

				updateAvailability();

				break;

			case 11:

				showSummary();

				break;

			case 0:

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

		System.out.println("1. List all books");

		System.out.println("2. Search book by title");

		System.out.println("3. Filter books by genre");

		System.out.println("4. Group books by author");

		System.out.println("5. Find most expensive book");

		System.out.println("6. Sort books by price (High to Low)");

		System.out.println("7. Check book availability by title");

		System.out.println("8. Add a new book");

		System.out.println("9. Remove a book by ID");

		System.out.println("10. Update book availability");

		System.out.println("11. Show summary");

		System.out.println("0. Exit");

	}

	private static void listAllBooks() {

		List<Book> books = service.getAllBooks();

		books.forEach(System.out::println);

		logger.info("Listed all books. Count: " + books.size());

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

	private static void groupBooksByAuthor() {

		Map<String, List<Book>> grouped = service.groupBooksByAuthor();

		grouped.forEach((author, books) -> {

			System.out.println("\nAuthor: " + author);

			books.forEach(System.out::println);

		});

	}

	private static void findMostExpensiveBook() {

		Optional<Book> book = service.findMostExpensiveBook();

		book.ifPresentOrElse(

				b -> System.out.println("Most expensive book:\n" + b),

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

	private static void showSummary() {

		service.getBooksSummary();

	}

}