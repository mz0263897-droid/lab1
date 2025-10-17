import java.io.*;
import java.util.*;

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

public class Lab1BylanynKI305 {
    /**
     * Статичний метод main є точкою входу в програму
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        String filler;

        Scanner in = new Scanner(System.in);
        File dataFile = new File("KZP.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір масиву: ");
        nRows = in.nextInt();
        in.nextLine();

        System.out.print("Введіть символ або цифру для заповнення: ");
        filler = in.nextLine();

        // Визначаємо висоту трикутника (займає більшу нижню частину при непарному N)
        int H = (nRows + 1) / 2;

        // Визначаємо центральну вісь для вирівнювання
        int center = nRows / 2;

        // Визначаємо перший рядок, з якого починається трикутник (вершина).
        int startRow = nRows - H;

        // Малюємо квадрат nRows x nRows
        for (int i = 0; i < nRows; i++) { // Рядки (i: 0 до N-1)
            for (int j = 0; j < nRows; j++) { // Стовпці (j: 0 до N-1)

                // Перевіряємо, чи ми знаходимося в області, де має бути трикутник (рядки від startRow до N-1)
                if (i >= startRow) {

                    // Обчислюємо відносний індекс рядка (0 на вершині трикутника, H-1 на основі)
                    int i_relative = i - startRow;

                    // Умова для заповнення трикутника, вершиною вгору:
                    // Відступи зменшуються, а ширина збільшується зі зростанням i_relative.

                    // Ліва межа: center - i_relative
                    int leftBoundary = center - i_relative;

                    // Права межа: center + i_relative
                    int rightBoundary = center + i_relative;

                    if (j >= leftBoundary && j <= rightBoundary) {
                        System.out.print(filler);
                        fout.print(filler);
                    } else {
                        // Пробіл для формування трикутника
                        System.out.print(" ");
                        fout.print(" ");
                    }
                } else {
                    // Це верхня порожня частина (квадрата)
                    System.out.print(" ");
                    fout.print(" ");
                }
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
        System.out.println("\nРезультат записано у файл " + dataFile.getName());
    }
}
