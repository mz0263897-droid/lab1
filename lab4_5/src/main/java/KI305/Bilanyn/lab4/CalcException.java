package KI305.Bilanyn.lab4;

/**
 * Class <code>CalcException</code> more precisely describes arithmetic problems.
 * Використовується для передачі детального повідомлення про помилки.
 */
public class CalcException extends ArithmeticException {

    public CalcException() {} // Конструктор без повідомлення

    public CalcException(String cause) {
        super(cause); // Передача повідомлення у суперклас
    }
}
