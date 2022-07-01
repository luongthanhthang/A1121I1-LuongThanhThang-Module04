package com.codegym.model.entity;

public class Customer implements Cloneable {
    public String id;
    private String name;
    private String email;
    private String address;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public Customer(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Customer clone() throws CloneNotSupportedException {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
