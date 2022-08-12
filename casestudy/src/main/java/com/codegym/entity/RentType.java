package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double cost;

    @JsonBackReference
    @OneToMany(mappedBy = "rentTypeId", cascade = CascadeType.REMOVE)
    private List<Service> services;

    public RentType() {
    }

    public RentType(Integer id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
