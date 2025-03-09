package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторна робота №2
 * Програма для роботи з матрицями цілих чисел
 */
public class MatrixOperations {
    // Константи для діапазону рандомних чисел
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int MAX_MATRIX_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Програма для роботи з матрицями");

        // Зчитування розмірів матриці
        int rows = readMatrixDimension("Введіть кількість рядків (не більше 20): ");
        int cols = readMatrixDimension("Введіть кількість стовпців (не більше 20): ");

        // Створення матриці
        int[][] matrix = createMatrix(rows, cols);

        // Вивід матриці
        System.out.println("\nСтворена матриця:");
        printMatrix(matrix);

        // Пошук мінімального та максимального елементів
        int min = findMinElement(matrix);
        int max = findMaxElement(matrix);
        System.out.println("\nМінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);

        // Розрахунок середнього арифметичного
        double arithmeticMean = calculateArithmeticMean(matrix);
        System.out.printf("Середнє арифметичне: %.2f\n", arithmeticMean);

        // Додаткове завдання: розрахунок середнього геометричного
        double geometricMean = calculateGeometricMean(matrix);
        System.out.printf("Середнє геометричне: %.2f\n", geometricMean);
    }


    private static int readMatrixDimension(String message) {
        int dimension;
        do {
            System.out.print(message);
            dimension = scanner.nextInt();
            if (dimension <= 0 || dimension > MAX_MATRIX_SIZE) {
                System.out.println("Помилка! Розмір повинен бути від 1 до " + MAX_MATRIX_SIZE);
            }
        } while (dimension <= 0 || dimension > MAX_MATRIX_SIZE);
        return dimension;
    }


    private static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        System.out.println("\nОберіть спосіб створення матриці:");
        System.out.println("1 - Ввести елементи вручну");
        System.out.println("2 - Заповнити випадковими числами");
        System.out.print("Ваш вибір: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Ручне введення елементів
                System.out.println("Введіть елементи матриці:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.printf("Елемент [%d][%d]: ", i, j);
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                break;
            case 2:
                // Заповнення випадковими числами
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = MIN_RANDOM_VALUE + random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1);
                    }
                }
                break;
            default:
                System.out.println("Невірний вибір. Матриця буде заповнена випадковими числами.");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = MIN_RANDOM_VALUE + random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1);
                    }
                }
        }

        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%5d ", matrix[i][j]);
            }
            System.out.println();
        }
    }


    private static int findMinElement(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }


    private static int findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }


    private static double calculateArithmeticMean(int[][] matrix) {
        long sum = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return (double) sum / count;
    }


    private static double calculateGeometricMean(int[][] matrix) {
        // Для уникнення переповнення використовуємо логарифмічний підхід
        double sumLogs = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Для обробки від'ємних чисел і нулів, використовуємо абсолютне значення
                // Зауваження: точне середнє геометричне від'ємних чисел може бути комплексним
                double absValue = Math.abs(matrix[i][j]);
                if (absValue > 0) {  // Уникаємо log(0)
                    sumLogs += Math.log(absValue);
                    count++;
                }
            }
        }

        if (count > 0) {
            return Math.exp(sumLogs / count);
        } else {
            return 0;
        }
    }
}