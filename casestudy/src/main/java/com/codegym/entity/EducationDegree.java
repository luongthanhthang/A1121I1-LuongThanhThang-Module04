package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationDegreeId;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "educationDegreeId", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String name) {
        this.name = name;
    }

    public EducationDegree(Integer educationDegreeId, String name) {
        this.educationDegreeId = educationDegreeId;
        this.name = name;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
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
