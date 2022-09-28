package com.teamhub.admincomejen.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private Profile profile;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = EnumRoleName.class, fetch = FetchType.EAGER)
    private List<EnumRoleName> roles;
    @ManyToOne()
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Transaction> transactions;
    @Column
    private LocalDate updateAt;
    @Column
    private LocalDate createdAt;

    public Employee() {
    }

    public Employee(long id, String email, String password, Profile profile, List<EnumRoleName> roles, Enterprise enterprise, List<Transaction> transactions, LocalDate updateAt, LocalDate createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.roles = roles;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<EnumRoleName> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumRoleName> roles) {
        this.roles = roles;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


}
