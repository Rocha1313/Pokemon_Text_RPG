package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.PokemonImp;

public class Squirtle extends PokemonImp {

    public Squirtle(){
        super.setMaxHealth(Pokedex.SQUIRTLE.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.SQUIRTLE.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.SQUIRTLE.getType());
        super.setHealth(Pokedex.SQUIRTLE.getHealth());
        super.setState(States.NORMAL);
        super.setNaturalTypeState(States.WATER);
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.SQUIRTLE.getRarity());
        super.setDamage(Pokedex.SQUIRTLE.getDamage());
    }

    //STONE OCEAN
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Cut the enemy pokemon
        if (enemyPokemon.getNaturalTypeState() != this.getState()) {
            enemyPokemon.setState(States.FIGHTING);
            enemyPokemon.setStateCoolDown(3);
        }
        //Squirtle uses high pressure water jet
        int damage = this.getDamage() * (int) (Math.random() * 5) + 7;

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }


}
