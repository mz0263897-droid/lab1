package Bilanyn.Roman.KI_305;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Клас Cat — модель піддослідного кота.
 * Наслідує абстрактний клас Animal та реалізує інтерфейс Experimentable.
 * Забезпечує поведінку кота та веде журнал дій у файл.
 */
public class Cat extends Animal implements Experimentable {

    private Tail tail;     // хвіст кота
    private Paw paw;       // лапи кота
    private Mood mood;     // настрій кота
    private PrintWriter log; // лог-файл для запису дій кота

    /**
     * Конструктор за замовчуванням.
     * Створює білого кота віком 1 рік.
     */
    public Cat() throws FileNotFoundException {
        this("Кіт", 1, "білий");
    }

    /**
     * Основний конструктор кота.
     *
     * @param name  ім’я кота
     * @param age   вік кота
     * @param color колір шерсті
     */
    public Cat(String name, int age, String color) throws FileNotFoundException {
        super(name, age, color);
        this.tail = new Tail();
        this.paw = new Paw();
        this.mood = new Mood();
        log = new PrintWriter(new File("Cat.txt"));
        log.printf("Створено кота: %s%n", name);
    }


    // Реалізація абстрактних методів Animal


    /**
     * Метод, який виводить голос кота.
     */
    public void voice() {
        log.printf("%s каже: Мяу!%n", name);
        log.flush();
    }

    /**
     * Виводить інформацію про кота (ім'я, вік, колір).
     */
    public void showInfo() {
        log.printf("Ім'я: %s, Вік: %d, Колір: %s%n", name, age, color);
        log.flush();
    }


    // Реалізація інтерфейсу Experimentable


    /**
     * Метод експерименту над котом.
     * У нашому випадку експеримент — це процес ловлі миші.
     */
    public void doExperiment() {
        catchMouse();
    }


    // Методи поведінки кота


    /**
     * Кіт їсть певну їжу.
     *
     * @param food їжа, яку кіт споживає
     */
    public void eat(String food) {
        log.printf("%s їсть %s%n", name, food);
        log.flush();
    }

    /**
     * Кіт спить певну кількість годин.
     *
     * @param hours кількість годин сну
     */
    public void sleep(int hours) {
        log.printf("%s спить %d годин.%n", name, hours);
        log.flush();
        mood.setState(Mood.State.CALM);
    }

    /**
     * Кіт грається, рухає лапами та хвостом.
     */
    public void play() {
        log.printf("%s грається з другим котом.%n", name);
        paw.move();
        tail.move("швидко");
        log.flush();
    }

    /**
     * Кіт рухає хвостом у заданому напрямку.
     *
     * @param direction напрямок руху
     */
    public void moveTail(String direction) {
        tail.move(direction);
        log.printf("%s рухає хвостом %s%n", name, direction);
        log.flush();
    }

    /**
     * Кіт дряпає диван.
     */
    public void scratch() {
        paw.scratch();
        log.printf("%s дряпає диван!%n", name);
        log.flush();
    }

    /**
     * Кіт кусає господаря.
     */
    public void biteOwner() {
        log.printf("%s кусає господаря!%n", name);
        log.flush();
        mood.setState(Mood.State.ANGRY);
    }

    /**
     * Кіт ловить мишу.
     */
    public void catchMouse() {
        log.printf("%s ловить мишу!%n", name);
        log.flush();
        mood.setState(Mood.State.HAPPY);
    }

    /**
     * Закриває лог-файл.
     */
    public void dispose() {
        log.println("Закриття файлу журналу.");
        log.flush();
        log.close();
    }
}


// Інтерфейс Experimentable

/**
 * Інтерфейс, який визначає об'єкт, над яким можна проводити експерименти.
 */
interface Experimentable {

    /**
     * Метод виконання експерименту.
     */
    void doExperiment();
}


// Додаткові службові класи (хвіст, лапа, настрій)


/**
 * Клас, який моделює хвіст кота.
 */
class Tail {
    /**
     * Рух хвоста у заданому напрямку.
     */
    public void move(String direction) {
        System.out.println("Хвіст рухається " + direction);
    }
}

/**
 * Клас лапи кота.
 * Містить поведінку лап.
 */
class Paw {

    /**
     * Рух лапами.
     */
    public void move() {
        System.out.println("Кіт рухає лапами.");
    }

    /**
     * Дряпання лапою.
     */
    public void scratch() {
        System.out.println("Кіт дряпає!");
    }
}

/**
 * Клас Mood — модель настрою кота.
 */
class Mood {

    /**
     * Перелічення можливих станів настрою кота.
     */
    enum State { CALM, HAPPY, ACTIVE, ANGRY }

    private State state;

    /**
     * Початково кіт спокійний.
     */
    public Mood() {
        state = State.CALM;
    }

    /**
     * Встановлення нового стану настрою.
     */
    public void setState(State newState) {
        state = newState;
    }

    /**
     * Повертає поточний стан настрою.
     */
    public State getState() {
        return state;
    }
}
