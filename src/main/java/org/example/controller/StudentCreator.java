package org.example.controller;

import org.example.model.Student;
import org.example.model.Sex;


public class StudentCreator {
    private HumanCreator humanCreator;


    public StudentCreator() {
        this.humanCreator = new HumanCreator();
    }


    public Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}