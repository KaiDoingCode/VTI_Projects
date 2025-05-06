package Library.Entities;

import java.time.LocalDate;

public class LoanRecord {
    public User user;
    public Book book;
    public LocalDate loanDate;
    public LocalDate returnDate;

    public LoanRecord(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }
}

