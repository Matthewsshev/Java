package org.example.controller;

import org.example.model.Faculty;
import org.example.model.Human;
import org.example.model.University;


public class UniversityCreator {
    private FacultyCreator facultyCreator;


    public UniversityCreator() {
        this.facultyCreator = new FacultyCreator();
    }


    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }


    public void addFacultyToUniversity(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}