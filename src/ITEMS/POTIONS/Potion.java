package ITEMS.POTIONS;

import GAME.PLAYER.*;
import ITEMS.*;
import POKEMON.*;

public abstract class Potion extends Item {

    public Potion(String name, int price) {
        super(name, price);
    }

    public void use(Player player){

        //Effect(player.getPokemon);
    }

    public abstract void Effect(PokemonImp pokemon);
}
