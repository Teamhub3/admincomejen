package com.teamhub.admincomejen.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Entity
@Table(name="enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enterprise_id", nullable = false, updatable = false, insertable = false) private Long id;
    @Column(name = "enterprise_name") private String name;
    @Column(name = "enterprise_document") private String document;
    @Column(name = "enterprise_phone")private String phone;
    @Column(name = "enterprise_address") private String address;
    @OneToMany(mappedBy = "enterprise") private List<Employee> employees;
    @OneToMany(mappedBy = "enterprise") private List<Transaction> transactions;
    @Column(name = "enterprise_createAt") private LocalDate createdAt;
    @Column(name = "enterrpise_updateAt") private LocalDate updatedAt;

    public Enterprise(Long id, String name, String document, String phone, String address, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.employees = new ArrayList<Employee>();
        this.transactions = new ArrayList<Transaction>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Enterprise() {

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
        this.employees.add(employee);
    }
    public void removeEmployee(long idEmployee){
        this.employees = employees.stream().filter(employee -> {
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
