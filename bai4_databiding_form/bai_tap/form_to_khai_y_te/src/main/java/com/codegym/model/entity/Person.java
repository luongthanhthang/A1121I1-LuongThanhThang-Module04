package com.codegym.model.entity;

import java.util.Date;

public class Person {
    private String name;
    private String yearOfBirth;
    private String sex;
    private String nation;
    private String idCard;
    private String travel;
    private String travelId;
    private String seats;
    private String startDate;
    private String endDate;
    private String attention;

    public Person() {
    }

    public Person(String name, String yearOfBirth, String sex, String nation, String idCard, String travel, String travelId, String seats, String startDate, String endDate, String attention) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
        this.nation = nation;
        this.idCard = idCard;
        this.travel = travel;
        this.travelId = travelId;
        this.seats = seats;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attention = attention;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getTravelId() {
        return travelId;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}
