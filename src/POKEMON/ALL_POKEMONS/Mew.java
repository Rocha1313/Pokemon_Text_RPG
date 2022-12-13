package POKEMON.ALL_POKEMONS;

import ENUMS.*;
import POKEMON.PokemonImp;

public class Mew extends PokemonImp {

    public Mew(){
        super.setMaxHealth(Pokedex.MEW.getHealth());
        super.setNextLevel(100);
        super.setName(Pokedex.MEW.getName());
        super.setLevel(1);
        super.setXP(0);
        super.setType(Pokedex.MEW.getType());
        super.setHealth(Pokedex.MEW.getHealth());
        super.setState(States.NORMAL.getState());
        super.setNaturalTypeState(Types.PSYCHIC.getNaturalTypeState());
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.MEW.getRarity());
        super.setDamage(Pokedex.MEW.getDamage());
    }

    //SHANKS
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Stun the enemy pokemon
        enemyPokemon.setState(this.getNaturalTypeState());

        //Mew makes enemy attack him self   /// This attack is weak if is used on low level pokemons
        //Why?      Don't know, I just wanted it to be this way
        int damage = enemyPokemon.getDamage() * enemyPokemon.getLevel();

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }


}
