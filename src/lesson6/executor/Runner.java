package lesson6.executor;

import lesson6.entities.ports.Port;
import lesson6.entities.ships.Ship;
import lesson6.values.Values;

/**
 * Ваша задача загрузить корабли и отправить торговать.
 * Нужно вместить обший вес в определенное значение.
 * С короблями можно совершать различные действия, выбирая опции из контекстного меню.
 */

public class Runner {

    public static void main(String[] args) {

        Values values = new Values();
        Port port = new Port(values.MAX_PORT_CAPACITY);
        Ship[] fleet = port.createFleet();
        port.showFleet(fleet);

    }

}
