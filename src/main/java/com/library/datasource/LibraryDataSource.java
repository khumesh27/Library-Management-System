package com.library.datasource;

import com.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryDataSource {

   private static final List<Book> books = new ArrayList<>();

   static {
       books.add(new Book(1, "The White Tiger", "Aravind Adiga", "Fiction", 350.0, 2008, "English", 321, true));
       books.add(new Book(2, "Wings of Fire", "A.P.J. Abdul Kalam", "Autobiography", 299.0, 1999, "English", 180, true));
       books.add(new Book(3, "The God of Small Things", "Arundhati Roy", "Fiction", 399.0, 1997, "English", 340, true));
       books.add(new Book(4, "Train to Pakistan", "Khushwant Singh", "Historical Fiction", 280.0, 1956, "English", 260, false));
       books.add(new Book(5, "Malgudi Days", "R.K. Narayan", "Short Stories", 250.0, 1943, "English", 242, true));
       books.add(new Book(6, "Discovery of India", "Jawaharlal Nehru", "History", 499.0, 1946, "English", 595, true));
       books.add(new Book(7, "Gitanjali", "Rabindranath Tagore", "Poetry", 150.0, 1910, "Bengali", 120, true));
       books.add(new Book(8, "The Guide", "R.K. Narayan", "Fiction", 320.0, 1958, "English", 250, true));
       books.add(new Book(9, "Interpreter of Maladies", "Jhumpa Lahiri", "Short Stories", 370.0, 1999, "English", 198, false));
       books.add(new Book(10, "A Suitable Boy", "Vikram Seth", "Romance", 599.0, 1993, "English", 1349, true));
       books.add(new Book(11, "The Inheritance of Loss", "Kiran Desai", "Fiction", 420.0, 2006, "English", 324, true));
       books.add(new Book(12, "Shiva Trilogy: The Immortals of Meluha", "Amish Tripathi", "Mythology", 350.0, 2010, "English", 389, true));
       books.add(new Book(13, "Chanakya's Chant", "Ashwin Sanghi", "Thriller", 275.0, 2011, "English", 448, true));
       books.add(new Book(14, "The Palace of Illusions", "Chitra Banerjee Divakaruni", "Mythology", 330.0, 2008, "English", 360, false));
       books.add(new Book(15, "Half Girlfriend", "Chetan Bhagat", "Romance", 199.0, 2014, "English", 260, true));
       books.add(new Book(16, "The Monk Who Sold His Ferrari", "Robin Sharma", "Self-Help", 299.0, 1997, "English", 224, true));
       books.add(new Book(17, "Life of Pi", "Yann Martel", "Adventure", 350.0, 2001, "English", 348, true));
       books.add(new Book(18, "The 3 Mistakes of My Life", "Chetan Bhagat", "Fiction", 180.0, 2008, "English", 260, true));
       books.add(new Book(19, "Rich Dad Poor Dad", "Robert T. Kiyosaki", "Finance", 399.0, 1997, "English", 336, true));
       books.add(new Book(20, "Ikigai", "Hector Garcia", "Self-Help", 450.0, 2016, "English", 208, true));
       books.add(new Book(21, "Atomic Habits", "James Clear", "Self-Help", 550.0, 2018, "English", 320, true));
       books.add(new Book(22, "The Alchemist", "Paulo Coelho", "Fiction", 299.0, 1988, "English", 197, false));
       books.add(new Book(23, "You Can Win", "Shiv Khera", "Motivational", 250.0, 1998, "English", 306, true));
       books.add(new Book(24, "2 States", "Chetan Bhagat", "Romance", 199.0, 2009, "English", 272, false));
       books.add(new Book(25, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "History", 699.0, 2014, "English", 498, true));
       books.add(new Book(26, "The Power of Now", "Eckhart Tolle", "Spirituality", 499.0, 1997, "English", 236, true));
       books.add(new Book(27, "Think Like a Monk", "Jay Shetty", "Self-Help", 475.0, 2020, "English", 328, true));
       books.add(new Book(28, "One Indian Girl", "Chetan Bhagat", "Romance", 199.0, 2016, "English", 272, true));
       books.add(new Book(29, "The Great Indian Novel", "Shashi Tharoor", "Satire", 375.0, 1989, "English", 423, true));
       books.add(new Book(30, "The Blue Umbrella", "Ruskin Bond", "Children", 150.0, 1974, "English", 90, true));
   }

   public static List<Book> getBooks() {
       return books;
   }
}
