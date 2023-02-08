package lesson_6.entities.containers;

import lesson_6.values.Values;

import java.util.Scanner;

public abstract class Container {

    protected char size;
    protected String type;
    private double weight;
    private double volume;

    public Container chooseContainer(Container container) {

        Scanner scan = new Scanner(System.in);

        System.out.println("""
                \nChoose type of container:
                1. Cone
                2. Cube
                3. Cylinder
                """);

        switch (scan.nextInt()) {
            case 1:
                Cone cone = new Cone(container.size);
                container = cone.loadContainer(container);
                break;
            case 2:
                Cube cube = new Cube(container.size);
                container = cube.loadContainer(container);
                break;
            case 3:
                Cylinder cylinder = new Cylinder(container.size);
                container = cylinder.loadContainer(container);
                break;
        }

        container.weight = calculateContainerWeight(container.volume, calculateDensity());
        return container;
    }

    private int calculateDensity() {

        Values values = new Values();
        Scanner scan = new Scanner(System.in);

        System.out.printf("""
                Choose a liquid to load:
                1.Water. Density %s
                2.Oil. Density %s
                """, values.WATER_DENSITY, values.OIL_DENSITY);

        switch (scan.nextInt()) {
            case 1:
                return values.WATER_DENSITY;
            case 2:
                return values.OIL_DENSITY;
            default:
                return 0;
        }
    }

    protected abstract double calculateVolume(char size);

    private double calculateContainerWeight(double volume, int density) {
        return volume * density;
    }

    public char getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

}
