package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.PokemonImp;

public class Machop extends PokemonImp {

    public Machop(){
        super.setMaxHealth(Pokedex.MACHOP.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.MACHOP.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.MACHOP.getType());
        super.setHealth(Pokedex.MACHOP.getHealth());
        super.setState(States.NORMAL.getState());
        super.setNaturalTypeState(Types.FIGHTING.getNaturalTypeState());
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.MACHOP.getRarity());
        super.setDamage(Pokedex.MACHOP.getDamage());
    }

    //GOMO GOMO NO RED ROCK
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Cut the enemy pokemon
        enemyPokemon.setState(this.getNaturalTypeState());

        //Machop hit's the enemy multi times with half the damage
        int damage = (this.getDamage() / 2) * (int) (Math.random() * 6) + 5;

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }
}
