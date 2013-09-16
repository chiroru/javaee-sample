package jp.ddo.chiroru.javaee.sample.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.ddo.chiroru.javaee.sample.domain.Book;

@Path("books")
public class BookResources {

    @GET
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
}
