package Library.Entities;

public class Book {
    public String id;
    public String title;
    String author;
    public boolean available = true;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}