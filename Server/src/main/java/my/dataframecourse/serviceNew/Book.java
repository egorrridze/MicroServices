package my.dataframecourse.serviceNew;

public class Book {
    String Caption;
    Author Author;

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        this.Caption = caption;
    }

    public Author getAuthor() {
        return Author;
    }

    public void setWriter(Author a){
        this.Author = a;
    }
}
