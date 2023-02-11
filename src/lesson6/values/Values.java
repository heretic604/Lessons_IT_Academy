package lesson6.values;

import lesson6.entities.decks.Deck;
import lesson6.entities.ships.Ship;

public class Values {

    public final int WATER_DENSITY = 10;
    public final int OIL_DENSITY = 20;
    public final int CUBE_SIDE_SMALL = 10;
    public final int CUBE_SIDE_LARGE = 20;
    public final int CUBE_HEIGHT_SMALL = 10;
    public final int CUBE_HEIGHT_LARGE = 20;
    public final int CYLINDER_HEIGHT_SMALL = 10;
    public final int CYLINDER_HEIGHT_LARGE = 20;
    public final int CYLINDER_DIAMETER_SMALL = 10;
    public final int CYLINDER_DIAMETER_LARGE = 20;
    public final int CONE_HEIGHT_SMALL = 10;
    public final int CONE_HEIGHT_LARGE = 20;
    public final int CONE_DIAMETER_SMALL = 10;
    public final int CONE_DIAMETER_LARGE = 20;
    public final double PI = 3.142;
    public final int DECK_CAPACITY_FOR_SMALL = 4;
    public final int DECK_CAPACITY_FOR_LARGE = 2;
    public final int MAX_PORT_CAPACITY = 10;
    public final String MESSAGE_ERROR = "Incorrect input. Try again";
    public final Ship SHIP_DEFAULT = new Ship("empty", 0, 0.0);
    public final Deck DECK_DEFAULT = new Deck(0, 0.0);
    public final double TARGET_MIN = 500_000;
    public final double TARGET_MAX = 5_000_000;


}
