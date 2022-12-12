package POKEMON;

public interface Pokemon {

    void getAttacked(Pokemon enemyPokemon);
    void defend(Pokemon enemyPokemon);
    void attack(Pokemon enemyPokemon);
    void useUltimate(Pokemon enemyPokemon);

    String getName();
    int getLevel();
    int getXP();
    String getType();
    int getHealth();
    String getState();
    int getUltimateCoolDown();
    int getRarity();
    int getDamage();
}
