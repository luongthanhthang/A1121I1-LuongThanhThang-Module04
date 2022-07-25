package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_borrow")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private Boolean status;
    @Column(columnDefinition = "integer default '2'")
    private Integer quantity;
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Borrow> borrows;

    public Book() {
    }

    public Book(Integer id, String name, Boolean status, Integer quantity) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
