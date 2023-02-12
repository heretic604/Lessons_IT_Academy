package lesson7.entities;

public enum Body {

    SMALL_BODY("SB"),
    MEDIUM_BODY("MB"),
    BIG_BODY("BB");

    private final String NAME;

    Body(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }
}
