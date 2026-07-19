package com.library.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.api.enums.BorrowingStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Instant borrowDate;
    @Column(nullable = false)
    private Instant expectedReturnDate;
    @Column(nullable = false)
    private Instant returnDate;
    private BorrowingStatus status;
    private Long user_id;
    private Long book_id;

    @ManyToOne
    @JsonBackReference
    private Book book;

    @OneToMany
    @JsonManagedReference
    private Set<LibraryUser> libraryUsers = new HashSet<>();

    public Borrowing() {
    }

    public Set<LibraryUser> getLibraryUsers() {
        return libraryUsers;
    }

    public Borrowing(Instant borrowDate, Instant expectedReturnDate, Instant returnDate, BorrowingStatus status, Long user_id, Long book_id) {
        this.borrowDate = borrowDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user_id = user_id;
        this.book_id = book_id;
    }

    public Long getId() {
        return id;
    }


    public Instant getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Instant borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Instant getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(Instant expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public BorrowingStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowingStatus status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof Borrowing borrowing)) return false;
        return Objects.equals(id, borrowing.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
