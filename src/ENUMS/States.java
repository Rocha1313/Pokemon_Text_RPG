package ENUMS;

public enum States {
    NORMAL("NORMAL", 0),
    FIRE("BURNING", 6),
    ELECTRIC("STUNNED", 0),
    PSYCHIC("DIZZY", 0),
    WATER("DROWNING", 2),
    FIGHTING("BLEEDING", 6),
    POISON("POISONED",3);

    private final String state;
    private final int damage;
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
