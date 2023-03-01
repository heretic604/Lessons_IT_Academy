package lesson10.shop;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Executor {

    private ArrayList<Order> orders;
    protected static ArrayList<Product> storageList;
    private String password;

    protected static void refreshStorageList() {

        File file = Path.of("resources", "lesson10", "products.txt").toFile();

        try {
            try (OutputStream outputStream = new FileOutputStream(file)) {

                for (Product product : storageList) {
                    String good = product.toString();
                    outputStream.write(good.getBytes(StandardCharsets.UTF_8));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void execute() {

        createStorageList();
        startMenu();

    }

    private void createStorageList() {

        storageList = new ArrayList<>();

        storageList.add(new Product("Ручка", new GregorianCalendar(2022, Calendar.JANUARY, 25)));
        storageList.add(new Product("Карандаш", new GregorianCalendar(2019, Calendar.FEBRUARY, 1)));
        storageList.add(new Product("Стерка", new GregorianCalendar(2019, Calendar.FEBRUARY, 19)));
        storageList.add(new Product("Линейка", new GregorianCalendar(2020, Calendar.SEPTEMBER, 23)));
        storageList.add(new Product("Циркуль", new GregorianCalendar(2018, Calendar.JULY, 26)));

        refreshStorageList();

    }

    private void startMenu() {

        Scanner scan = new Scanner(System.in);
        int action = 0;

        System.out.println("""
                Приветствуем в нашем магазине!
                Выберете действие:
                1.Посмотреть доступные товары
                2.Посмотреть заказы
                3.Сделать новый заказ
                4.Управление складом (для администратора)
                0.Уйти, но обещать вернуться""");

        try {
            action = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        switch (action) {
            case 1 -> checkStorage();
            case 2 -> showOrders();
            case 3 -> newOrder();
            case 4 -> checkPassword();
            default -> {
                System.out.println("Благодарим за посещение!");
                System.exit(0);
            }
        }
    }

    private void checkStorage() {

        Scanner scan = new Scanner(System.in);
        File file = Path.of("resources", "lesson10", "products.txt").toFile();

        try {
            try (InputStream inputStream = new FileInputStream(file)) {
                byte[] bytes = inputStream.readAllBytes();
                String list = new String(bytes);
                System.out.println(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Любая кнопка - вернуться");

        try {
            scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println();
        }

        startMenu();
    }

    private void showOrders() {

        Scanner scan = new Scanner(System.in);
        int action = 0;

        Path path = Path.of("resources", "lesson10", "orders.txt");

        try {
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("""
                1.Редактировать заказ
                2.Удалить заказ
                0.Вернуться
                """);

        try {
            action = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        switch (action) {
            case 1 -> editOrder();
            case 2 -> deleteOrder();
            default -> startMenu();
        }
    }

    private void editOrder() {

        Scanner scan = new Scanner(System.in);
        String action = "";

        System.out.println("""
                Скопируйте id заказа из предыдущего меню, чтобы изменить заказ
                0.Вернуться
                """);

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        for (Order o : orders) {
            if (o.getId().toString().equals(action)) {
                o.orderMenu();
                break;
            }
        }

        refreshOrderList();
        startMenu();
    }

    private void deleteOrder() {

        Scanner scan = new Scanner(System.in);
        String action = "";

        System.out.println("""
                Скопируйте id заказа из предыдущего меню, чтобы удалить заказ
                0.Вернуться
                """);

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        for (Order o : orders) {
            if (o.getId().toString().equals(action)) {
                storageList.addAll(o.getGoods());
                refreshStorageList();
                orders.remove(o);
                break;
            }
        }

        refreshOrderList();
        startMenu();
    }

    private void refreshOrderList() {

        Path path = Path.of("resources", "lesson10", "orders.txt");
        String list = "";

        for (Order order : orders) {
            list = list.concat(order.toString()).concat(System.lineSeparator());
        }

        try {
            Files.write(path, List.of(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newOrder() {

        Order order = new Order();

        order.orderMenu();
        orders.add(order);
        System.out.println("Благодарим за заказ");
        startMenu();

    }

    private void checkPassword() {

        Scanner scan = new Scanner(System.in);
        String action = "";

        System.out.println("Введите пароль (указан в описании)");

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверный пароль");
        }

        if (action.equals(password)) {
            adminMenu();
        } else {
            System.out.println("Неверный пароль");
            startMenu();
        }
    }

    private void adminMenu() {

        Scanner scan = new Scanner(System.in);
        int action = 0;

        System.out.println("Товар на складе:");
        Path path = Path.of("resources", "lesson10", "products.txt");

        try {
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("""
                1.Оприходовать товар
                2.Списать товар
                3.Изменить пароль
                0.Выйти
                """);

        try {
            action = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        switch (action) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> changePassword();
            default -> startMenu();
        }

    }

    private void addProduct() {

        Scanner scan = new Scanner(System.in);
        String name = "";
        int day = 1;
        int month = 1;
        int year = 1970;

        System.out.println("Введите наименование товара");

        try {
            name = scan.nextLine();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        System.out.println("""
                Введите дату производства:
                Год (гггг) -> Enter
                Месяц (м/мм) -> Enter
                Число (ч/чч) -> Enter
                """);
        try {
            year = scan.nextInt();
            month = scan.nextInt();
            day = scan.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        Product product = new Product(name, new GregorianCalendar(year, (month - 1), day));
        storageList.add(product);

        Path path = Path.of("resources", "lesson10", "products.txt");

        try {
            Files.writeString(path, product.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Товар добавлен");
        adminMenu();
    }

    private void removeProduct() {

        Scanner scan = new Scanner(System.in);
        String action = "";

        System.out.println("""
                Скопируйте id товара из предыдущего меню, чтобы списать товар со склада
                0.Вернуться""");

        try {
            action = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Неверное действие");
        }

        Iterator<Product> it = storageList.iterator();

        while (it.hasNext()) {
            Product p = it.next();
            if (p.getId().toString().equals(action)) {
                it.remove();
                refreshStorageList();
                System.out.println("Товар списан");
                break;
            }
        }

        adminMenu();
    }

    private void changePassword() {

        Scanner scan = new Scanner(System.in);
        String newPassword = "123";

        System.out.println("Введите новый пароль");

        try {
            newPassword = scan.nextLine();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        password = newPassword;
        System.out.println("Пароль изменен");
        adminMenu();
    }

    public Executor() {
        this.orders = new ArrayList<>();
        this.password = "123";
    }

}
