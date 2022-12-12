package ENUMS;

public enum Types {
    ELECTRIC("ELECTRIC"),
    FIRE("FIRE");

    private String type;
    Types(String type) {
        this.type = type;
    }

    //Getter
    public String getType() {
        return type;
    }
}
