package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "divisionId", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public Division() {
    }

    public Division(Integer divisionId, String name) {
        this.divisionId = divisionId;
        this.name = name;
    }

    public Division(String name) {
        this.name = name;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
