package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private String email;

    @ManyToMany(mappedBy = "mentor")
    private List<Student> student;

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Mentor{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", student=");

        for(Student s : getStudent()){
            res.append(s.getfName()).append(" ").append(s.getlName()).append(", ");
        }

        res.append("}");

        return res.toString();
    }
}
