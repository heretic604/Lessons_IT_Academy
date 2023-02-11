package lesson7.entities;

public enum Head {

    SMALL_HEAD("SH"),
    MEDIUM_HEAD("MH"),
    BIG_HEAD("BH");

    private final String NAME;

    Head(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

}
