package com.teamhub.admincomejen.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false, updatable = false, insertable = false)
    private Long id;
    @Column(name = "transaction_concept") private String concept;
    @Column(name = "transaction_amount") private float amount;
    @ManyToOne
    @JoinColumn(name = "employee_id") private Employee employee;
    @ManyToOne
    @JoinColumn(name = "enterprise_id") private Enterprise enterprise;
    @Column(name = "transaction_createAt") private LocalDate createdAt;
    @Column(name = "transaction_updateAt") private LocalDate updatedAt;

    public Transaction(long transaction_id, String concept, float amount, Employee employee, Enterprise enterprise, LocalDate createdAt, LocalDate updatedAt) {
        this.id = transaction_id;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Transaction() {

    }

    public long getTransaction_id() {
        return id;
    }

    public void setTransaction_id(long id) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee user) {
        this.employee = user;
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
                "\n USER ID: " + employee.getId() + " NAME: " + employee.getName() +
                "\n ENTERPRISE ID" + enterprise.getId() + " NAME: " + enterprise.getName() +
                "\n-------------- END TRANSACTION --------------";
    }
}