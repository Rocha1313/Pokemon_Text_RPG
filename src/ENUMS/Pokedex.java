package ENUMS;

public enum Pokedex {
    PIKACHU(1, 4, "PIKACHU", Types.ELECTRIC ,  15, 45),
    CHARMANDER(2, 5, "CHARMANDER", Types.FIRE, 12, 50),
    EKANS(3, 6, "EKANS", Types.POISON, 8, 35),
    MEW(4, 1, "MEW", Types.PSYCHIC, 30, 200),
    SQUIRTLE(5, 2, "SQUIRTLE", Types.WATER, 15, 120),
    MACHOP(6, 3, "MACHOP", Types.FIGHTING, 35, 100);

    private final int pokemonNumber;
    private final int rarity;
    private final String name;
    private final Types type;
    private final int damage;
    private final int health;
    Pokedex(int pokemonNumber, int rarity, String name, Types type, int damage, int health) {
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

    public Types getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
