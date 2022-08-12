package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column(nullable = false)
    @NotEmpty
    private String birthday;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Nhập sai định dạng id card dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;
    @Column(nullable = false)
    @Min(value = 0, message = "Lương phải > 0")
    private Double salary;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(regexp = "^090(\\d{7})|091(\\d{7})|\\(84\\)\\+90(\\d{7})|\\(84\\)\\+91(\\d{7})$", message = "định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @NotEmpty
    @Pattern(regexp = "^[a-z]\\w+@gmail+\\.[a-z]+$", message = "email phải đúng định dạng email")
    private String email;
    @NotEmpty
    private String address;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "position_id", nullable = false)
    private Position positionId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegreeId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "division_id", nullable = false)
    private Division divisionId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    @JsonBackReference
    private Account username;


    @JsonBackReference
    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public Employee() {
    }

    public Employee(String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position positionId, EducationDegree educationDegreeId, Division divisionId, Account username) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(Integer id, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position positionId, EducationDegree educationDegreeId, Division divisionId, Account username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
