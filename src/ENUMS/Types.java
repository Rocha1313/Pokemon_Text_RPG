package ENUMS;

public enum Types {
    ELECTRIC("ELECTRIC", States.ELECTRIC.getState()),
    FIRE("FIRE", States.FIRE.getState()),
    PSYCHIC("PSYCHIC", States.PSYCHIC.getState()),
    WATER("WATER", States.WATER.getState()),
    FIGHTING("FIGHTING", States.FIGHTING.getState()),
    POISON("POISON", States.POISON.getState());


    private final String type;
    private final String naturalTypeState;
    Types(String type, String naturalTypeState) {
        this.type = type;
        this.naturalTypeState = naturalTypeState;
    }

    //Getter
    public String getType() {
        return this.type;
    }

    public String getNaturalTypeState(){
        return  this.naturalTypeState;
    }
}
