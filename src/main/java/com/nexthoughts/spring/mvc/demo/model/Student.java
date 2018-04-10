package com.nexthoughts.spring.mvc.demo.model;

import com.nexthoughts.spring.mvc.demo.classes.StudentCommand;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String firstName;

    private String lastName;

    private String emailAddress;

    public Student(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        return emailAddress.equals(student.emailAddress);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + emailAddress.hashCode();
        return result;
    }

    public Student(StudentCommand studentCommand) {
        this.firstName = studentCommand.getFirstName();
        this.lastName = studentCommand.getLastName();
        this.emailAddress = studentCommand.getEmailAddress();
    }

    public Student updateStudent(Student student, StudentCommand studentCommand) {
        student.id = studentCommand.getId();
        student.emailAddress = studentCommand.getEmailAddress();
        student.firstName = studentCommand.getFirstName();
        student.lastName = studentCommand.getLastName();
        return student;
    }
}
