package lesson_6.entities.ships;

import lesson_6.entities.decks.Deck;
import lesson_6.values.Values;

import java.util.Random;
import java.util.Scanner;

public class Ship {

    private String name;
    private int size;
    private double weight;

    public Ship createShip() {
        return new Ship(generateName(), generateShipSize(), 0.0);
    }

    private String generateName() {

        String name;
        Random random = new Random();
        char[] letters = {'Q', 'W', 'E', 'R', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
                'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        char[] symbols = new char[2];

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = letters[random.nextInt(0, letters.length - 1)];
        }

        name = String.valueOf(symbols);
        name = name.concat("-");
        name = name.concat(String.valueOf(random.nextInt(0, 9)));
        name = name.concat(String.valueOf(random.nextInt(0, 9)));

        return name;
    }

    private int generateShipSize() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose size of ship:\n1. Single-Deck ship\n2. Double-deck ship");
        return scan.nextInt();
    }

    public Ship loadShip(Ship ship) {

        Values values = new Values();
        System.out.printf("Amount of decks to load: %s", size);
        Deck[] decks = new Deck[size];

        for (int i = 0; i < size; i++) {
            decks[i] = values.DECK_DEFAULT;
        }

        for (int i = 0; i < size; i++) {
            System.out.printf("\nLoading deck №%s", (i + 1));
            decks[i] = decks[i].loadDeck(decks[i]);
            weight += decks[i].getWeight();
        }

        return ship;
    }

    public Ship(String name, int size, double weight) {
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

}
