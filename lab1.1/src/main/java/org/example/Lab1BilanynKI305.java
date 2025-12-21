package org.example;

import java.io.*;
import java.util.*;

/**
 * Клас <code>Lab1BilanynKI305</code> реалізує лабораторну роботу №1.
 * <p>
 * Програма створює зубчасту (нерівномірну) матрицю, що містить
 * рівнобедрений трикутник у нижній частині квадратної області.
 * Символ-заповнювач вводиться користувачем.
 * Результат виводиться у консоль та записується у файл <b>KZP.txt</b>.
 * </p>
 */
public class Lab1BilanynKI305 {
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;         // розмір квадратної матриці
        char[][] arr;      // зубчаста матриця
        String filler;     // символ-заповнювач

        Scanner in = new Scanner(System.in);
        File dataFile = new File("KZP.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        //  Ввід розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine(); // очищення буфера після nextInt()

        //  Ввід символу заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        filler = in.nextLine();

        //  Перевірка на коректність введеного символу
        if (filler.length() != 1) {
            System.out.println("Помилка: введіть лише один символ!");
            fout.close();
            return;
        }

        //  Створення зубчастої матриці
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            int length = 0;
            // підрахунок, скільки елементів буде у поточному рядку
            for (int j = 0; j < nRows; j++) {
                if (i >= nRows / 2 && (j >= nRows - i - 1 && j <= i)) {
                    length++;
                }
            }
            arr[i] = new char[length];
        }

        System.out.println("\nРезультат матриці (зубчастий масив):\n");

        //  Заповнення та вивід зубчастої матриці
        for (int i = 0; i < nRows; i++) {
            int index = 0; // позиція в підмасиві
            for (int j = 0; j < nRows; j++) {
                if (i >= nRows / 2 && (j >= nRows - i - 1 && j <= i)) {
                    arr[i][index] = filler.charAt(0);
                    System.out.print(arr[i][index] + " ");
                    fout.print(arr[i][index] + " ");
                    index++;
                } else {
                    System.out.print("  ");
                    fout.print("  ");
                }
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
        System.out.println("\nРезультат записано у файл KZP.txt");
    }
}
