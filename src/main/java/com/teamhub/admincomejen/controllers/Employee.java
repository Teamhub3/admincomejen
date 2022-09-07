package com.teamhub.admincomejen.controllers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private long id;
    private String name;
    private String email;
    private Profile profile;
    private Enum_RoleName role;
    private Enterprise enterprise;
    private List<Transaction> transactions;
    private LocalDate updateAt;
    private LocalDate createdAt;

    public Employee(long id, String name, String email, Profile profile, Enum_RoleName role, Enterprise enterprise, LocalDate updateAt, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = new ArrayList<Transaction>();
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public void setTransactions(List<Transaction> transactions) {this.transactions = transactions;}

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

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
     public void removeTransaction(long idTransaction){
        this.transactions = transactions.stream().filter(transaction -> {
            return !(transaction.getId() == idTransaction);
        }).collect(Collectors.toList());
     }

     public String printEmployee(){
        return "\n---------------- EMPLOYEE ----------------" +
                "\n USER ID: " + id +
                "\n NAME: " + name +
                "\n EMAIL: " + email +
                "\n ROLE: " + role +
                "\n ENTERPRISE ID: " + enterprise.getId() + " NAME: " + enterprise.getName() +
                "\n-------------- END EMPLOYEE --------------";
     }


}
