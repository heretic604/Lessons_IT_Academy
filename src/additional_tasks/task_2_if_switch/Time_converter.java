package additional_tasks.task_2_if_switch;
import java.util.Scanner;

/**
 * Напишите программу, которая будет переводить секунды в форматированный вид - часы минуты секунды учитывая окончания слов.
 * Добавьте 3 строчку, которая будет выводить недели, сутки, часы минуты и секунды.
 * + добавлен запрос от пользователя количества секунд
 * + добавлена проверка на желание продолжить
 */
public class Time_converter{

    public static void main (String[] args){
        do {
            convertSec();
        } while (toContinue());
    }

    public static boolean toContinue(){
        System.out.print("Хотите еще? (+/-) ");
        Scanner check = new Scanner(System.in);
        String answer = check.nextLine();
        if (answer.equals("+"))
            return true;
        else
            return false;
    }

    public static void convertSec(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество секунд ");
        long num = scan.nextLong();
        int sec = (int)(num % 60);
        int week = (int)(num / 604_800);
        int day = (int)((num - (week * 604_800)) / 86_400);
        int hour = (int)((num - (week * 604_800) - (day * 86400)) / 3600);
        int min = (int)((num - (week * 604800) - (day * 86400) - (hour * 3600)) / 60);
        String secStr;
        String minStr;
        String hourStr;
        String dayStr;
        String weekStr;

        if ((sec < 10 || sec > 20) && (sec % 10 == 2 || sec % 10 == 3 || sec % 10 == 4)){
            secStr = " секунды";
        } else if ((sec < 10 || sec > 20) && sec % 10 == 1){
            secStr = " секунда";
        } else {
            secStr = " секунд";
        }

        if ((min < 10 || min > 20) && (min % 10 == 2 || min % 10 == 3 || min % 10 == 4)){
            minStr = " минуты ";
        } else if ((min < 10 || min > 20) && min % 10 == 1){
            minStr = " минута ";
        } else {
            minStr = " минут ";
        }

        if ((hour < 10 || hour > 20) && (hour % 10 == 2 || hour % 10 == 3 || hour % 10 == 4)){
            hourStr = " часа ";
        } else if ((hour < 10 || hour > 20) && hour % 10 == 1){
            hourStr = " час ";
        } else {
            hourStr = " часов ";
        }

        if ((day < 10 || day > 20) && (day % 10 == 2 || day % 10 == 3 || day % 10 == 4)){
            dayStr = " дня ";
        } else if ((day < 10 || day > 20) && day % 10 == 1){
            dayStr = " день ";
        } else {
            dayStr = " дней ";
        }

        if ((week < 10 || week > 20) && (week % 10 == 2 || week % 10 == 3 || week % 10 == 4)){
            weekStr = " недели ";
        } else if ((week < 10 || week > 20) && week % 10 == 1){
            weekStr = " неделя ";
        } else {
            weekStr = " недель ";
        }

        if (num <= 3600){
            System.out.println(min + minStr + sec + secStr);
        } else if (num < 86400){
            System.out.println(hour + hourStr + min + minStr + sec + secStr);
        } else {
            System.out.println(week + weekStr + day + dayStr + hour + hourStr + min + minStr + sec + secStr);
        }
    }
}