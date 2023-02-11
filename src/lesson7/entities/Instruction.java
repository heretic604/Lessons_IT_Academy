package lesson7.entities;

public interface Instruction<T, K> {

    String generateName(T t, K k);
}
