package ntudp.lab5;

import ntudp.lab5.dao.StudentDAO;
import ntudp.lab5.model.Student;
import ntudp.lab5.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Month;
import java.util.List;
import java.util.Scanner;


public class StudentApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO;

    public static void main(String[] args) {
        try {
            // Obtaining database connection
            Connection connection = DatabaseConnection.getConnection();
            studentDAO = new StudentDAO(connection);

            boolean exit = false;
            while (!exit) {
                printMenu();
                int choice = getMenuChoice();

                switch (choice) {
                    case 1:
                        showAllStudents();
                        break;
                    case 2:
                        showStudentsByMonth(true);
                        break;
                    case 3:
                        showStudentsByMonth(false);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Program terminated.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            try {
                DatabaseConnection.closeConnection();
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Show all students");
        System.out.println("2. Show students by birth month (SQL filtering)");
        System.out.println("3. Show students by birth month (Java filtering)");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }


    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    private static void showAllStudents() throws SQLException {
        System.out.println("\n--- List of All Students ---");
        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("Total number of students: " + students.size());
        }
    }


    private static void showStudentsByMonth(boolean useSQL) throws SQLException {
        System.out.println("\n--- Student Filtering by Birth Month ---");
        System.out.println("Using " + (useSQL ? "SQL query" : "Java filtering"));

        System.out.println("Select month (1-12):");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + ". " + Month.of(i));
        }

        System.out.print("Your choice: ");
        try {
            int month = Integer.parseInt(scanner.nextLine());

            if (month < 1 || month > 12) {
                System.out.println("Invalid month number. Enter a number between 1 and 12.");
                return;
            }

            List<Student> students;
            long startTime = System.currentTimeMillis();

            if (useSQL) {
                students = studentDAO.getStudentsByBirthMonth(month);
            } else {
                students = studentDAO.filterStudentsByBirthMonth(month);
            }

            long endTime = System.currentTimeMillis();

            System.out.println("\nStudents born in " + Month.of(month) + ":");

            if (students.isEmpty()) {
                System.out.println("No students found born in this month.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
                System.out.println("Students found: " + students.size());
            }

            System.out.println("Execution time: " + (endTime - startTime) + " ms");

        } catch (NumberFormatException e) {
            System.out.println("Error: Enter a numeric value.");
        }
    }
}