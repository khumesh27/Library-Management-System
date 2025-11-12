package com.library.model;

public class Book {

	private int id;

	private String title;

	private String author;

	private String genre;

	private double price;

	private int publicationYear;

	private String language;

	private int totalPages;

	private boolean available;

	public Book(int id, String title, String author, String genre, double price, int publicationYear, String language,

			int totalPages, boolean available) {

		super();

		this.id = id;

		this.title = title;

		this.author = author;

		this.genre = genre;

		this.price = price;

		this.publicationYear = publicationYear;

		this.language = language;

		this.totalPages = totalPages;

		this.available = available;

	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

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

	public String getGenre() {

		return genre;

	}

	public void setGenre(String genre) {

		this.genre = genre;

	}

	public double getPrice() {

		return price;

	}

	public void setPrice(double price) {

		this.price = price;

	}

	public int getPublicationYear() {

		return publicationYear;

	}

	public void setPublicationYear(int publicationYear) {

		this.publicationYear = publicationYear;

	}

	public String getLanguage() {

		return language;

	}

	public void setLanguage(String language) {

		this.language = language;

	}

	public int getTotalPages() {

		return totalPages;

	}

	public void setTotalPages(int totalPages) {

		this.totalPages = totalPages;

	}

	public boolean isAvailable() {

		return available;

	}

	public void setAvailable(boolean available) {

		this.available = available;

	}

	@Override

	public String toString() {

		return String.format(

				"Book{id=%d, title='%s', author='%s', genre='%s', price=%.2f, publisher='%s', language='%s', pages=%d, available=%b}",

				id, title, author, genre, price, publicationYear, language, totalPages, available);

	}

//publisher,

}