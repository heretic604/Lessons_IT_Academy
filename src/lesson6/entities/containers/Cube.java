package lesson6.entities.containers;

import lesson6.values.Values;

public class Cube extends Container {

    private int height;
    private int side;

    protected Container loadContainer(Container container) {

        container.setType("Cube");
        container.setVolume(calculateVolume(container.getSize()));

        return container;
    }

    protected double calculateVolume(char size) {

        Values values = new Values();

        switch (size) {
            case 'S':
                height = values.CUBE_HEIGHT_SMALL;
                side = values.CUBE_SIDE_SMALL;
            case 'L':
                height = values.CUBE_HEIGHT_LARGE;
                side = values.CUBE_SIDE_LARGE;
        }

        return Math.pow(side, 2) * height;
    }

    public Cube(char size) {
        this.size = size;
    }

}
