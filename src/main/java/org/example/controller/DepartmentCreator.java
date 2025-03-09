package org.example.controller;

import org.example.model.Department;
import org.example.model.Group;
import org.example.model.Human;


public class DepartmentCreator {
    private GroupCreator groupCreator;


    public DepartmentCreator() {
        this.groupCreator = new GroupCreator();
    }


    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }


    public void addGroupToDepartment(Department department, Group group) {
        department.addGroup(group);
    }
}
