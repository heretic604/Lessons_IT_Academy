package lesson_6.entities.decks;

import lesson_6.entities.containers.Container;
import lesson_6.entities.containers.DefContainer;
import lesson_6.values.Values;

import java.util.Scanner;

public class Deck {

    private int capacity;
    private double weight;

    public Deck loadDeck(Deck deck) {

        Scanner scan = new Scanner(System.in);
        Values values = new Values();
        char selectedSize;
        Container[] containers;

        System.out.println("""
                \nChoose size of containers to load on this deck:
                1. Small (deck contains 4 containers of this type)
                2. Large (deck contains 2 containers of this type)
                """);

        switch (scan.nextInt()) {
            case 1:
                capacity = values.DECK_CAPACITY_FOR_SMALL;
                selectedSize = 'S';
                break;
            case 2:
                capacity = values.DECK_CAPACITY_FOR_LARGE;
                selectedSize = 'L';
                break;
            default:
                System.out.println(values.MESSAGE_ERROR);
                selectedSize = 'D';
        }

        containers = new Container[capacity];
        for (int i = 0; i < capacity; i++) {
            containers[i] = new DefContainer(selectedSize);
        }

        for (int i = 0; i < capacity; i++) {
            System.out.printf("Container #%s", i + 1);
            containers[i] = containers[i].chooseContainer(containers[i]);
            deck.weight += containers[i].getWeight();
        }

        return deck;
    }

    public Deck(int capacity, double weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
