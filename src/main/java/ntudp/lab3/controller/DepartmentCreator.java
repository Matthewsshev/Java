package ntudp.lab3.controller;

import ntudp.lab3.model.Department;
import ntudp.lab3.model.Group;
import ntudp.lab3.model.Human;


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
