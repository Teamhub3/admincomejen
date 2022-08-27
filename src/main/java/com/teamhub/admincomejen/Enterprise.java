package com.teamhub.admincomejen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Enterprise {

    private Long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    private List<Employee> users;
    private List<Transaction> transactions;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Enterprise(Long id, String name, String document, String phone, String address, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.users = new ArrayList<Employee>();
        this.transactions = new ArrayList<Transaction>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setUpdatedAt(LocalDate updatedAt) {this.updatedAt = updatedAt;}

    public void addEmployee(Employee employee){
        this.users.add(employee);
    }
    public void removeEmploye(long idEmployee){
        this.users = users.stream().filter(employee -> {
            return !(employee.getId() == idEmployee);
        }).collect(Collectors.toList());
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
    public void removeTransaction(long idTransaction){
        this.transactions = transactions.stream().filter(transaction -> {
            return !(transaction.getId() == idTransaction);
        }).collect(Collectors.toList());
    }

    public String printEnterprise(){
        return "\n---------------- ENTERPRISE ----------------" +
                "\n ENTERPRISE ID: " + id +
                "\n NAME: " + name +
                "\n DOCUMENT: " + document +
                "\n PHONE: " + phone +
                "\n ADDRESS: " + address +
                "\n-------------- END ENTERPRISE --------------";
    }

}
