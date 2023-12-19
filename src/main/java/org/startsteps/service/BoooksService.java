package org.startsteps.service;

import org.startsteps.model.Books;

import java.util.List;

public interface BoooksService {
    void addBook(Books book);
    List<Books> getAllBooks();
    Books getBookById(String id);
    List<Books> getBooksByPriceRange(double minPrice, double maxPrice);
    List<Books> getBooksByAuthor(String author);
    void deleteBook(String id);
    void updateBook(Books book);


}
