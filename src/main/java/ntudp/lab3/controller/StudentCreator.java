package ntudp.lab3.controller;

import ntudp.lab3.model.Student;
import ntudp.lab3.model.Sex;


public class StudentCreator {
    private HumanCreator humanCreator;


    public StudentCreator() {
        this.humanCreator = new HumanCreator();
    }


    public Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}