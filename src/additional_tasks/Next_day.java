package additional_tasks;

import java.util.Scanner;

/**
 * Напишите программу расчета даты следующего дня введя 3 числа - день месяц и год
 * Пример:
 * 15
 * 3
 * 2000
 * 16 3 2000
 */
public class Next_day {
    private static final String INSERT = "Please, insert a %s: ";

    public static void main(String[] args) {
        execute();
    }
    public static void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf(INSERT, "day");
        int userDay = scanner.nextInt();
        System.out.printf(INSERT, "month");
        int userMonth = scanner.nextInt();
        System.out.printf(INSERT, "year");
        int userYear = scanner.nextInt();
        int nextDay = userDay + 1;
        int nextMonth = userMonth;
        int nextYear = userYear;
        switch (userMonth){
            case 1, 3, 5, 7, 8, 10:
                if (nextDay > 31){
                    nextDay = 1;
                    nextMonth++;
                }
                break;
            case 4, 6, 9, 11:
                if (nextDay > 30){
                    nextDay = 1;
                    nextMonth++;
                }
                break;
            case 2:
                if (nextDay > 28){
                    nextDay = 1;
                    nextMonth++;
                }
                break;
            case 12:
                if (nextDay > 31){
                    nextDay = 1;
                    nextMonth = 1;
                    nextYear++;
                }
        }
        System.out.println(nextDay + " " + nextMonth + " " + nextYear);
    }
}
