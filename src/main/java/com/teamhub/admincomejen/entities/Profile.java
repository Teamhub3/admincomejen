package com.teamhub.admincomejen.entities;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id", nullable = false) private Long profile_id;

    @OneToOne
    @JoinColumn(name = "employee_id") private Employee employee;

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long id) {
        this.profile_id = id;
    }
}
