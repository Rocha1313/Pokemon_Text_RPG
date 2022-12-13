package ENUMS;

import java.lang.reflect.Type;

public enum Pokedex {
    PIKACHU(4, "PIKACHU", Types.ELECTRIC.getType() ,  15, 45),
    CHARMANDER(2, "CHARMANDER", Types.FIRE.getType(), 12, 50),
    EKANS(1, "EKANS", Types.POISON.getType(), 8, 35);

    private int rarity;
    private String name;
    private String type;
    private int damage;
    private int health;
    Pokedex(int rarity, String name, String type, int damage, int health) {
        this.rarity = rarity;
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.health = health;
    }

    //Getter's
    public int getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
