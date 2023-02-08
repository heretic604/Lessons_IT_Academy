package lesson_6.entities.containers;

public class DefContainer extends Container {

    protected double calculateVolume(char size) {
        return 0;
    }

    public DefContainer(char size) {
        this.size = size;
    }
}
