package Bilanyn.Roman.KI_305;

/**
 * Абстрактний клас Animal — базовий клас для всіх тварин.
 */
public abstract class Animal {

    protected String name;
    protected int age;
    protected String color;

    /**
     * Конструктор
     * Ім'я, вік, колір тварини
     */
    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * Абстрактний метод голосу.
     * Має бути перевизначений у нащадках.
     */
    public abstract void voice();

    /**
     * Абстрактний метод для виведення інформації.
     */
    public abstract void showInfo();
}
