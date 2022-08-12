package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Integer area;
    @Column(nullable = false)
    private Double cost;
    private Integer maxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentTypeId;
    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceTypeId;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;


    @JsonBackReference
    @OneToMany(mappedBy = "serviceId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;


    public Service() {
    }

    public Service(Integer id, String name, Integer area, Double cost, Integer maxPeople, RentType rentTypeId, ServiceType serviceTypeId, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String name, Integer area, Double cost, Integer maxPeople, RentType rentTypeId, ServiceType serviceTypeId, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
