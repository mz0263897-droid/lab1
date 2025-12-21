"""
Головна функція програми.

Зчитує з клавіатури розмір квадратної матриці та символ-заповнювач.
Формує зубчастий список відповідно до заданої зони матриці.
Результат виводиться на екран та записується у файл KZP.txt.
"""
import sys
from file_ops import *


def main():
    try:
        # Зчитування вхідного значення x у градусах від користувача
        x_deg_str = input("Введіть x у градусах: ").strip()
        x_deg = float(x_deg_str)
    except ValueError:
        print("Невірний ввід. Введіть дійсне число.")
        sys.exit(1)

    # Переводимо градуси в радіани
    x_rad = math.radians(x_deg)

    try:
        result = calculate(x_rad)
        print(f"Обчислено: y = cos({x_deg}°) / sin({x_deg}°) = {result}")
    except ZeroDivisionError as e:
        print("Математична помилка:", e)
        sys.exit(1)
    except Exception as e:
        print("Невідома помилка при обчисленні:", e)
        sys.exit(1)

    # Запис результатів у файли
    try:
        write_res_txt(TEXT_FILENAME, result)
        write_res_bin(BIN_FILENAME, result)
        print(f"Результат записано у {TEXT_FILENAME} та {BIN_FILENAME}")
    except Exception as e:
        print("Помилка запису файлів:", e)
        sys.exit(1)

    # Демонстрація читання з файлів
    print("Читання з текстового файлу:")
    print(read_res_txt(TEXT_FILENAME), end='')

    print("Читання з бінарного файлу:")
    print(read_res_bin(BIN_FILENAME))

if __name__ == "__main__":
    main()
