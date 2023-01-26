package lesson_3.homework3.rainbow;

import java.util.Scanner;

/**
 * Класс, который обрабатывает запрос, выбирает подходящий метод и выдает результат.
 */
public class Rainbow {

    static final String RED_END = "Красный";
    static final String ORANGE_END = "Оранжевый";
    static final String YELLOW_END = "Желтый";
    static final String GREEN_END = "Зеленый";
    static final String LIGHT_BLUE_END = "Голубой";
    static final String BLUE_END = "Синий";
    static final String PURPLE_END = "Фиолетовый";
    static final String RED_START = "Красно-";
    static final String ORANGE_START = "Оранжево-";
    static final String YELLOW_START = "Желто-";
    static final String GREEN_START = "Зелено-";
    static final String LIGHT_BLUE_START = "Голубо-";
    static final String BLUE_START = "Сине-";
    static final String PURPLE_START = "Фиолетово-";
    static int firstColor;
    static int secondColor;
    static String generalColor;
    static String tone;
    static String name;

    /**
     * В этом методе получаются значения от пользователя, и определяется подходящий для выполнения метод, либо
     * выводится сообщение об ошибке.
     */
    public static void begin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Здравствуйте, введите, пожалуйста, ваше имя: ");
        name = scan.nextLine();
        System.out.print(name + ", пожалуйста, введите номер цвета (1-7): ");
        firstColor = scan.nextInt();
        System.out.print(name + ", введите номер второго цвета (отличный от первого), если хотите получить оттенок," +
                " иначе введите '0': ");
        secondColor = scan.nextInt();
        if (firstColor >= 1 && firstColor <= 7 && secondColor == 0) {
            getOneColor();
        } else if (firstColor >= 1 && firstColor <= 7 && secondColor >= 1 && secondColor <= 7
                && firstColor != secondColor) {
            getTint();
        } else {
            System.out.println(name + ", перестань ломать программу и введи нормальное число!");
        }
        System.out.println("Спасибо за участие, " + name + ", приходи еще!");
    }

    /**
     * Этот метод используется для вывода одного цвета.
     */
    public static void getOneColor() {
        switch (firstColor) {
            case 1:
                generalColor = RED_END;
                break;
            case 2:
                generalColor = ORANGE_END;
                break;
            case 3:
                generalColor = YELLOW_END;
                break;
            case 4:
                generalColor = GREEN_END;
                break;
            case 5:
                generalColor = LIGHT_BLUE_END;
                break;
            case 6:
                generalColor = BLUE_END;
                break;
            case 7:
                generalColor = PURPLE_END;
                break;
        }
        System.out.println(name + ", ваш цвет: " + generalColor);
    }

    /**
     * Этот метод используется для вывода оттенка.
     */
    public static void getTint() {
        switch (firstColor) {
            case 1:
                generalColor = RED_START;
                break;
            case 2:
                generalColor = ORANGE_START;
                break;
            case 3:
                generalColor = YELLOW_START;
                break;
            case 4:
                generalColor = GREEN_START;
                break;
            case 5:
                generalColor = LIGHT_BLUE_START;
                break;
            case 6:
                generalColor = BLUE_START;
                break;
            case 7:
                generalColor = PURPLE_START;
                break;
        }
        switch (secondColor) {
            case 1:
                tone = RED_END;
                break;
            case 2:
                tone = ORANGE_END;
                break;
            case 3:
                tone = YELLOW_END;
                break;
            case 4:
                tone = GREEN_END;
                break;
            case 5:
                tone = LIGHT_BLUE_END;
                break;
            case 6:
                tone = BLUE_END;
                break;
            case 7:
                tone = PURPLE_END;
                break;
        }
        System.out.println(name + ", ваш цвет: " + generalColor + tone);
    }
}

