package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Account> personAccountDetails;

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getPersonAccountDetails() {
        return personAccountDetails;
    }

    public void setPersonAccountDetails(List<Account> personAccountDetails) {
        this.personAccountDetails = personAccountDetails;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Person{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", Account Number=");

        for(Account acc : personAccountDetails){
            res.append(acc.getAccountNumber());
        }

        res.append("}");

        return res.toString();
    }
}

