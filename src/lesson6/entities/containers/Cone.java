package lesson6.entities.containers;

import lesson6.values.Values;

public class Cone extends Container {

    private int diameter;
    private int height;

    public Container loadContainer(Container container) {

        container.setType("Cone");
        container.setVolume(calculateVolume(container.getSize()));

        return container;
    }

    protected double calculateVolume(char size) {

        Values values = new Values();

        switch (size) {
            case 'S':
                diameter = values.CONE_DIAMETER_SMALL;
                height = values.CONE_HEIGHT_SMALL;
            case 'L':
                diameter = values.CONE_DIAMETER_LARGE;
                height = values.CONE_HEIGHT_LARGE;
        }

        return (1 / 3.0) * values.PI * Math.pow((diameter / 2.0), 2) * height;
    }

    public Cone(char size) {
        this.size = size;
    }

}
