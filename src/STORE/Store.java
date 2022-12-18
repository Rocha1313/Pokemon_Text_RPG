package STORE;

import GET_RARITY.Odds;
import ITEMS.Item;
import ITEMS.POTIONS.HEAL.HealPotion;
import ITEMS.POTIONS.HEAL.HealPotionsTypes;
import ITEMS.RUNES.RUNE_TYPES.*;

import java.util.ArrayList;

public class Store {

    ArrayList<Item> catalog = new ArrayList<>();


    //Constructor's
    public Store(){
        catalog.add(new HealPotion("25% Heal Potion", 10, HealPotionsTypes.WISPY));
        catalog.add(new HealPotion("50% Heal Potion", 50, HealPotionsTypes.HALF));
        catalog.add(new HealPotion("100% Heal Potion", 100, HealPotionsTypes.FULL));

        int randomNumberOfItems = (int) (Math.random() * 3) + 1;
        generateItems(randomNumberOfItems);
    }

    //Methods
    public void NewCatalog(int playerMatches){
        if (playerMatches == 0){
            return;
        }

        if (playerMatches % 5 == 0){
            catalog.clear();
            catalog.add(new HealPotion("25% Heal Potion", 10, HealPotionsTypes.WISPY));
            catalog.add(new HealPotion("50% Heal Potion", 50, HealPotionsTypes.HALF));
            catalog.add(new HealPotion("100% Heal Potion", 100, HealPotionsTypes.FULL));
            int randomNumberOfItems = (int) (Math.random() * 3) + 1;
            generateItems(randomNumberOfItems);
        }
    }

    public Item buySomething(int itemIndex){
        Item item = catalog.get(itemIndex);
        catalog.remove(itemIndex);
        return item;
    }

    public int sellSomething(Item item){
        return (int) (item.getPrice() * 0.8);
    }

    //Show Items
    public void showItems(){
        System.out.println();
        for (int i = 0; i < catalog.size(); i++){
            System.out.println((i+1) + ". ");
            System.out.println(catalog.get(i).getName());
            System.out.println(catalog.get(i).getPrice());
            System.out.println();
        }
    }
    private int generateItems(int numberOfItems){
        if (numberOfItems == 0){
            return 0;
        }

        switch (numberOfItems) {
            case 1 -> {
                catalog.add(new RarityRune("Rarity Rune", 1000, Odds.getRarity()));
                return 0;
            }
            case 2 -> {
                catalog.add(new TypeRune("Type Rune", 1500, Odds.getType()));
                return generateItems(numberOfItems - 1);
            }
            default -> {
                catalog.add(new PokemonRune("Pokemon Rune", 2000, Odds.getPokemon()));
                return generateItems(numberOfItems - 1);
            }
        }

    }

    //Getter
    public ArrayList<Item> getCatalog() {
        return catalog;
    }
}
