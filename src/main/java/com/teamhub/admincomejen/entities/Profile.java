package com.teamhub.admincomejen.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column
    private String image;
    @Column
    private String phone;

    @Column
    private String name;
    @OneToOne
    private Employee employee;
    @Column
    private LocalDate createdAt;
    @Column
    private LocalDate updatedAt;

    public Profile(Long id, String image, String phone, String name, Employee employee, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.name = name;
        this.employee = employee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
