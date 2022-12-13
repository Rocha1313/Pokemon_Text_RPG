package ENUMS;

public enum States {
    NORMAL("NORMAL", 0),
    FIRE("BURNING", 6),
    ELECTRIC("STUNNED", 0),
    POISON("POISONED",3);

    private String state;
    private int damage;
    States(String state, int damage) {
        this.state = state;
        this.damage = damage;
    }

    //Getter
    public String getState() {
        return state;
    }

    public int getDamage(){return damage;}
}
