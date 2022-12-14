package ITEMS.RUNES;

import ITEMS.Item;

public class Rune extends Item {

    private final RuneTypes runeType;

    public Rune(String name, int price, RuneTypes runeType) {
        super(name, price);
        this.runeType = runeType;
    }

    public RuneTypes getRuneType() {
        return runeType;
    }
}
