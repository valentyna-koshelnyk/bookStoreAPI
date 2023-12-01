package org.example.service;

import org.example.model.Books;

import java.util.List;

public class BooksDAO implements BoooksService{
    private static final String ADD_BOOK = "INSERT INTO books (title, author, price, quantity) " +
            "VALUES (?, ?, ?, ?";
    private static final String SELECT_BOOKS = "SELECT * FROM books";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_BOOK_BY_PRICE = "SELECT * FROM books " +
                "WHERE Price BETWEEN ? AND ?";
    private static final String SELECT_BOOK_BY_AUTHOR = "SELECT * FROM books " +
            "WHERE Author=?";
    private static final String DELETE_BY_ID = "DELETE FROM books WHERE ID = ?";
    private static final String UPDATE_BOOK =  "UPDATE books SET title = ?, " +
            "author = ?, price = ?, quantity = ?";

    @Override
    public void addBook(Books book) {
        try (Connection connection = DBConnection.getConnection()) {

        }

    @Override
    public List<Books> getAllBooks() {
        return null;
    }

    @Override
    public Books getBookById(String id) {
        return null;
    }

    @Override
    public List<Books> getBooksByPriceRange(double minPrice, double maxPrice) {
        return null;
    }

    @Override
    public List<Books> getBooksByAuthor(String author) {
        return null;
    }

    @Override
    public void deleteBook(String id) {

    }

    @Override
    public void updateBook(Books book) {

    }
}
