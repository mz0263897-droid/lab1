package KI305.Bilanyn.lab4;

/**
 * Class <code>Equations</code> implements method for y = cos(x) / sin(x)
 */
public class Equations {

    /**
     * Calculates y = cos(x) / sin(x)
     * @param x angle in degrees
     * @return y
     * @throws CalcException when sin(x) = 0 or result invalid
     */
    public double calculate(int x) throws CalcException {

        double y, rad;

        // Переведення значення з градусів у радіани,
        rad = x * Math.PI / 180.0;

        try {
            // Основне обчислення виразу
            y = Math.cos(rad) / Math.sin(rad);

            // Перевірка на некоректні значення результату
            if (Double.isNaN(y) || Double.isInfinite(y) || Math.sin(rad) == 0) {
                throw new ArithmeticException(); // Передаємо далі в catch
            }
        }
        catch (ArithmeticException ex) {

            // Якщо sin(x) == 0 — це ділення на нуль
            if (Math.sin(rad) == 0)
                throw new CalcException("Exception reason: sin(x) = 0 → division by zero");

            // В інших випадках причина невідома
            throw new CalcException("Unknown reason of the exception during calculation");
        }

        return y; // Повернення результату
    }
}
