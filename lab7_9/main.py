"""
Головний модуль для демонстрації роботи лабораторії котів (catlab).
Цей файл створює екземпляр класу Cat та виконує серію дій,
демонструючи наслідування та логування подій.
"""
from catlab.cat import Cat

def main():
    cat = Cat("Кузя", 7, "чорно-білий")

    # Виклики всіх методів кота
    cat.voice()
    cat.eat("Віскас")
    cat.sleep(10)
    cat.play()
    cat.move_tail("вліво")
    cat.scratch()
    cat.bite_owner()
    cat.catch_mouse()
    cat.do_experiment()
    cat.show_info()

    print("\nУсі експерименти виконано!")
    cat.dispose()


if __name__ == "__main__":
    main()
