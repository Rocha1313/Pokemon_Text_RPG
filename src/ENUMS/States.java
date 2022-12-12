package ENUMS;

public enum States {
    NORMAL("NORMAL"),
    BURNING("BURNING");

    private String state;
    States(String state) {
        this.state = state;
    }

    //Getter
    public String getState() {
        return state;
    }
}
