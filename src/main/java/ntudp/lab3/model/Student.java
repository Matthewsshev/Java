package ntudp.lab3.model;


public class Student extends Human {
    private String studentId;


    public Student(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        super(firstName, lastName, middleName, sex);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Student student = (Student) obj;

        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }
}