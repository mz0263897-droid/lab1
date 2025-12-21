package KI305.Bilanyn.lab5;

import KI305.Bilanyn.lab4.*;
import java.io.*;
import java.util.Scanner;

public class CalcWFio {

    // Поле для зберігання результату обчислення
    private double result;

    /**
     * Метод для обчислення рівняння для заданого x
     * Використовує клас Equations з пакету lab4
     * Може кидати виключення CalcException
     */
    public void calculate(int x) throws CalcException {
        Equations eq = new Equations();
        result = eq.calculate(x);
    }

    /**
     * Гетер для отримання результату
     * @return result - обчислене значення
     */
    public double getResult() {
        return result;
    }

    /**
     * Метод для запису результату у текстовий файл
     * @param fName - назва файлу для запису
     * Використовується PrintWriter
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f", result);
        f.close();
    }

    /**
     * Метод для читання результату з текстового файлу
     * @param fName - назва файлу для читання
     * Використовується Scanner
     */
    public void readResTxt(String fName) throws FileNotFoundException {
        File f = new File(fName);

        if (!f.exists()) {
            throw new FileNotFoundException(String.format(
                    "File %s not found", fName
            ));
        }

        Scanner s = new Scanner(f);
        result = s.nextDouble();
        s.close();
    }

    /**
     * Метод для запису результату у бінарний файл
     * @param fName - назва файлу для запису
     * Використовується DataOutputStream
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Метод для читання результату з бінарного файлу
     * @param fName - назва файлу для читання
     * Використовується DataInputStream
     */
    public void readResBin(String fName) throws IOException {
    try (DataInputStream f = new DataInputStream(new FileInputStream(fName))) {
        result = f.readDouble();
    }
    catch (Exception ex) {                      // всі інші невідомі помилки
        System.out.println("Unknown error");
    }}
}
