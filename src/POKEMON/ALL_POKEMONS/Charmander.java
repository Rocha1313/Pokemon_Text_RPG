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
        super.setState(States.NORMAL);
        super.setNaturalTypeState(States.FIRE);
        super.setStateCoolDown(0);
        super.setUltimateCoolDown(0);
        super.setRarity(Pokedex.CHARMANDER.getRarity());
        super.setDamage(Pokedex.CHARMANDER.getDamage());
    }

    //Ace Fists of Fire
    @Override
    public void useUltimate(PokemonImp enemyPokemon){
        //Make it Burn
        if (enemyPokemon.getNaturalTypeState() != this.getState()) {
            enemyPokemon.setState(this.getNaturalTypeState());
            enemyPokemon.setStateCoolDown(4);
        }
        //Charmander damage plus 300% Fire Damage plus 25% of level
        int damage = this.getDamage() + (States.FIRE.getDamage() * 3) + ((int)(getLevel() * 0.25));

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= enemyPokemon.getHealth()) {
            damage = enemyPokemon.getHealth();
        }

        //Deal the damage
        enemyPokemon.setHealth(enemyPokemon.getHealth() - damage);
    }
}
