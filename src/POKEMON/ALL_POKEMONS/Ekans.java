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

    @Override
    public void useUltimate(Pokemon enemyPokemon){

    }
}
