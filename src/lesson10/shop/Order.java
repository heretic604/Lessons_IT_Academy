package lesson10.shop;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static lesson10.shop.Executor.storageList;

public class Order {

    private final UUID id;
    private ArrayList<Product> goods;
    private final GregorianCalendar date;

    @Override
    public String toString() {
        return String.format("""
                Заказ:
                id: %s
                Дата заказа: %s
                Заказанные товары:
                %s""", id, date.getTime(), showGoods());
    }

    private String showGoods() {
        String result = "";
        for (Product p : goods) {
            result = result.concat(p.toString());
        }
        return result;
    }

    protected void orderMenu() {

        Scanner scan = new Scanner(System.in);
        int action = 0;

        System.out.println(this);
        System.out.println("""
                1.Добавить товар в заказ
                2.Удалить товар из заказа
                0.Завершить заказ
                """);

        try {
            action = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверная команда. Заказ завершен. Можете вернуться к нему из основного меню");
        }

        switch (action) {
            case 1 -> addProduct();
            case 2 -> deleteProduct();
            default -> closeOrder();
        }

    }

    private void deleteProduct() {

        Scanner scan = new Scanner(System.in);
        String action = "0";

        System.out.println(this);
        System.out.println("""
                Скопируйте id заказанного товара, чтобы удалить его из заказа
                0.Вернуться в меню заказа""");

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверная команда. Возвращаю в меню заказа");
        }

        Iterator<Product> iterator = goods.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId().toString().equals(action)) {
                iterator.remove();
                storageList.add(p);
                Executor.refreshStorageList();
                break;
            }
        }

        orderMenu();
    }

    private void addProduct() {

        Scanner scan = new Scanner(System.in);
        String action = "0";

        System.out.println("""
                Скопируйте id товара, который хотите добавить
                0.Вернуться в меню заказа
                """);

        File file = Path.of("resources", "lesson10", "products.txt").toFile();

        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String list = bufferedReader
                        .lines()
                        .collect(Collectors.joining(System.lineSeparator()));
                System.out.println(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверная команда. Возвращаю в меню заказа");
        }

        Iterator<Product> iterator = storageList.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId().toString().equals(action)) {
                iterator.remove();
                goods.add(p);
                Executor.refreshStorageList();
                break;
            }
        }

        orderMenu();
    }

    private void closeOrder() {

        File file = Path.of("resources", "lesson10", "orders.txt").toFile();

        try {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
                printWriter.write(this + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Order() {
        this.id = UUID.randomUUID();
        this.goods = new ArrayList<>();
        this.date = new GregorianCalendar();
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Product> getGoods() {
        return goods;
    }

}
