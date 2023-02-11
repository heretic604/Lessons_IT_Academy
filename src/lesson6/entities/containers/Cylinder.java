package lesson6.entities.containers;

import lesson6.values.Values;

public class Cylinder extends Container {

    private int height;
    private int diameter;

    public Container loadContainer(Container container) {

        container.setType("Cylinder");
        container.setVolume(calculateVolume(container.getSize()));

        return container;
    }

    protected double calculateVolume(char size) {

        Values values = new Values();

        switch (size) {
            case 'S':
                diameter = values.CYLINDER_DIAMETER_SMALL;
                height = values.CYLINDER_HEIGHT_SMALL;
            case 'L':
                diameter = values.CYLINDER_DIAMETER_LARGE;
                height = values.CYLINDER_HEIGHT_LARGE;
        }

        return values.PI * Math.pow((diameter / 2.0), 2) * height;
    }

    public Cylinder(char size) {
        this.size = size;
    }

}
