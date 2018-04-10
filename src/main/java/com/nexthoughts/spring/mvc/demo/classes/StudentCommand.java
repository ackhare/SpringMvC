package com.nexthoughts.spring.mvc.demo.classes;

import com.nexthoughts.spring.mvc.demo.model.Student;

//POJO
public class StudentCommand {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public StudentCommand(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public StudentCommand() {
    }

    public StudentCommand(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.emailAddress = student.getEmailAddress();
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

    //Both below methods use three fields firstName,lastName,emailAddress

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCommand)) return false;
        StudentCommand studentCommand = (StudentCommand) o;
        if (id != studentCommand.id) return false;
        if (!firstName.equals(studentCommand.firstName)) return false;
        if (!lastName.equals(studentCommand.lastName)) return false;
        return emailAddress.equals(studentCommand.emailAddress);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + emailAddress.hashCode();
        return result;
    }
}
