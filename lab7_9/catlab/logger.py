class Logger:
    """Клас для логування дій у файл та консоль."""

    def __init__(self, filename="cat.txt"):
        # Відкриваємо файл для запису
        self._file = open(filename, "w", encoding="utf-8")

    def log(self, text: str):
        """Виводить повідомлення у консоль та записує у файл."""
        print(text)
        self._file.write(f"{text}\n")
        self._file.flush()  # одразу записуємо у файл

    def close(self):
        """Закриває файл журналу після завершення роботи."""
        self._file.write("Закриття файлу журналу.\n")
        self._file.close()