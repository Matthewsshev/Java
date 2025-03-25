package ntudp.lab3.model;
import java.util.ArrayList;
import java.util.List;


public class Group extends UniversityUnit {
    private List<Student> students;


    public Group(String name, Human head) {
        super(name, head);
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
    }


    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public String toString() {
        return "Group: " + name + ", Group Leader: " + head + ", Number of Students: " + students.size();    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Group group = (Group) obj;

        return students.equals(group.students);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + students.hashCode();
        return result;
    }
}