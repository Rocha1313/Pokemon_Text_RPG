package POKEMON;

public interface Pokemon {

    //Method's
    boolean isAlive();
    void getAttacked(int damage, PokemonImp enemyPokemon);
    void defend(int damage, PokemonImp enemyPokemon);
    int attack();
    boolean ultimateIsReady();
    void useUltimate(PokemonImp enemyPokemon);
    boolean checkLevel();
    void heal(int amount);

    //Getter's

    int getMaxHealth();
    int getNextLevel();
    String getName();
    int getLevel();
    int getXP();
    String getType();
    String getNaturalTypeState();
    int getHealth();
    String getState();
    int getStateCoolDown();
    int getUltimateCoolDown();
    int getRarity();
    int getDamage();

    //Setter's

    void setMaxHealth(int maxHealth);
    void setNextLevel(int nextLevel);
    void setName(String name);
    void setLevel(int level);
    void setXP(int XP);
    void setType(String type);
    void setNaturalTypeState(String naturalTypeState);
    void setHealth(int health);
    void setState(String State);
    void setStateCoolDown(int stateCoolDown);
    void setUltimateCoolDown(int ultimateCoolDown);
    void setRarity(int rarity);
    void setDamage(int damage);
}
