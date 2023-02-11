package lesson5;

/**
 * Программа поочередно выполняет задания пятого урока, не требует участия пользователя.
 */
public class Runner {
    public static void main(String[] args) {
        Matrix.createMatrix();
        Matrix.compareDiagonals();
        Matrix.uniteDiagonals();
        Diagonals.execute();
    }
}
