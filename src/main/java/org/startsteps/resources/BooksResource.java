package org.startsteps.resources;
import org.startsteps.model.Books;
import org.startsteps.service.BooksDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path ("/books")
public class BooksResource {
    BooksDAO booksDAO = new BooksDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> getAllBooks() {
        return booksDAO.getAllBooks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Books getBookById(@PathParam("id") String id) {
        return booksDAO.getBookById(id);
    }

    @GET
    @Path("/filter-by-price")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> getBooksByPriceRange(@QueryParam("minPrice") double minPrice,
                                            @QueryParam("maxPrice") double maxPrice) {
        return booksDAO.getBooksByPriceRange(minPrice, maxPrice);
    }

    @GET
    @Path("/filter-by-author")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> getBooksByAuthor(@QueryParam("author") String author) {
        return booksDAO.getBooksByAuthor(author);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(Books book){
        booksDAO.addBook(book);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBook(@PathParam("id") int id, Books book){
        book.setId(id);
        booksDAO.updateBook(book);
    }

    @DELETE
    @Path("/{id}")

    public void deleteBook(@PathParam("id") String id){
        booksDAO.deleteBook(id);
    }

}
