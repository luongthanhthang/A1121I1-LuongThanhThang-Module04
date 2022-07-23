package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @Column(name = "factory_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer factoryCode;
    private String name;

    public Factory() {
    }

    @OneToMany(mappedBy = "factory", cascade = CascadeType.REMOVE)
    private Set<Product> products;

    public Factory(int factoryCode, String name) {
        this.factoryCode = factoryCode;
        this.name = name;
    }

    public Integer getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(Integer factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
