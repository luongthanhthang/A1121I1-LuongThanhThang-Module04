package com.codegym.entity;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "borrow_id")
    private String borrowId;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrow() {
    }

    public Borrow(Integer id, String borrowId) {
        this.id = id;
        this.borrowId = borrowId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
