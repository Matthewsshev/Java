package ntudp.lab3.model;

import java.util.ArrayList;
import java.util.List;


public class Department extends UniversityUnit {
    private List<Group> groups;


    public Department(String name, Human head) {
        super(name, head);
        this.groups = new ArrayList<>();
    }


    public void addGroup(Group group) {
        groups.add(group);
    }


    public boolean removeGroup(Group group) {
        return groups.remove(group);
    }

    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + head + ", Number of Groups: " + groups.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Department department = (Department) obj;

        return groups.equals(department.groups);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + groups.hashCode();
        return result;
    }
}