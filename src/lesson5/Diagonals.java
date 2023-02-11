package lesson5;

/**
 * Класс, в котором выплняются задания 1 и 2 пунктов.
 */
public class Diagonals {

    private static int lengthArrayNumbers;
    private static double[] arrayNumbers;
    private static StringBuilder[] arraySB;
    private static int lengthArrayStrings;

    /**
     * Основной метод данного класса.
     */
    public static void execute() {
        for (int i = 0; i < Matrix.diagonals.length; i++) {
            if (Matrix.diagonals[i].contains(".")) {
                lengthArrayNumbers++;
            } else {
                lengthArrayStrings++;
            }
        }

        arrayNumbers = new double[lengthArrayNumbers];
        arraySB = new StringBuilder[lengthArrayStrings];

        int j = 0;
        int k = 0;
        for (int i = 0; i < Matrix.diagonals.length; i++) {
            if (Matrix.diagonals[i].contains(".")) {
                arrayNumbers[j] = convertToDouble(Matrix.diagonals[i]);
                j++;

            } else {
                arraySB[k] = convertToSB(Matrix.diagonals[i]);
                k++;
            }
        }

        System.out.println("Массив StringBuilder из пункта 3.1:");
        for (StringBuilder sb : arraySB) {
            System.out.print(sb + ", ");
        }

        System.out.println('\n' + "Массив чисел из пункта 3.2:");
        for (double d : arrayNumbers) {
            System.out.print(d + "_");
        }

        System.out.println('\n' + "Повторный вывод изначальной матрицы (пункт 4):");
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                System.out.print(" " + Matrix.getMatrix()[i][l] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Вспомогательный метод, который будет получать числа из массива диагоналей и обрабатывать сошласно тз (пункт 3.2)
     */
    public static double convertToDouble(String str) {
        double temp1 = Double.parseDouble(str);
        double temp2;
        double target;
        if (temp1 > 1) {
            temp2 = temp1 * 10;
            if ((temp2 % 10) >= 7) {
                target = Math.ceil(temp1);
            } else {
                target = Math.floor(temp1);
            }
        } else {
            if (temp1 > 0.7) {
                target = Math.ceil(temp1);
            } else {
                target = Math.floor(temp1);
            }
        }
        return target;
    }

    /**
     * Вспомогательеый метод, который берет из массива диагоналей строки и обрабатывает сошласно тз (пункт 3.1)
     */
    public static StringBuilder convertToSB(String str) {
        char[] chars = new char[3];
        int j = 1;
        for (int i = 0; i < 3; i++) {
            chars[i] = str.charAt(j);
            j++;
        }
        String temp = new String(chars);
        StringBuilder stringBuilder = new StringBuilder(temp);
        return stringBuilder;
    }
}
