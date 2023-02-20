package lesson8.list;

import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] objects;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(Object value) {

        for (int i = 0; i < size; i++) {

            if (value.equals(objects[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return (indexOf(value) >= 0);
    }

    @Override
    public boolean add(T value) {

        if (objects.length == size) {
            enlargeCapacity();
        }

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = value;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(int index, Object value) {

        if (objects.length == size) {
            enlargeCapacity();
        }

        for (int i = size; i >= index; i--) {
            objects[i + 1] = objects[i];
        }

        objects[index] = value;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object value) {

        for (int i = 0; i < objects.length; i++) {

            if (objects[i].equals(value)) {
                objects[i] = null;
                size--;

                //сдвигаем всё влево:
                for (int j = i; j <= size; j++) {
                    objects[j] = objects[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> value) {

        Object[] newObjects = value.toArray();

        while (objects.length <= size + newObjects.length) {
            enlargeCapacity();
        }

        for (int i = 0; i < newObjects.length; i++) { //копирую вручную для наглядности и понимания
            objects[size + i] = newObjects[i];        //не использую метод System.arraycopy()
        }

        size += newObjects.length;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) objects[index]; //кастует нормально :)
    }

    @Override
    public T remove(int index) {

        Object o = objects[index];              //сохранили
        objects[index] = null;                  //удалили

        for (int i = index; i <= size; i++) {   //сдвинули влево
            objects[i] = objects[i + 1];
        }

        size--;                                 //размер откорректировали
        return (T) o;                           //вернули
    }

    @Override
    public T set(int index, T value) {
        objects[index] = value;
        return value;
    }

    private void enlargeCapacity() {

        Object[] newObjects = new Object[(int) (objects.length * 1.5)];

        for (int i = 0; i < size; i++) {
            newObjects[i] = objects[i];
        }

        objects = newObjects;
    }

    @Override
    public String toString() {

        String string = "[";

        for (int i = 0; i < size - 1; i++) {
            string = string.concat(objects[i].toString());
            string = string.concat(", ");
        }

        return string.concat(objects[size - 1].toString() + "]");
    }

    public MyArrayList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.objects = new Object[capacity];
    }

    public MyArrayList(MyList<? extends T> col) {
        this.objects = new Object[col.size()];
        this.objects = col.getObjects();
        this.size = col.size();
    }

    public Object[] getObjects() {
        return objects;
    }

}
