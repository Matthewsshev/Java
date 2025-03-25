package ntudp.lab3.controller;

import ntudp.lab3.model.Department;
import ntudp.lab3.model.Faculty;
import ntudp.lab3.model.Human;


public class FacultyCreator {
    private DepartmentCreator departmentCreator;


    public FacultyCreator() {
        this.departmentCreator = new DepartmentCreator();
    }


    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }


    public void addDepartmentToFaculty(Faculty faculty, Department department) {
        faculty.addDepartment(department);
    }
}
