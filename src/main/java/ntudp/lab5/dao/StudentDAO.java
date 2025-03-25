package ntudp.lab5.dao;

import ntudp.lab5.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для роботи з базою даних студентів
 */
public class StudentDAO {
    private Connection connection;


    public StudentDAO(Connection connection) {
        this.connection = connection;
    }


    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                students.add(createStudentFromResultSet(resultSet));
            }
        }

        return students;
    }

    /**
     * Отримання списку студентів, які народилися в певному місяці
     *
     * @param month місяць (1-12)
     * @return список студентів
     * @throws SQLException виняток при роботі з базою даних
     */
    public List<Student> getStudentsByBirthMonth(int month) throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE MONTH(birthday) = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, month);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(createStudentFromResultSet(resultSet));
                }
            }
        }

        return students;
    }

    /**
     * Фільтрація студентів за місяцем народження (на стороні Java)
     *
     * @param month місяць (1-12)
     * @return список студентів
     * @throws SQLException виняток при роботі з базою даних
     */
    public List<Student> filterStudentsByBirthMonth(int month) throws SQLException {
        List<Student> allStudents = getAllStudents();
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : allStudents) {
            if (student.getBirthday().getMonthValue() == month) {
                filteredStudents.add(student);
            }
        }

        return filteredStudents;
    }

    /**
     * Створення об'єкта Student з результату запиту
     *
     * @param resultSet результат запиту
     * @return об'єкт Student
     * @throws SQLException виняток при роботі з базою даних
     */
    private Student createStudentFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String middleName = resultSet.getString("middle_name");
        LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
        String studentCardNumber = resultSet.getString("student_card_number");

        return new Student(id, firstName, lastName, middleName, birthday, studentCardNumber);
    }
}