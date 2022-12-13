package ITEMS.POTIONS.HEAL;

import ITEMS.POTIONS.Potion;
import POKEMON.*;

public class HealPotion extends Potion {
    private final String healAmount;

    //Constructor's
    public HealPotion(String name, int price, String healAmount) {
        super(name, price);
        this.healAmount = healAmount;
    }

    //Method's

    //Heal Pokemon
    public void Effect(PokemonImp pokemon){
        int amountToHeal;

        if (healAmount.equals(HealPotionsTypes.WISPY.getAmount())){
            amountToHeal = (int) (pokemon.getMaxHealth() * 0.25);
            pokemon.heal(amountToHeal);
            return;
        }

        if (healAmount.equals(HealPotionsTypes.HALF.getAmount())){
            amountToHeal = (int) (pokemon.getMaxHealth() * 0.5);
            pokemon.heal(amountToHeal);
            return;
        }

        pokemon.heal(pokemon.getMaxHealth());
    };
}
