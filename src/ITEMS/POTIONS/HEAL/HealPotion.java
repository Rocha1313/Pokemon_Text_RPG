package ITEMS.POTIONS.HEAL;

import ITEMS.POTIONS.Potion;
import POKEMON.Pokemon;

public class HealPotion extends Potion {
    private int healAmount;

    //Constructor's
    public HealPotion(String name, int price) {
        super(name, price);
    }

    //Method's

    //Heal Pokemon
    public void Effect(Pokemon pokemon){
        pokemon.heal();
    };
}
