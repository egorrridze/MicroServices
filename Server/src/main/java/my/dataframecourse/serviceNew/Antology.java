package my.dataframecourse.serviceNew;

import java.util.ArrayList;
import java.util.List;

public class Antology {
    Author writer;
    List<Book> books;

    public Antology(Author writer, List<Book> abooks) {
        this.books = new ArrayList<Book>();
        this.writer = writer;
        for (Book b: abooks)
            if (b.Author == writer)
                this.books.add(b);
    }

    public Author getWriter() {
        return writer;
    }

    public List<Book> getBooks() {
        return books;
    }
}
