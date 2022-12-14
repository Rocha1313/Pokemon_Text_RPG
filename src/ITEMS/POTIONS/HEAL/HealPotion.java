package ITEMS.POTIONS.HEAL;

import ITEMS.POTIONS.Potion;
import POKEMON.*;

public class HealPotion extends Potion {
    private final HealPotionsTypes healAmount;

    //Constructor's
    public HealPotion(String name, int price, HealPotionsTypes healAmount) {
        super(name, price);
        this.healAmount = healAmount;
    }

    //Method's

    //Heal Pokemon
    public void effect(PokemonImp pokemon){
        int amountToHeal;

        if (healAmount == HealPotionsTypes.WISPY){
            amountToHeal = (int) (pokemon.getMaxHealth() * 0.25);
            pokemon.heal(amountToHeal);
            return;
        }

        if (healAmount == HealPotionsTypes.HALF){
            amountToHeal = (int) (pokemon.getMaxHealth() * 0.5);
            pokemon.heal(amountToHeal);
            return;
        }

        pokemon.heal(pokemon.getMaxHealth());
    };
}
