package lesson_4;

/**
 * Программа генерирует котиков согласно ТЗ.
 * Не требует участия пользователя.
 */
public class Runner {
    public static void main (String[] args){
        Cat cat = new Cat("Дефолтик", 0);
        cat.startAllCycles();
    }
}
