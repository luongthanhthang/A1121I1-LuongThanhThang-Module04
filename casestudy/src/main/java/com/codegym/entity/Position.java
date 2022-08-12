package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;
    private String name;


    @JsonBackReference
    @OneToMany(mappedBy = "positionId", cascade = CascadeType.REMOVE)
    private List<Employee> employees;


    public Position() {
    }

    public Position(Integer positionId, String name) {
        this.positionId = positionId;
        this.name = name;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
