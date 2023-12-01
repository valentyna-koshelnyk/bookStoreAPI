package org.startsteps.data;

import org.startsteps.model.Books;
import org.startsteps.service.BooksDAO;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

public class BooksStorage {
    public void addbooks(){
        BooksDAO booksDAO = new BooksDAO();
        List<Books> books = generateBooks();
        for (Books book : books){
            booksDAO.addBook(book);
        }
    }

    public List<Books> generateBooks(){
        List<Books> books = new ArrayList<>();
        books.add(new Books(1, "The Great Gatsby", "F. Scott Fitzgerald", 10.99, 50));
        books.add(new Books(2, "To Kill a Mockingbird", "Harper Lee", 12.50, 30));
        books.add(new Books(3, "1984", "George Orwell", 9.99, 40));
        books.add(new Books(4, "Brave New World", "Aldous Huxley", 11.75, 25));
        books.add(new Books(5, "The Catcher in the Rye", "J.D. Salinger", 8.95, 35));
        books.add(new Books(6, "Moby-Dick", "Herman Melville", 14.25, 20));
        books.add(new Books(7, "Pride and Prejudice", "Jane Austen", 9.50, 45));
        books.add(new Books(8, "The Hobbit", "J.R.R. Tolkien", 15.99, 28));
        books.add(new Books(9, "The Lord of the Rings", "J.R.R. Tolkien", 24.99, 15));
        books.add(new Books(10, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 18.50, 32));
        books.add(new Books(11, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 19.75, 29));
        books.add(new Books(12, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 20.90, 26));
        books.add(new Books(13, "The Shining", "Stephen King", 16.80, 38));
        books.add(new Books(14, "The Stand", "Stephen King", 22.50, 22));
        books.add(new Books(15, "The Da Vinci Code", "Dan Brown", 13.45, 42));
        books.add(new Books(16, "Angels & Demons", "Dan Brown", 14.75, 37));
        books.add(new Books(17, "The Girl with the Dragon Tattoo", "Stieg Larsson", 17.20, 31));
        books.add(new Books(18, "The Hunger Games", "Suzanne Collins", 11.30, 48));
        books.add(new Books(19, "Catching Fire", "Suzanne Collins", 12.60, 33));
        books.add(new Books(20, "Mockingjay", "Suzanne Collins", 13.80, 29));
        books.add(new Books(21, "The Alchemist", "Paulo Coelho", 15.25, 27));
        books.add(new Books(22, "The Road", "Cormac McCarthy", 14.99, 25));
        books.add(new Books(23, "The Kite Runner", "Khaled Hosseini", 11.45, 36));
        books.add(new Books(24, "A Thousand Splendid Suns", "Khaled Hosseini", 12.75, 30));
        books.add(new Books(25, "The Martian", "Andy Weir", 19.99, 20));
        books.add(new Books(26, "Dune", "Frank Herbert", 18.50, 24));
        books.add(new Books(27, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 10.20, 40));
        books.add(new Books(28, "Ender's Game", "Orson Scott Card", 14.50, 32));
        books.add(new Books(29, "The Chronicles of Narnia", "C.S. Lewis", 16.75, 18));
        books.add(new Books(30, "The Grapes of Wrath", "John Steinbeck", 12.95, 35));
        return books;
    }

}
