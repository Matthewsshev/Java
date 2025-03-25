package ntudp.lab3.model;
import java.util.ArrayList;
import java.util.List;


public class Faculty extends UniversityUnit {
    private List<Department> departments;


    public Faculty(String name, Human head) {
        super(name, head);
        this.departments = new ArrayList<>();
    }


    public void addDepartment(Department department) {
        departments.add(department);
    }


    public boolean removeDepartment(Department department) {
        return departments.remove(department);
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    @Override
    public String toString() {
        return "Faculty: " + name + ", Dean: " + head + ", Number of Departments: " + departments.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Faculty faculty = (Faculty) obj;

        return departments.equals(faculty.departments);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + departments.hashCode();
        return result;
    }
}
