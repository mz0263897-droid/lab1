package KI305.Bilanyn.lab4;

import java.util.Scanner;
import java.io.*;

import static java.lang.System.out;

/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 */
public class EquationsApp {

    public static void main(String[] args) {

        PrintWriter fout = null; // Потік виводу у файл
        Scanner in = new Scanner(System.in); // Об’єкт для введення даних з консолі

        try {
            out.print("Enter file name: ");
            String fName = in.nextLine();

            // Спроба відкрити файл для запису
            fout = new PrintWriter(new File(fName));

            // Внутрішній try відповідає за обчислення та запис
            try {
                Equations eq = new Equations(); // Створення об'єкта обчислень

                out.print("Enter X: ");
                int x = in.nextInt(); // Зчитування аргументу

                // Запис результату обчислення у файл
                fout.print(eq.calculate(x));
            }
            finally {
                // Блок finally гарантовано виконається навіть при помилках
                if (fout != null) {
                    fout.flush();
                    fout.close(); // Закриття файлу
                }
            }

        }
        // Обробка помилок, пов'язаних із роботою з файлом
        catch (FileNotFoundException ex) {
            out.println("Exception reason: Perhaps wrong file path");
        }
        // Обробка помилок під час обчислення виразу
        catch (CalcException ex) {
            out.println(ex.getMessage());
        }
        // Загальний обробник непередбачених помилок
        catch (Exception ex) {
            out.println("Unknown error");
        }
    }
}
