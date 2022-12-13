package POKEMON;

public interface Pokemon {

    //Method's
    boolean isAlive();
    void getAttacked(int damage, Pokemon enemyPokemon);
    void defend(int damage, Pokemon enemyPokemon);
    int attack();
    void useUltimate(Pokemon enemyPokemon);

    //Getter's

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
