
from catlab.logger import Logger

class Animal:
    """Базовий клас тварини."""

    def __init__(self, name="Тварина", age=0, color="невідомий"):
        self._name = name
        self._age = age
        self._color = color
        self._logger = Logger("cat.txt")  # Створюємо об'єкт логера
        self._logger.log(f"Створено тварину: {self._name}")

    def voice(self):
        """Тварина видає загальний звук."""
        self._logger.log(f"{self._name} видає звук!")

    def show_info(self):
        """Виводить інформацію про тварину."""
        self._logger.log(f"Ім'я: {self._name}, Вік: {self._age}, Колір: {self._color}")

    def dispose(self):
        """Закриває логер та завершує роботу з об'єктом."""
        self._logger.close()