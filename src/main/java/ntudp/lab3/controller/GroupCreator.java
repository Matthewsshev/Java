package ntudp.lab3.controller;

import ntudp.lab3.model.Group;
import ntudp.lab3.model.Human;
import ntudp.lab3.model.Student;


public class GroupCreator {
    private StudentCreator studentCreator;


    public GroupCreator() {
        this.studentCreator = new StudentCreator();
    }


    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }


    public void addStudentToGroup(Group group, Student student) {
        group.addStudent(student);
    }
}