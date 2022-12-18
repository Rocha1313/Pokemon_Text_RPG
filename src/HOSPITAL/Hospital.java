package HOSPITAL;

import GAME.PLAYER.Player;
import POKEMON.PokemonImp;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

    private ArrayList<PokemonImp> pokemonsToHeal = new ArrayList<>();
    private ArrayList<Integer> pokemonsIndex = new ArrayList<>();

    public Hospital(){}

    //Chose the pokemon to heal
    public void chosePokemonsToHeal(Player player){
        Scanner sc = new Scanner(System.in);
        int numberInput;
        String input;
        //Make The player chose the pokemons
        for (int i = 0; i < player.getAllPokemons().size(); i++){
            System.out.println();
            System.out.println((i+1) + ".");
            System.out.println();
            System.out.println(player.getAllPokemons().get(i).getName());
            System.out.println(player.getAllPokemons().get(i).getLevel());
            System.out.println(player.getAllPokemons().get(i).getHealth() + " - of - " + player.getAllPokemons().get(i).getMaxHealth());
            System.out.println(player.getAllPokemons().get(i).getDamage());
            System.out.println();
            System.out.println("============================================");
        }

        //Could set max 8 pokemons to heal
        while (pokemonsToHeal.size() != 8) {

            System.out.println();
            System.out.println("Chose a pokemon:");
            input = sc.next();

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input\n");
                continue;
            }

            if (checkIndex(numberInput)) {
                System.out.println("Pokemon is already on queue!\n");
                continue;
            }

            if (numberInput >= 1 && numberInput <= player.getAllPokemons().size()) {
                pokemonsIndex.add(numberInput);
                pokemonsToHeal.add(player.getAllPokemons().get(numberInput - 1));
            }

            if (quit(sc)){
                break;
            }
        }

        //Call method to heal pokemons selected
        healAll(pokemonsToHeal.size());
        pokemonsIndex.clear();
    }

    //No more pokemons to heal
    private boolean quit(Scanner sc){
        String input;
        while (true){
            System.out.println("Wanna add more pokemons to heal queue?\n");
            System.out.println("1 - YES");
            System.out.println("0 - NO");
            input = sc.next();
            switch (input){
                case "1" -> {
                    return false;
                }
                case "0" -> {
                    return true;
                }
                default -> {}
            }
        }


    }

    //Check if pokemon is on array to heal already
    private boolean checkIndex(int numberInput){
        for(int index : pokemonsIndex) {
            if (index == numberInput) {
                return true;
            }
        }
        return false;
    }

    private int healAll(int pokemonsQuantity){
        //Heal all Pokemon
        if ((pokemonsQuantity-1) >= 0){
            //Pokemon health is now 100%
            pokemonsToHeal.get(pokemonsQuantity - 1).heal();
            return healAll(pokemonsQuantity - 1);
        }

        pokemonsToHeal.clear();
        return 0;
    }
}
