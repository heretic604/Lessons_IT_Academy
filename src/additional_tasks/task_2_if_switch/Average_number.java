package additional_tasks.task_2_if_switch;

import java.util.Scanner;

/**
 * Найти среднее число из трех, введенных с клавиатуры
 * т.е. число, которое находится между двумя другими среди введенных
 * (не средне арифмитическое)
 */
public class Average_number {
    private static final String INPUT = "Please, insert a number %s ";
    private static final String OUTPUT = "Average number is %s";

    public static void main(String[] args) {

        int finalNum;

        Scanner scan = new Scanner(System.in);
        System.out.printf(INPUT, 1);
        int a = scan.nextInt();
        System.out.printf(INPUT, 2);
        int b = scan.nextInt();
        System.out.printf(INPUT, 3);
        int c = scan.nextInt();

        if ((a > b && a < c) || (a < b && a > c)){
            finalNum = a;
        } else if ((b > a && b < c) || (b < a && b > c)){
            finalNum = b;
        } else {
            finalNum = c;
        }

        System.out.printf(OUTPUT, finalNum);
    }
}
