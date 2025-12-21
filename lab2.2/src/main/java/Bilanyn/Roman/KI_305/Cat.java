package Bilanyn.Roman.KI_305;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Клас <code>Cat</code> моделює поведінку кота.
 * Містить поля, що описують його складові частини та стан.
 * Лог дій зберігається у файл Cat.txt.
 * @author Roman
 * @version 1.0
 */
public class Cat {

    private Tail tail;
    private Paw paw;
    private Mood mood;
    private String name;
    private int age;
    private String color;
    private PrintWriter log;

    /**
     * Конструктор за замовчуванням.
     * Створює кота з типовими параметрами.
     * @throws FileNotFoundException якщо не вдається створити лог-файл
     */
    public Cat() throws FileNotFoundException {
        this("Кіт", 1, "білий");
    }

    /**
     * Конструктор із параметрами.
     * Ініціалізує всі властивості кота та створює файл журналу дій.
     * @param age вік кота
     * @param color колір шерсті
     * @throws FileNotFoundException якщо не вдається створити лог-файл
     */
    public Cat( int age, String color) throws FileNotFoundException {
        this.age = age;
        this.color = color;
        this.tail = new Tail();
        this.paw = new Paw();
        this.mood = new Mood();
    }
    public Cat(String name, int age, String color) throws FileNotFoundException {
        this.name = name;
        this(age,color);
        log = new PrintWriter(new File("Cat.txt"));
        log.println("Створено кота: " + name);
    }
    /**
     * Метод імітує нявкання кота.
     * Записує у лог-файл повідомлення про нявкання.
     */
    public void meo() {
        log.printf("%s каже: Мяу!", name);
        log.flush();
    }

    /**
     * Метод імітує процес їжі кота.
     * Записує у лог-файл, яку їжу споживає кіт.
     * @param food назва їжі, яку їсть кіт
     */
    public void eat(String food) {
        log.printf("%s їсть %s%n", name, food);
        log.flush();
    }

    /**
     * Метод імітує сон кота.
     * Записує у лог-файл кількість годин сну та встановлює настрій кота у CALM.
     * @param hours кількість годин сну
     */
    public void sleep(int hours) {
        log.printf("%s спить %d годин.%n", name, hours);
        log.flush();
        mood.setState(Mood.State.CALM);
    }

    /**
     * Метод імітує гру кота.
     * Кіт грається, рухає лапами та хвостом, а події записуються у лог-файл.
     */
    public void play() {
        log.printf("%s грається з другим котом.%n", name);
        paw.move();
        tail.move("швидко");
        log.flush();
    }

    /**
     * Метод задає рух хвоста кота.
     * Записує напрямок руху хвоста у лог-файл.
     * @param direction напрямок руху хвоста
     */
    public void moveTail(String direction) {
        tail.move(direction);
        log.printf("%s рухає хвостом %s%n", name, direction);
        log.flush();
    }

    /**
     * Метод імітує дряпання котом.
     * Записує у лог-файл факт дряпання.
     */
    public void scratch() {
        paw.scratch();
        log.printf("%s дряпає диван!%n", name);
        log.flush();
    }

    /**
     * Метод імітує укус господаря котом.
     * Записує у лог-файл подію укусу та встановлює настрій кота у ANGRY.
     */
    public void biteOwner() {
        log.printf("%s кусає свого хазяїна, який дає йому їсти!%n", name);
        log.flush();
        mood.setState(Mood.State.ANGRY);
    }

    /**
     * Метод виводить інформацію про кота у лог-файл.
     * Включає ім'я, вік та колір шерсті кота.
     */
    public void showInfo() {
        log.printf("Ім'я: %s, Вік: %d, Колір: %s%n", name, age, color);
        log.flush();
    }

    /**
     * Метод імітує ловлю мишей котом.
     * Записує у лог-файл факт полювання та встановлює настрій кота у HAPPY.
     */
    public void catchMouse() {
        log.printf("%s полює і ловить мишу!%n", name);
        log.flush();
        mood.setState(Mood.State.HAPPY);
    }

    /**
     * 10. Метод завершує роботу і коректно закриває файл журналу.
     */
    public void dispose() {
        log.println("Закриття файлу журналу.");
        log.flush();
        log.close();
    }
}

/**
 * Клас <code>Tail</code> — описує хвіст кота.
 */
class Tail {
    /**
     * Метод задає рух хвоста.
     * @param direction напрямок руху
     */
    public void move(String direction) {
        System.out.println("Хвіст рухається " + direction);
    }
}

/**
 * Клас <code>Paw</code> — описує лапу кота.
 */
class Paw {
    /**
     * Метод імітує рух лапами.
     */
    public void move() {
        System.out.println("Кіт рухає лапами.");
    }

    /**
     * Метод імітує дряпання лапами.
     */
    public void scratch() {
        System.out.println("Кіт дряпає!");
    }
}

/**
 * Клас <code>Mood</code> — описує настрій кота.
 */
class Mood {

    /** Перелік можливих станів настрою. */
    enum State { CALM, HAPPY, ACTIVE, ANGRY }

    private State state;

    /** Конструктор за замовчуванням — встановлює стан CALM. */
    public Mood() {
        state = State.CALM;
    }

    /**
     * Встановлення нового стану настрою.
     * @param newState новий стан
     */
    public void setState(State newState) {
        state = newState;
    }

    /**
     * Отримання поточного стану настрою.
     * @return поточний стан
     */
    public State getState() {
        return state;
    }
}
