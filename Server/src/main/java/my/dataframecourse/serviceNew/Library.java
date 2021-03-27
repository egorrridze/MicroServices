package my.dataframecourse.serviceNew;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Library {
    List<Book> books;
    List<Author> writers;

    Library(){
        this.books = new ArrayList<Book>();
        this.writers = new ArrayList<Author>();

        Author w = new Author("Лев", "Толстой", "Николаевич");

        Book b = new Book();
        b.setCaption("Война и мир");
        b.setWriter(w);
        this.books.add(b);

        Book b2 = new Book();
        b2.setCaption("Живой труп");
        b2.setWriter(w);
        this.books.add(b2);

        Book b3 = new Book();
        b3.setCaption("Анна Каренина");
        b3.setWriter(w);
        this.books.add(b3);

        this.writers.add(w);


        w = new Author("Фёдор", "Достоевский", "Михайлович");
        b = new Book();
        b.setCaption("Братья Карамазовы");
        b.setWriter(w);
        this.books.add(b);

        b2 = new Book();
        b2.setCaption("Идиот");
        b2.setWriter(w);
        this.books.add(b2);

        b3 = new Book();
        b3.setCaption("Преступление и наказание");
        b3.setWriter(w);
        this.books.add(b3);

        this.writers.add(w);


        w = new Author("Максим", "Горький", "");
        b = new Book();
        b.setCaption("На дне");
        b.setWriter(w);
        this.books.add(b);

        b2 = new Book();
        b2.setCaption("Старуха Изергиль");
        b2.setWriter(w);
        this.books.add(b2);

        b3 = new Book();
        b3.setCaption("Фома Гордеев");
        b3.setWriter(w);
        this.books.add(b3);

        this.writers.add(w);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getWriters() {
        return writers;
    }
}
