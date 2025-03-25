package ntudp.lab3.controller;

import ntudp.lab3.model.Faculty;
import ntudp.lab3.model.Human;
import ntudp.lab3.model.University;


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