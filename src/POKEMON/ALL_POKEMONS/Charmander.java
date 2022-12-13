package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.*;

public class Charmander extends PokemonImp {

    public Charmander(){
        super.setMaxHealth(Pokedex.CHARMANDER.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.CHARMANDER.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.CHARMANDER.getType());
        super.setHealth(Pokedex.CHARMANDER.getHealth());
        super.setState(States.NORMAL.getState());
        super.setNaturalTypeState(Types.FIRE.getNaturalTypeState());
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.CHARMANDER.getRarity());
        super.setDamage(Pokedex.CHARMANDER.getDamage());
    }

    @Override
    public void useUltimate(Pokemon enemyPokemon){

    }
}
