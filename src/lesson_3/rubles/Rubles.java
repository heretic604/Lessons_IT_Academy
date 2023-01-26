/**
 * Программа ставит слово "рубль" в правильный падеж в зависимости от суммы.
 */
package lesson_3.rubles;

import java.util.Scanner;

public class Rubles {
    public static void main(String[] args) {
        getRubles();
    }

    public static void getRubles() {
        System.out.print("Please Enter your amount of money: ");
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int end = sum % 10;
        String ruble;
        if (end == 1) {
            ruble = "рубль";
        } else if (end == 2 || end == 3 || end == 4) {
            ruble = "рубля";
        } else {
            ruble = "рублей";
        }
        System.out.println("Ваща сумма: " + sum + " " + ruble);
    }
}