package lesson6.entities.ports;

import lesson6.values.Values;
import lesson6.entities.ships.Ship;

import java.util.Scanner;

public class Port {

    private int capacity;
    private int amountShips;
    private double totalWeight;
    public final Values VALUES = new Values();

    public Ship[] createFleet() {

        capacity = VALUES.MAX_PORT_CAPACITY;
        Ship[] fleet = new Ship[capacity];

        for (int i = 0; i < VALUES.MAX_PORT_CAPACITY; i++) {
            fleet[i] = VALUES.SHIP_DEFAULT;
        }

        amountShips = setAmountShips();

        for (int i = 0; i < amountShips; i++) {
            fleet[i] = fleet[i].createShip();
        }
        return fleet;
    }

    private int setAmountShips() {

        Scanner scan = new Scanner(System.in);
        int answer;

        do {
            System.out.printf("Choose amount of ships (1-%s)", VALUES.MAX_PORT_CAPACITY);
            answer = scan.nextInt();
        } while (answer < 1 || answer > 10);

        return answer;
    }

    public void showFleet(Ship[] fleet) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Look at your fleet:");
        totalWeight = 0;

        for (int i = 0; i < capacity; i++) {
            if (fleet[i] == VALUES.SHIP_DEFAULT) {
            } else {
                System.out.printf("Ship #%d %s amount of decks: %d weight: %dkg%n",
                        (i + 1), fleet[i].getName(), fleet[i].getSize(), (int) fleet[i].getWeight());
                totalWeight += fleet[i].getWeight();
            }
        }

        System.out.printf("Total weight of your loading is: %s kg", (int) totalWeight);
        System.out.printf("\nYour target is: minimum weight: %s kg; maximum weight: %s kg", VALUES.TARGET_MIN, VALUES.TARGET_MAX);
        System.out.println("\n1. Add new ship (max 10 ships)\n2. Remove ship\n3. Load ship\n4. Send ships to trade");

        switch (scan.nextInt()) {
            case 1:
                addShip(fleet);
                break;
            case 2:
                removeShip(fleet);
                break;
            case 3:
                chooseShipLoad(fleet);
                break;
            case 4:
                toTrade(fleet);
                break;
            default:
                System.out.println(VALUES.MESSAGE_ERROR);
                showFleet(fleet);
                break;
        }
    }

    private void addShip(Ship[] fleet) {

        for (int i = 0; i < VALUES.MAX_PORT_CAPACITY; i++) {
            if (fleet[i] == VALUES.SHIP_DEFAULT) {
                fleet[i] = fleet[i].createShip();
                break;
            }
        }

        amountShips++;
        showFleet(fleet);
    }

    private void removeShip(Ship[] fleet) {

        System.out.println("Enter the name of ship to remove:");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        boolean success = false;

        for (int i = 0; i < VALUES.MAX_PORT_CAPACITY; i++) {
            if (fleet[i].getName().equals(answer)) {
                fleet[i] = VALUES.SHIP_DEFAULT;
                success = true;
            }
        }

        if (!success) {
            System.out.println(VALUES.MESSAGE_ERROR);
            removeShip(fleet);
        } else {
            amountShips--;
            showFleet(fleet);
        }
    }

    private void chooseShipLoad(Ship[] fleet) {

        System.out.println("Enter the name of ship to loading:");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        boolean success = false;

        for (int i = 0; i < VALUES.MAX_PORT_CAPACITY; i++) {
            if (fleet[i].getName().equals(answer)) {
                fleet[i] = fleet[i].loadShip(fleet[i]);
                success = true;
            }
        }

        if (!success) {
            System.out.println(VALUES.MESSAGE_ERROR);
            chooseShipLoad(fleet);
        } else {
            showFleet(fleet);
        }
    }

    private void toTrade(Ship[] fleet) {

        if (totalWeight >= VALUES.TARGET_MIN && totalWeight <= VALUES.TARGET_MAX) {
            System.out.printf("""
                    %s ships with total weight %s kg were sent to trade!
                    YOU WIN!!!
                    """, amountShips, (int) totalWeight);
        } else if (totalWeight < VALUES.TARGET_MIN) {
            System.out.printf("""
                    Your weight %s kg is not enough. You need minimum %s kg
                                        
                    """, (int) totalWeight, VALUES.TARGET_MIN);
            showFleet(fleet);
        } else {
            System.out.printf("""
                    You are overweight. Your weight is %s kg. Maximum is %s kg
                                        
                    """, (int) totalWeight, VALUES.TARGET_MAX);
            showFleet(fleet);
        }
    }

    public Port(int capacity) {
        this.capacity = capacity;
    }

}
