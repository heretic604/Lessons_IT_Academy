/**
 * Программа определяет пору года по номеру месяца
 * и выдаёт ошибку в случае некорректного ввода.
 */
package lesson_3.months;

import java.util.Scanner;

public class Months {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the month (1-12): ");
        int month = scan.nextInt();

        switch (month) {
            case 1, 2, 12:
                System.out.println("Winter");
                break;
            case 3, 4, 5:
                System.out.println("Spring");
                break;
            case 6, 7, 8:
                System.out.println("Summer");
                break;
            case 9, 10, 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Error. Please, try again");
        }
    }
}
