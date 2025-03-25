package ntudp.lab2;

import java.util.Random;
import java.util.Scanner;


public class MatrixOperations {

    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int MAX_MATRIX_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Matrix Operations App");

        int rows = readMatrixDimension("Type in row quantity (<= 20): ");
        int cols = readMatrixDimension("Type in column quantity (<= 20): ");

        int[][] matrix = createMatrix(rows, cols);

        System.out.println("\nCreated Matrix:");
        printMatrix(matrix);

        int min = findMinElement(matrix);
        int max = findMaxElement(matrix);
        System.out.println("\nMin element: " + min);
        System.out.println("Max element: " + max);

        double arithmeticMean = calculateArithmeticMean(matrix);
        System.out.printf("Arithmetic mean: %.2f\n", arithmeticMean);

        double geometricMean = calculateGeometricMean(matrix);
        System.out.printf("Geometric mean: %.2f\n", geometricMean);
    }


    private static int readMatrixDimension(String message) {
        int dimension;
        do {
            System.out.print(message);
            dimension = scanner.nextInt();
            if (dimension <= 0 || dimension > MAX_MATRIX_SIZE) {
                System.out.println("Err! Size must be from 1 to " + MAX_MATRIX_SIZE);
            }
        } while (dimension <= 0 || dimension > MAX_MATRIX_SIZE);
        return dimension;
    }


    private static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        System.out.println("\nChoose Matrix creation type:");
        System.out.println("1 - Keyboard type in ");
        System.out.println("2 - Random numbers");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Type in matrix elements:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.printf("Element [%d][%d]: ", i, j);
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = MIN_RANDOM_VALUE + random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1);
                    }
                }
                break;
            default:
                System.out.println("False choice. Matrix would be filled up with random values.");
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
        double sumLogs = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                double absValue = Math.abs(matrix[i][j]);
                if (absValue > 0) {
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