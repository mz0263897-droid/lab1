from catlab.animal import Animal

class Cat(Animal):
    """Клас піддослідного кота, наслідує Animal.
    Додає специфічні дії кота та логування цих дій.
    """


    def __init__(self, name="Кіт", age=1, color="білий"):
        # Викликаємо конструктор батьківського класу
        super().__init__(name, age, color)
        self._logger.log(f"Створено кота: {self._name}")




    def voice(self):
        """Кіт видає звук 'Мяу'."""
        self._logger.log(f"{self._name} каже: Мяу!")
    A=0


    def eat(self, food):
        """Кіт їсть певну їжу."""
        self._logger.log(f"{self._name} їсть {food}")

    def sleep(self, hours):
        """Кіт спить певну кількість годин."""
        self._logger.log(f"{self._name} спить {hours} годин")

    def play(self):
        """Кіт грається."""
        self._logger.log(f"{self._name} грається")

    def move_tail(self, direction):
        """Кіт рухає хвостом у певному напрямку."""
        self._logger.log(f"{self._name} рухає хвостом {direction}")

    def scratch(self):
        """Кіт дряпає меблі."""
        self._logger.log(f"{self._name} дряпає диван!")

    def bite_owner(self):
        """Кіт кусає господаря."""
        self._logger.log(f"{self._name} кусає господаря!")

    def catch_mouse(self):
        """Кіт ловить мишу."""
        self._logger.log(f"{self._name} ловить мишу!")

    def do_experiment(self):
        """Кіт виконує експеримент — ловить мишу."""
        self._logger.log(f"{self._name} (ловить мишу)")
        self.catch_mouse()
