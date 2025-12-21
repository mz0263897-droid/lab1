package KI305.Bilanyn.lab5;

import KI305.Bilanyn.lab4.*;
import java.io.*;
import java.util.Scanner;

public class EquationsWFioApp {

    public static void main(String[] args) {

        // Створюємо об’єкти для введення даних і обчислень
        Scanner in = new Scanner(System.in);
        CalcWFio calc = new CalcWFio();

        try {
            // Зчитування користувацького вводу
            System.out.print("Enter X: ");
            int x = in.nextInt();

            // Виконання обчислень та вивід результату
            calc.calculate(x);
            System.out.printf("Calculated result: %f%n", calc.getResult());

            // Збереження результату у текстовий і бінарний файли
            calc.writeResTxt("result.txt");
            calc.writeResBin("result.bin");

            // Зчитування результату з бінарного файлу та його вивід
            calc.readResBin("result.bin");
            System.out.printf("Read from binary file: %f%n", calc.getResult());

            // Зчитування результату з текстового файлу та його вивід
            calc.readResTxt("result.txt");
            System.out.printf("Read from text file: %f%n", calc.getResult());

        }
        // Загальна обробка помилок, які можуть виникнути
        catch (CalcException ex) {                 // помилки обчислень
            System.out.println(ex.getMessage());
        }
        catch (FileNotFoundException ex) {         // файл не знайдено
            System.out.println(String.format("File error: %s", ex.getMessage()));
        }
        catch (IOException ex) {                    // помилки вводу/виводу
            System.out.println(String.format("I/O error: %s", ex.getMessage()));
        }
        catch (Exception ex) {                      // всі інші невідомі помилки
            System.out.println("Unknown error");
        }
    }
}
