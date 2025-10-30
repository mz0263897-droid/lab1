package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас Lab1BylanynKI305 створює квадратну матрицю заданого користувачем розміру
 * і виводить у її нижній частині рівнобедрений трикутник, заповнений заданим символом.
 * <p>
 * Висота трикутника визначається автоматично залежно від розміру матриці,
 * а його вершина розташована по центру верхньої межі трикутної області.
 * Решта комірок заповнюється пробілами для формування фону.
 * Результат виводиться на екран та одночасно записується у файл KZP.txt.
 * </p>
 */

public class Lab1BilanynKI305 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввід параметрів користувачем
        System.out.print("Введіть розмір матриці: ");
        int matrixSize = scanner.nextInt();

        System.out.print("Введіть символ заповнювач: ");
        String filler = scanner.next();

        // Перевірка коректності введеного символу
        if (filler.length() != 1) {
            System.out.println("Помилка: потрібно ввести лише один символ!");
            return;
        }

        // Створення масиву
        String[][] matrix = createMatrixShape(matrixSize);

        // Виведення результату
        System.out.print("Результат матриці: ");
        try {
            generateTriangle(matrix, filler, matrixSize, "KZP.txt");
        } catch (IOException e) {
            System.out.println("Помилка під час запису у файл: " + e.getMessage());
        }
    }
     //Метод формує і виводить матрицю з рівнобедреним трикутником у нижній частині.
    public static void generateTriangle(String[][] matrix, String symbol, int size, String fileName) throws IOException {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int symbolIndex = 0;

            for (int j = 0; j < size; j++) {
                if (i >= size / 2 && j >= size - i - 1 && j <= i) {
                    matrix[i][symbolIndex++] = symbol;
                    System.out.print(symbol + " ");
                    output.append(symbol).append(" ");
                } else {
                    System.out.print("  ");
                    output.append("  ");
                }
            }
            System.out.println();
            output.append("\n");
        }

        // Запис результату у файл
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(output.toString());
        }
    }
    //Метод створює зубчасту структуру матриці відповідно до трикутної форми.
    public static String[][] createMatrixShape(int size) {
        String[][] matrix = new String[size][];

        for (int i = 0; i < size; i++) {
            int validLength = 0;
            for (int j = 0; j < size; j++) {
                if (i >= size / 2 && j >= size - i - 1 && j <= i) {
                    validLength++;
                }
            }
            matrix[i] = new String[validLength];
        }

        return matrix;
    }
}
