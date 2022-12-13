package POKEMON;

import ENUMS.*;

public class Pikachu extends PokemonImp{

    public Pikachu(){
        super.setName(Pokedex.PIKACHU.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.PIKACHU.getType());
        super.setHealth(Pokedex.PIKACHU.getHealth());
        super.setState(States.NORMAL.getState());
        super.setNaturalTypeState(Types.ELECTRIC.getNaturalTypeState());
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.PIKACHU.getRarity());
        super.setDamage(Pokedex.PIKACHU.getDamage());
    }

    @Override
    public void useUltimate(Pokemon enemyPokemon){

    }


}
