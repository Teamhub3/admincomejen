package com.teamhub.admincomejen;

import java.time.LocalDate;

public class Transaction {
    private long id;
    private String concept;
    private float amount;
    private Employee user;
    private Enterprise enterprise;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Transaction(long id, String concept, float amount, Employee user, Enterprise enterprise, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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

    public String printTransaction(){
        return "\n---------------- TRANSACTION ----------------" +
                "\n ID: " + id +
                "\n CONCEPT: " + concept +
                "\n AMOUNT: " + amount + "$" +
                "\n USER ID: " + user.getId() + " NAME: " + user.getName() +
                "\n ENTERPRISE ID" + enterprise.getId() + " NAME: " + enterprise.getName() +
                "\n-------------- END TRANSACTION --------------";
    }
}