package ntudp.lab5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Клас для керування з'єднанням з базою даних
 */
public class DatabaseConnection {
    // Параметри підключення до бази даних
    private static final String URL = "jdbc:mysql://localhost:3306/university_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Lab-Adm"; // Замініть на свій пароль

    private static Connection connection;

    /**
     * Отримання з'єднання з базою даних
     *
     * @return об'єкт Connection
     * @throws SQLException виняток при підключенні до бази даних
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Завантаження драйвера MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Створення з'єднання
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("MySQL JDBC драйвер не знайдено", e);
            }
        }
        return connection;
    }

    /**
     * Закриття з'єднання з базою даних
     *
     * @throws SQLException виняток при закритті з'єднання
     */
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}