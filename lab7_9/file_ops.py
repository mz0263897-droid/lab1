import os
import struct
import math

TEXT_FILENAME = "result.txt"
BIN_FILENAME = "result.bin"

def calculate(x_rad: float) -> float:
    """Обчислює y = cos(x) / sin(x)."""
    s = math.sin(x_rad)
    if abs(s) < 1e-12:
        raise ZeroDivisionError("sin(x) = 0. Ділення неможливе.")
    return math.cos(x_rad) / s

def write_res_txt(fname: str, result: float) -> None:
    """Записує результат у текстовий файл."""
    with open(fname, 'w', encoding='utf-8') as f:
        f.write(f"{result}\n")

def read_res_txt(fname: str) -> str:
    """Читає вміст текстового файлу."""
    try:
        if not os.path.exists(fname):
            raise FileNotFoundError(f"Файл {fname} не знайдено.")
        with open(fname, 'r', encoding='utf-8') as f:
            return f.read()
    except Exception as e:
        print("Помилка читання текстового файлу:", e)
        return ""

def write_res_bin(fname: str, result: float) -> None:
    """Записує результат у бінарному форматі double."""
    with open(fname, 'wb') as f:
        f.write(struct.pack('d', result))

def read_res_bin(fname: str) -> float:
    """Читає число з бінарного файлу (double)."""
    try:
        if not os.path.exists(fname):
            raise FileNotFoundError(f"Файл {fname} не знайдено.")
        with open(fname, 'rb') as f:
            data = f.read(struct.calcsize('d'))
            return struct.unpack('d', data)[0]
    except Exception as e:
        print("Помилка читання бінарного файлу:", e)
        return 0.0
