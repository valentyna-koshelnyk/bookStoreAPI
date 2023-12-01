package org.example.service;

import org.example.model.Books;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO implements BoooksService {
    private static final String ADD_BOOK = "INSERT INTO books (title, author, price, quantity) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_BOOKS = "SELECT * FROM books";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_BOOK_BY_PRICE = "SELECT * FROM books " +
            "WHERE Price BETWEEN ? AND ?";
    private static final String SELECT_BOOK_BY_AUTHOR = "SELECT * FROM books " +
            "WHERE Author=?";
    private static final String DELETE_BY_ID = "DELETE FROM books WHERE ID = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, " +
            "author = ?, price = ?, quantity = ?";

    @Override
    public void addBook(Books book) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(ADD_BOOK);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Books> getAllBooks() {
        List<Books> allBooks = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_BOOKS);
            while (rs.next()) {
                Books book = new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
                allBooks.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allBooks;
    }

    @Override
    public Books getBookById(String id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BY_ID);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Books> getBooksByPriceRange(double minPrice, double maxPrice) {
        List<Books> booksList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BY_PRICE);
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Books book = new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
                booksList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booksList;
    }


    @Override
    public List<Books> getBooksByAuthor(String author) {
        List<Books> booksList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_BY_AUTHOR);
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Books book = new Books(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
                booksList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booksList;
    }

    @Override
    public void deleteBook(String id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(Books book) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

