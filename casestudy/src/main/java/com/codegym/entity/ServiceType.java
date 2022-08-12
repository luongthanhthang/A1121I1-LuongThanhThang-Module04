package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;
    private String serviceTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceTypeId", cascade = CascadeType.REMOVE)
    private List<Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId, String serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
