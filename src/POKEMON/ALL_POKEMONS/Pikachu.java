package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.*;

public class Pikachu extends PokemonImp {

    public Pikachu(){
        super.setMaxHealth(Pokedex.PIKACHU.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.PIKACHU.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.PIKACHU.getType());
        super.setHealth(Pokedex.PIKACHU.getHealth());
        super.setState(States.NORMAL);
        super.setNaturalTypeState(States.ELECTRIC);
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.PIKACHU.getRarity());
        super.setDamage(Pokedex.PIKACHU.getDamage());
    }

    //ENEL lightning
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Stun the enemy pokemon
        if (enemyPokemon.getNaturalTypeState() != this.getState()) {
            enemyPokemon.setState(this.getNaturalTypeState());
            enemyPokemon.setStateCoolDown(2);
        }

        //Pikachu damage plus 40% enemy pokemon damage
        int damage = this.getDamage() + ((int) (enemyPokemon.getDamage() * 0.4));

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }


}
