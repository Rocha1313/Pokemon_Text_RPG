package ITEMS.RUNES;

public enum RuneTypes {

    RARITYRUNE("RARITY"),
    TYPERUNE("TYPE"),
    POKEMONRUNE("POKEMON");

    private final String type;

    RuneTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
