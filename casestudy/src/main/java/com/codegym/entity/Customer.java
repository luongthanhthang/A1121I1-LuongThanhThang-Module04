package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType typeId;
    @NotEmpty
    @Column(nullable = false)
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    @NotNull
    private Integer gender;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Nhập sai định dạng id card dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(regexp = "^090(\\d{7})|091(\\d{7})|\\(84\\)\\+90(\\d{7})|\\(84\\)\\+91(\\d{7})$", message = "định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @NotEmpty
    @Pattern(regexp = "^[a-z]\\w+@gmail+\\.[a-z]+$", message = "email phải đúng định dạng email")
    private String email;
    @NotEmpty
    private String address;

    @JsonBackReference
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(Integer id, CustomerType typeId, String name, Date birthday, Integer gender, String idCard, String phone, String email, String address) {
        this.id = id;
        this.typeId = typeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(CustomerType typeId, String name, Date birthday, Integer gender, String idCard, String phone, String email, String address) {
        this.typeId = typeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getTypeId() {
        return typeId;
    }

    public void setTypeId(CustomerType typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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


    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }


}
