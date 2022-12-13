package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.*;

public class Ekans extends PokemonImp {

    public Ekans(){
        super.setMaxHealth(Pokedex.EKANS.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.EKANS.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.EKANS.getType());
        super.setHealth(Pokedex.EKANS.getHealth());
        super.setState(States.NORMAL.getState());
        super.setNaturalTypeState(Types.POISON.getNaturalTypeState());
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.EKANS.getRarity());
        super.setDamage(Pokedex.EKANS.getDamage());
    }

    //Luffy Kiss
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Let them die slowly
        enemyPokemon.setState(this.getNaturalTypeState());

        //Ekans Just a big amount of damage related a poison damage
        int damage = States.POISON.getDamage() * (int) (Math.random() * 7) + 8;

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }
}
