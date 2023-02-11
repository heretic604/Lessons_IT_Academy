package lesson7.entities;

public class Robot implements Instruction<Head, Body> {

    private final String NAME;
    private final Head HEAD;
    private final Body BODY;

    public Robot(Head head, Body body) {
        this.NAME = generateName(head, body);
        this.HEAD = head;
        this.BODY = body;
    }

    @Override
    public String generateName(Head head, Body body) {
        return head.getNAME().concat("-").concat(body.getNAME());
    }

    @Override
    public String toString() {
        return "ROBOT: " + NAME + " {HEAD: " + HEAD + " BODY: " + BODY + "}";
    }
}
