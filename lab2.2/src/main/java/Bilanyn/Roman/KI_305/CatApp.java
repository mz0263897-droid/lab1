package Bilanyn.Roman.KI_305;

import java.io.FileNotFoundException;
import static java.lang.System.out;

/**
 * Клас-драйвер для демонстрації роботи класу Cat.
 * Демонструє 10 методів із логуванням у файл CatLog.txt.
 * @author Student
 * @version 1.1
 */
public class CatApp {

    /**
     * Головний метод програми.
     * @param args аргументи командного рядка
     * @throws FileNotFoundException якщо не вдається створити лог-файл
     */
    public static void main(String[] args) throws FileNotFoundException {
        Cat myCat = new Cat("Кузя", 7, "чорно-білий");

        myCat.meo();
        myCat.eat("Віскас");
        myCat.sleep(12);
        myCat.play();
        myCat.moveTail("вліво-вправо");
        myCat.scratch();
        myCat.biteOwner();
        myCat.catchMouse();
        myCat.showInfo();

        out.println("Кіт успішно виконав усі дії!");
        myCat.dispose();
    }
}
