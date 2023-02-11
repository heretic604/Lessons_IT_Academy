package additional_tasks.task_1_variables;

/**
 * Вывести последнюю цифру числа
 * Найти сумму цифр ab + cd числа abcd
 * Вывести 3юю цифру 5ти-значного числа
 * Вывести длину отрезка, проходящей через две точки
 * Имеется прямоугольное отверстие размера a на b.
 * Определить можно ли полностью закрыть отверстие круглой картонкой радиусом r Пример:6 8 5
 * Вывести уравнение прямой, проходящей через две точки
 */
public class Variables{
    public static void main(String[] args){ //Выполняет по очереди задачи
        getLastNumber();
        getSum();
        getThirdNumber();
        getLength();
        closeHole();
        getEquation();
    }

    public static void getLastNumber () { //Вывести последнюю цифру числа
        int num = 6543;
        int lastNum = num % 10;
        System.out.println("Последняя цифра числа " + num + ": " + lastNum);
    }

    public static void getSum () { //Найти сумму цифр ab + cd числа abcd
        int abcd = 4863;
        int ab = abcd / 100;
        int cd = abcd % 100;
        int sum = ab + cd;
        System.out.println("Сумма числа " + abcd + " равна: " + sum);
    }

    public static void getThirdNumber () { //Вывести 3юю цифру 5ти-значного числа
        int num = 12345;
        int third = num / 100 % 10;
        System.out.println("Третья цифра числа " + num + " будет " + third);
    }

    public static void getLength(){ //Вывести длину отрезка, проходящей через две точки
        // √ ((X2-X1)²+(Y2-Y1)²) формула длины отрезка. Точки (5,3) и (8,7)
        int x1 = 5;
        int y1 = 3;
        int x2 = 8;
        int y2 = 7;
        double lenght = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        System.out.println("Длина отрезка равна: " + lenght);
    }

    public static void closeHole() {
		/* Имеется прямоугольное отверстие размера a на b.
		Определить можно ли полностью закрыть отверстие круглой картонкой радиусом r Пример:6 8 5 */
        int a = 6;
        int b = 8;
        int r = 5;
        int d = r*2;
        if (d > a && d > b){
            System.out.println("Закрывает");
        } else {
            System.out.println("Не закрывает");
        }
    }

    /* Вывести уравнение прямой, проходящей через две точки
     *
     * x - x1     y - y1
     * ------- = -------
     * x2 - x1   y2 - y1
     *
     * (x - x1)(y2 - y1) = (y - y1)(x2 - x1)
     *
     * y = ax + b;
     */
    public static void getEquation(){
        int x1 = 1;
        int y1 = 4;
        int x2 = 5;
        int y2 = 8;
        double a = (y1 - y2) / (x1 - x2);
        double b = - (a * x1) + y1;
        if(b >= 0) {
            System.out.println("y = " + a + "x+" + b);
        } else {
            System.out.println("y = " + a + "x" + b);
        }
    }
}
