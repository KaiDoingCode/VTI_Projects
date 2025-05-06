package Library;

import Library.Entities.Book;
import Library.Entities.LoanRecord;
import Library.Entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<LoanRecord> records = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String userId, String bookId) {
        User user = users.stream().filter(u -> u.id.equals(userId)).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.id.equals(bookId) && b.available).findFirst().orElse(null);
        if (user != null && book != null) {
            book.available = false;
            records.add(new LoanRecord(user, book, LocalDate.now()));
            System.out.println(user.name + " borrowed " + book.title);
        }
    }

    public void returnBook(String bookId) {
        for (LoanRecord record : records) {
            if (record.book.id.equals(bookId) && record.returnDate == null) {
                record.returnDate = LocalDate.now();
                record.book.available = true;
                System.out.println(record.user.name + " returned " + record.book.title);
                return;
            }
        }
    }

    public void showCurrentlyBorrowed() {
        records.stream().filter(r -> r.returnDate == null).forEach(r ->
                System.out.println(r.book.title + " borrowed by " + r.user.name)
        );
    }

    public void showReturnedBooks() {
        records.stream().filter(r -> r.returnDate != null).forEach(r ->
                System.out.println(r.book.title + " returned by " + r.user.name)
        );
    }

    public void findUserBorrowHistory(String userId) {
        records.stream().filter(r -> r.user.id.equals(userId)).forEach(r ->
                System.out.println(r.book.title + " borrowed on " + r.loanDate + (r.returnDate != null ? ", returned on " + r.returnDate : ", not returned"))
        );
    }
}