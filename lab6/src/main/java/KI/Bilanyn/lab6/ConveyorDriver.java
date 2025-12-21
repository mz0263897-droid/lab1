package KI.Bilanyn.lab6;

/**
 * Драйвер для демонстрації роботи класу Conveyor.
 * Додаємо елементи двох різних класів (PackageItem та Box),
 * друкуємо вміст, знаходимо мінімальний елемент та демонструємо видалення.
 */
public class ConveyorDriver {
    public static void main(String[] args) {
        // Використаємо Conveyor з параметром Item
        Conveyor<Item> conv = new Conveyor<>();

        conv.addItem(new PackageItem("PCK-001", 120));
        conv.addItem(new Box("Box-A", 300));
        conv.addItem(new PackageItem("PCK-002", 85));
        conv.addItem(new Box("Box-B", 180));

        System.out.println();
        conv.printAll();

        System.out.println();
        Item min = conv.findMin();
        if (min != null) {
            System.out.println("The smallest item on conveyor is:");
            min.print();
        } else {
            System.out.println("Conveyor is empty.");
        }

        System.out.println();
        // Видалимо елемент
        conv.removeItem(1);

        System.out.println();
        conv.printAll();
    }
}
