package com.codegym.entity;


import javax.persistence.*;

@Entity
public class Account {
    @Id
    @Column(name = "username", columnDefinition = "varchar(100)")
    private String username;

    @Column(name = "password")
    private String password;


    @OneToOne(mappedBy = "username")
    private Employee employee;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
