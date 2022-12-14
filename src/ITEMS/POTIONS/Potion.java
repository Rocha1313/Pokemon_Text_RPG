package ITEMS.POTIONS;

import GAME.PLAYER.*;
import ITEMS.*;
import POKEMON.*;

public abstract class Potion extends Item {

    public Potion(String name, int price) {
        super(name, price);
    }

    public void use(Player player){

        //effect(player.getPokemon);
    }

    public abstract void effect(PokemonImp pokemon);
}
