package my.dataframecourse.serviceNew;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Library")
public class Restfull {

    @Autowired
    private Library lib;

    @Autowired
    public Restfull(Library lib) {
        this.lib = lib;
    }

    void PostNote(String message){
        Note n = new Note();
        n.setMessage(message);
        n.setTime(new Date());
        String txt = ClientBuilder.newBuilder()
                .register(JacksonJsonProvider.class)
                .build()
                .target("http://localhost:8081")
                .path("/NotificationDesk/Notes")
                .request("application/json")
                .header("Content-Type", "application/json")
                .post(Entity.entity(n, MediaType.APPLICATION_JSON), String.class);
        System.out.println(txt);
    }

//    Restfull() {
//        lib.books = new ArrayList<Book>();
//        lib.writers = new ArrayList<Author>();
//
//        Author w = new Author("Лев", "Толстой", "Николаевич");
//
//        Book b = new Book();
//        b.setCaption("Война и мир");
//        b.setWriter(w);
//        lib.books.add(b);
//
//        Book b2 = new Book();
//        b2.setCaption("Живой труп");
//        b2.setWriter(w);
//        lib.books.add(b2);
//
//        Book b3 = new Book();
//        b3.setCaption("Анна Каренина");
//        b3.setWriter(w);
//        lib.books.add(b3);
//
//        lib.writers.add(w);
//    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public Library AsIs() {
        return lib;
    }

    @RequestMapping(
            value = "/Books",
            method = RequestMethod.GET)

    public List<Book> getBooks(@RequestParam(name = "search", required = false) String search) {
        PostNote("Найти книгу:" + search);
        if (search != null) {
            List<Book> foundBooks;
            foundBooks = new ArrayList<Book>();
            for (Book b : lib.books) {
                if (b.getCaption().toLowerCase().contains(search.toLowerCase()))
                    foundBooks.add(b);
            }
            return foundBooks;
        } else {
            return lib.books;
        }
    }


    @RequestMapping(
            value = "/Books/{caption}",
            method = RequestMethod.GET)
    public Book getBook(@PathVariable(name = "caption") String caption) {
        PostNote("Найти книгу: " + caption);
        for (Book b : lib.books) {
            if (b.getCaption().equalsIgnoreCase(caption))
                return b;
        }
        return null;
    }


    @RequestMapping(
            value = "/Authors",
            method = RequestMethod.GET)
    public List<Author> getWriters(@RequestParam(name = "search", required = false) String search) {
        PostNote("Найти автора:" + search);
        if (search != null) {
            List<Author> foundAuthors;
            foundAuthors = new ArrayList<Author>();
            for (Author a : lib.writers) {
                if (a.getName().toLowerCase().contains(search.toLowerCase()) ||
                        a.getLastName().toLowerCase().contains(search.toLowerCase()) ||
                        a.getPatronymic().toLowerCase().contains(search.toLowerCase()))
                    foundAuthors.add(a);
            }
            return foundAuthors;
        } else
            return lib.getWriters();
    }

    @RequestMapping(
            value = "/Authors/{LastName}",
            method = RequestMethod.GET
    )
    public Antology getAntology(@PathVariable("LastName") String LastName) {
        PostNote("Получить все книги автора " +LastName);
        for (Author a : lib.writers)
            if (a.getLastName().equalsIgnoreCase(LastName))
                return new Antology(a, lib.books);
        return new Antology(new Author(null, LastName, null), lib.books);
    }
}
