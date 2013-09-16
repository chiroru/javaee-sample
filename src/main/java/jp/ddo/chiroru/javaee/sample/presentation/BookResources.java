package jp.ddo.chiroru.javaee.sample.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.Email;

import jp.ddo.chiroru.javaee.sample.common.validation.validator.ValidCollection;
import jp.ddo.chiroru.javaee.sample.domain.Book;

@Path("")
public class BookResources {

    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book b = new Book();
        b.setId(1);
        b.setName("name1");
        b.setDescription("description1");
        b.setBookshelfId(1);
        b.setPicture("picture1");
        b.setVolume(1);
        books.add(b);
        return books;
    }

    @GET
    @Path("books/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@Min(5) @PathParam("id") String id,
            @ValidCollection(elementType=String.class, constraints={Email.class}) @QueryParam("mail") List<String> mails) {
        Book b = new Book();
        b.setId(1);
        b.setName("name1");
        b.setDescription("description1");
        b.setBookshelfId(1);
        b.setPicture("picture1");
        b.setVolume(1);
        return b;
    }
}
