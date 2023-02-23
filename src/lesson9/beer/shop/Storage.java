package lesson9.beer.shop;

import lesson9.exceptions.OutOfStorageException;

import java.util.Random;
import java.util.Scanner;

public class Storage {

    private int storage;
    private int order;

    protected void checkStorage() throws OutOfStorageException {
        if (order > storage) {
            throw new OutOfStorageException();
        }
    }

    public Storage() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        this.storage = random.nextInt(100);

        System.out.printf("""
                Сколько пива желаете? На складе осталось: %s
                """, storage);

        this.order = scanner.nextInt();

    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
