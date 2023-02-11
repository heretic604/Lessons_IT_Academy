package lesson4;

import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int count;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Кот {" +
                "Имя: " + name +
                ", Возраст: " + age +
                '}';
    }

    // Метод, запускающий все циклы
    public void startAllCycles() {
        getDefault();
        startCycleFor();
        startCycleDoWhile();
        startCycleForEach();
        System.out.println("Котики закончились! Спасибо за внимание!");
    }

    //Первый цикл из пункта 4
    public void getDefault() {
        System.out.println("Цикл №1:");
        Cat cat = new Cat("Дефолтик", 0);
        while (count < 10) {
            System.out.println(cat);
            count++;
        }
    }

    //Метод, генерирующий случайный возраст
    public int getRandomAge() {
        Random random = new Random();
        int randomAge = random.nextInt(28) + 1;
        return randomAge;
    }

    //Метод, генерирующий случайное имя
    public String getRandomName() {
        Random random = new Random();
        char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        char[] randomName = new char[random.nextInt(3, 10)];
        for (int i = 0; i < randomName.length; i++) {
            randomName[i] = letters[random.nextInt(0, letters.length - 1)];
        }
        randomName[0] = Character.toUpperCase(randomName[0]);
        return String.valueOf(randomName);
    }

    //Второй цикл из пункта 5
    public void startCycleFor() {
        System.out.println("Цикл №2:");
        for (int i = 0; i < 10; i++) {
            setName(getRandomName());
            setAge(getRandomAge());
            Cat cat = new Cat(getName(), getAge());
            System.out.println(cat);
        }
    }

    //Третий цикл из пункта 6
    public void startCycleDoWhile() {
        System.out.println("Цикл №3:");
        do {
            Cat cat = new Cat(getRandomName(), getRandomAge());
            System.out.println(cat);
            count++;
        } while (count < 20);
    }

    //Четвертый цикл из пункта 7
    public void startCycleForEach() {
        System.out.println("Цикл №4:");
        Cat[] cats = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat(getRandomName(), getRandomAge());
        }
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}


