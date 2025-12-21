package KI.Bilanyn.lab6;


/**
 * Приклад реалізації Item — Box (коробка).
 */
public class Box implements Item {
    private final String label;
    private final int volume; // як "size"

    public Box(String label, int volume) {
        this.label = label;
        this.volume = volume;
    }


    public int getSize() {
        return volume;
    }

    public void print() {
        System.out.println("Box{label='" + label + "', volume=" + volume + "}");
    }
    /**
     * Перевизначений метод equals() для порівняння об'єктів.
     * Порівнюються id та вага.
     * return true, якщо об'єкти однакові
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box other = (Box) o;
        return this.label.equals(other.label) && this.volume == other.volume;
    }
    /**
     * Перевизначений метод hashCode().
     * Забезпечує коректну роботу в хеш-колекціях.
     * return хеш-код об'єкта
     */
    public int hashCode() {
        return label.hashCode() * 31 + volume;
    }
}

