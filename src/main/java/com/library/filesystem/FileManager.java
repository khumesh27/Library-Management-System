package com.library.filesystem;

import com.library.model.Book;

import java.io.*;
import java.util.*;

public class FileManager {

   private static final String FILE_NAME = "b.csv";

   // Load books from file
   public static Map<Integer, Book> loadBooks() {
       Map<Integer, Book> books = new HashMap<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(",");
               if (parts.length == 9) {
                   Book book = new Book(
                       Integer.parseInt(parts[0]),
                       parts[1],
                       parts[2],
                       parts[3],
                       Double.parseDouble(parts[4]),
                       Integer.parseInt(parts[5]),
                       parts[6],
                       Integer.parseInt(parts[7]),
                       Boolean.parseBoolean(parts[8])
                   );
                   books.put(book.getId(), book);
               }
           }
       } catch (IOException e) {
           System.err.println("Error reading file: " + e.getMessage());
       }
       return books;
   }

   // Save books to file
   public static void saveBooks(Map<Integer, Book> books) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
           for (Book book : books.values()) {
               writer.write(String.format("%d,%s,%s,%s,%.2f,%d,%s,%d,%b\n",
                   book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(),
                   book.getPrice(), book.getPublicationYear(), book.getLanguage(),
                   book.getTotalPages(), book.isAvailable()));
           }
       } catch (IOException e) {
           System.err.println("Error writing file: " + e.getMessage());
       }
   }

   // Add or update book
   public static void addOrUpdateBook(Book book) {
       Map<Integer, Book> books = loadBooks();
       books.put(book.getId(), book);
       saveBooks(books);
       System.out.println("Book saved locally to file.");
   }
}