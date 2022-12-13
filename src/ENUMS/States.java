package ENUMS;

public enum States {
    NORMAL("NORMAL"),
    FIRE("BURNING"),
    ELECTRIC("ENERGIZED"),
    POISON("POISONED");

    private String state;
    States(String state) {
        this.state = state;
    }

    //Getter
    public String getState() {
        return state;
    }
}
