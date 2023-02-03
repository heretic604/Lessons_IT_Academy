package additional_tasks;

import java.util.Scanner;

/**
 * Найти среднее число из трех, введенных с клавиатуры
 * т.е. число, которое находится между двумя другими среди введенных
 * (не средне арифмитическое)
 */
public class Average_number {
    private static final String INSERT = "Please, insert a number %s ";
    private static final String OUTPUT = "Average number is %s";

    public static void main(String[] args) {

        int finalNum;

        Scanner scan = new Scanner(System.in);
        System.out.printf(INSERT, 1);
        int a = scan.nextInt();
        System.out.printf(INSERT, 2);
        int b = scan.nextInt();
        System.out.printf(INSERT, 3);
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
