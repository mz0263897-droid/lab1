package KI.Bilanyn.lab6;

/**
 * Приклад реалізації Item — PackageItem (посилка).
 */
public class PackageItem implements Item {
    private final String id;
    private final int weight; // як "size"

    /**
     * Конструктор посилки.
     * @param id ідентифікатор
     * @param weight вага (size)
     */
    public PackageItem(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getSize() {
        return weight;
    }

    public void print() {
        System.out.println("PackageItem{id='" + id + "', weight=" + weight + "}");
    }
    /**
     * Перевизначений метод equals() для порівняння об'єктів.
     * Порівнюються id та вага.
     * return true, якщо об'єкти однакові
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageItem)) return false;
        PackageItem other = (PackageItem) o;
        return this.id.equals(other.id) && this.weight == other.weight;
    }
    /**
     * Перевизначений метод hashCode().
     * Забезпечує коректну роботу в хеш-колекціях.
     * return хеш-код об'єкта
     */
    public int hashCode() {
        return id.hashCode() * 31 + weight;
    }
}

