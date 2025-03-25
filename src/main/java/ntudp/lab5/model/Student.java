package ntudp.lab5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private String studentCardNumber;


    public Student(int id, String firstName, String lastName, String middleName, LocalDate birthday, String studentCardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.studentCardNumber = studentCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getStudentCardNumber() {
        return studentCardNumber;
    }

    public void setStudentCardNumber(String studentCardNumber) {
        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("ID: %d, %s %s %s, Date of Birth: %s, Student Card Number: %s",
                id, lastName, firstName, middleName, birthday.format(formatter), studentCardNumber);
    }
}