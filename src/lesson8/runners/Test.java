package lesson8.runners;

import lesson8.list.MyArrayList;

import java.util.ArrayList;

public class Test {

    public void test() {

        MyArrayList<Integer> integers = new MyArrayList<>(); // создание списка по умолчанию
        MyArrayList<String> strings = new MyArrayList<>(20); //создание с заданной capacity

        int x = 0;
        // заполняем список, превышая вместимость по умолчанию и выводим результат на экран
        while (integers.size() < 12) {
            integers.add(x++);
            System.out.println(integers); // лесенка
        }

        System.out.println(integers.size()); //Проверяем, правильно ли считается размер. 12/12 ✓

        //Проверяем на пустоту
        System.out.println(integers.isEmpty()); //false ✓
        System.out.println(strings.isEmpty());  //true ✓

        //Проверяем метод contains
        System.out.println(integers.contains(5)); //true ✓
        System.out.println(strings.contains("A")); //false ✓

        //indexOf в порядке
        System.out.println(integers.indexOf(11)); // 11 ✓
        System.out.println(strings.indexOf("V")); // -1 ✓

        //Пытаемся вставить число по индексу и проверяем размер
        System.out.println(integers.add(5, 555)); // true ✓
        System.out.println(integers); // ✓ спустя 555 часов
        System.out.println(integers.size()); // 13 ✓

        //Проверяем метод remove
        Integer y = 555;
        System.out.println(integers.remove(y)); //true ✓
        System.out.println(integers); // ✓ значение удалилось, остальные сдвинулись влево

        //метод addAll
        ArrayList<Integer> integersEnds = new ArrayList<>(); //коллекция для добавления
        integersEnds.add(12);
        integersEnds.add(13);
        integersEnds.add(14);
        System.out.println(integers.addAll(integersEnds)); // true ✓
        System.out.println(integers); // ✓ добавилось в конец
        System.out.println(integers.size()); // 15 ✓

        System.out.println(integers.get(5)); // 5 ✓

        //удаление по индексу
        System.out.println(integers.remove(5));// 5 ✓
        System.out.println(integers); // ✓
        System.out.println(integers.size()); // 14 ✓

        //метод set в порядке
        System.out.println(integers.set(2, 222)); // ✓ 222
        System.out.println(integers); // ✓

        //создания нового списка на основе существующего
        MyArrayList<Integer> newIntegers = new MyArrayList<>(integers);
        System.out.println(newIntegers); // такой же ✓
        System.out.println(newIntegers.size()); // такой же 14 ✓

    }
}
