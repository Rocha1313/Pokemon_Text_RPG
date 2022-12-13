package ENUMS;

public enum States {
    NORMAL("NORMAL"),
    FIRE("BURNING"),
    ELECTRIC("ENERGIZED");

    private String state;
    States(String state) {
        this.state = state;
    }

    //Getter
    public String getState() {
        return state;
    }
}
