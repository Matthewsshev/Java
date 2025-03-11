package org.example;

import org.example.dao.StudentDAO;
import org.example.model.StudentLab5;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з базою даних студентів
 */
public class StudentApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO;

    public static void main(String[] args) {
        try {
            // Отримання з'єднання з базою даних
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
                        showStudentsByMonth(true); // Використовуємо SQL-запит для фільтрації
                        break;
                    case 3:
                        showStudentsByMonth(false); // Використовуємо Java для фільтрації
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Програму завершено.");
                        break;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Помилка при роботі з базою даних: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            try {
                DatabaseConnection.closeConnection();
            } catch (SQLException e) {
                System.err.println("Помилка при закритті з'єднання з базою даних: " + e.getMessage());
            }
        }
    }

    /**
     * Виведення меню на екран
     */
    private static void printMenu() {
        System.out.println("\n=== Система обліку студентів ===");
        System.out.println("1. Показати всіх студентів");
        System.out.println("2. Показати студентів за місяцем народження (SQL фільтрація)");
        System.out.println("3. Показати студентів за місяцем народження (Java фільтрація)");
        System.out.println("4. Вихід");
        System.out.print("Ваш вибір: ");
    }

    /**
     * Отримання вибору користувача
     *
     * @return номер пункту меню
     */
    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Виведення всіх студентів
     *
     * @throws SQLException виняток при роботі з базою даних
     */
    private static void showAllStudents() throws SQLException {
        System.out.println("\n--- Список всіх студентів ---");
        List<StudentLab5> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("Студентів не знайдено.");
        } else {
            for (StudentLab5 student : students) {
                System.out.println(student);
            }
            System.out.println("Загальна кількість студентів: " + students.size());
        }
    }

    /**
     * Виведення студентів за місяцем народження
     *
     * @param useSQL використовувати SQL-запит для фільтрації (true) або Java (false)
     * @throws SQLException виняток при роботі з базою даних
     */
    private static void showStudentsByMonth(boolean useSQL) throws SQLException {
        System.out.println("\n--- Фільтрація студентів за місяцем народження ---");
        System.out.println("Використовується " + (useSQL ? "SQL-запит" : "Java-фільтрація"));

        System.out.println("Виберіть місяць (1-12):");
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + ". " + Month.of(i));
        }

        System.out.print("Ваш вибір: ");
        try {
            int month = Integer.parseInt(scanner.nextLine());

            if (month < 1 || month > 12) {
                System.out.println("Невірний номер місяця. Введіть число від 1 до 12.");
                return;
            }

            List<StudentLab5> students;
            long startTime = System.currentTimeMillis();

            if (useSQL) {
                students = studentDAO.getStudentsByBirthMonth(month);
            } else {
                students = studentDAO.filterStudentsByBirthMonth(month);
            }

            long endTime = System.currentTimeMillis();

            System.out.println("\nСтуденти, що народилися в місяці " + Month.of(month) + ":");

            if (students.isEmpty()) {
                System.out.println("Студентів, народжених у цьому місяці, не знайдено.");
            } else {
                for (StudentLab5 student : students) {
                    System.out.println(student);
                }
                System.out.println("Знайдено студентів: " + students.size());
            }

            System.out.println("Час виконання: " + (endTime - startTime) + " мс");

        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть числове значення.");
        }
    }
}