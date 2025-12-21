package KI.Bilanyn.lab6;


import java.util.ArrayList;
import java.util.List;

/**
 * Параметризований клас Conveyor<T extends Item> — контейнер для елементів конвеєру.
 * Реалізує додавання, видалення, пошук мінімального елементу.
 * @param <T> тип елементів, що реалізують Item
 */
public class Conveyor<T extends Item> {

    private final List<T> arr;

    /**
     * Конструктор — створює порожній конвеєр.
     */
    public Conveyor() {
        arr = new ArrayList<>();
    }

    /**
     * Додає елемент до конвеєра.
     * @param item елемент
     */
    public void addItem(T item) {
        arr.add(item);
        System.out.print("Element added: ");
        item.print();
    }

    /**
     * Видаляє елемент за індексом.
     * @param index індекс
     */
    public void removeItem(int index) {
        T removed = arr.remove(index);
        System.out.print("Element removed: ");
        removed.print();
    }

    /**
     * Видаляє перше входження елемента, якщо знайдено.
     * @param item елемент
     * @return true якщо видалено
     */
    public boolean removeItem(T item) {
        boolean res = arr.remove(item);
        if (res) {
            System.out.print("Element removed (by object): ");
            item.print();
        }
        return res;
    }

    /**
     * Повертає найменший елемент у конвеєрі за getSize().
     * Для порожнього конвеєра повертає null.
     * @return мінімальний елемент або null
     */
    public T findMin() {
        if (arr.isEmpty()) return null;
        T min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            T cur = arr.get(i);
            if (cur.compareTo(min) < 0) min = cur;
        }
        return min;
    }

    /**
     * Повертає кількість елементів у контейнері.
     * @return розмір
     */
    public int size() {
        return arr.size();
    }

    /**
     * Виводить всі елементи конвеєра.
     */
    public void printAll() {
        System.out.println("Conveyor contents (" + arr.size() + " items):");
        for (T item : arr) {
            item.print();
        }
    }

    /**
     * Отримати елемент за індексом.
     * @param index індекс
     * @return елемент
     */
    public T get(int index) {
        return arr.get(index);
    }
}

