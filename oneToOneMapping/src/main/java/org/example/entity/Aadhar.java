package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aadhar")
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "aadharNumber")
    private String aadharNumber;

    @OneToOne(mappedBy = "personAadharDetails", cascade = CascadeType.ALL)
    private Person person;

    public int getId() {
        return id;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Aadhar{" +
                "id=" + id +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", person=" + (person != null ? person.getId() : "null") +
                '}';
    }
}
