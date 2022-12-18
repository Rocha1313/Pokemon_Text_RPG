package POKEMON;

import ENUMS.States;
import ENUMS.Types;

public interface Pokemon {

    //Method's
    boolean isAlive();
    void checkState();
    void getAttacked(int damage, PokemonImp enemyPokemon);
    void defend(int damage, PokemonImp enemyPokemon);
    int attack();
    boolean ultimateIsReady();
    void useUltimate(PokemonImp enemyPokemon);
    boolean checkLevel();
    void heal(int amount);
    void heal();

    //Getter's

    int getMaxHealth();
    int getNextLevel();
    String getName();
    int getLevel();
    int getXP();
    Types getType();
    States getNaturalTypeState();
    int getHealth();
    States getState();
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
    void setType(Types type);
    void setNaturalTypeState(States naturalTypeState);
    void setHealth(int health);
    void setState(States State);
    void setStateCoolDown(int stateCoolDown);
    void setUltimateCoolDown(int ultimateCoolDown);
    void setRarity(int rarity);
    void setDamage(int damage);
}
