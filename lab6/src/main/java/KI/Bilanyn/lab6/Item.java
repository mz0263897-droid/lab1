package KI.Bilanyn.lab6;

/**
 * Інтерфейс Item — інтерфейс предметної області "елемент конвеєру".
 * Реалізації повинні повертати розмір (size) і вміти вивести себе.
 */
public interface Item extends Comparable<Item> {
    /**
     * Розмір елемента (за яким відбувається порівняння).
     * return розмір (наприклад, вага або об'єм, як int)
     */
    int getSize();

    /**
     * Вивести інформацію про елемент на консоль.
     */
    void print();
    /**
     * Порівнює елементи на основі їх розміру.
     */
    default int compareTo(Item other) {
        return Integer.compare(this.getSize(), other.getSize());
    }
}