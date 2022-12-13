package ENUMS;

public enum Pokedex {
    PIKACHU(1, 4, "PIKACHU", Types.ELECTRIC.getType() ,  15, 45),
    CHARMANDER(2, 5, "CHARMANDER", Types.FIRE.getType(), 12, 50),
    EKANS(3, 6, "EKANS", Types.POISON.getType(), 8, 35),
    MEW(4, 1, "MEW", Types.PSYCHIC.getType(), 30, 200),
    SQUIRTLE(5, 2, "SQUIRTLE", Types.WATER.getType(), 15, 120),
    MACHOP(6, 3, "MACHOP", Types.FIGHTING.getType(), 35, 100);

    private final int pokemonNumber;
    private final int rarity;
    private final String name;
    private final String type;
    private final int damage;
    private final int health;
    Pokedex(int pokemonNumber, int rarity, String name, String type, int damage, int health) {
        this.pokemonNumber = pokemonNumber;
        this.rarity = rarity;
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.health = health;
    }

    //Getter's
    public int getPokemonNumber(){return pokemonNumber; }
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
