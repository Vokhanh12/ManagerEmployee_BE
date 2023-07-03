package com.example.springboot.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String emailId;

    public Employee(){

    }

    public Employee(long id, String fristName, String lastName, String emailId) {
        this.id = id;
        this.firstName = fristName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public String getFristName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFristName(String fristName) {
        this.firstName = fristName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
