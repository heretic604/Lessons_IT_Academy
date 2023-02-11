package lesson5;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

/**
 * Класс, в котором выплняются задания 1 и 2 пунктов.
 */
public class Matrix {
    private static String[][] matrix;

    public static String[][] getMatrix() {
        return matrix;
    }

    public static String[] diagonals;
    private static String[] firstDiagonal;
    private static String[] secondDiagonal;

    public static void createMatrix() {
        System.out.println("Вот изначальная матрица: ");
        matrix = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j + 1) % 3 == 0) {
                    matrix[i][j] = getRandomDouble();
                } else {
                    matrix[i][j] = getRandomString();
                }
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String getRandomDouble() {
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        double random = Math.random() * 10;
        BigDecimal randomDouble = new BigDecimal(random, context);
        return randomDouble.toString();
    }

    public static String getRandomString() {
        Random random = new Random();
        char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'z', 'x', 'c', 'v', 'b', 'n', 'm', 'A', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F',
                'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        char[] randomString = new char[7];
        for (int i = 0; i < randomString.length; i++) {
            randomString[i] = letters[random.nextInt(0, letters.length - 1)];
        }
        return String.valueOf(randomString);
    }

    public static void compareDiagonals() {
        firstDiagonal = new String[10];
        secondDiagonal = new String[10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    firstDiagonal[i] = matrix[i][j];
                }
                if ((i + j + 1) == 10) {
                    secondDiagonal[i] = matrix[i][j];
                }
            }
        }

        System.out.println("Вот вам первая диагональ:");
        for (String i :
                firstDiagonal) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        System.out.println("Вот вам вторая диагональ:");
        for (String i :
                secondDiagonal) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        if (Arrays.equals(firstDiagonal, secondDiagonal)) {
            System.out.println("Они одинаковы! Идите за лотерейным билетом!");
        } else {
            System.out.println("Они, конечно же, отличаются.");
        }
    }

    public static void uniteDiagonals() {
        diagonals = new String[firstDiagonal.length + secondDiagonal.length];
        int counter = 0;
        for (int i = 0; i < firstDiagonal.length; i++) {
            diagonals[i] = firstDiagonal[i];
            counter++;
        }

        for (int i = 0; i < secondDiagonal.length; i++) {
            diagonals[counter++] = secondDiagonal[i];
        }

        System.out.println("Массив диагоналей: ");
        for (int i = 0; i < diagonals.length; i++) {
            System.out.print(" " + diagonals[i] + " ");
        }
        System.out.println();
    }
}
