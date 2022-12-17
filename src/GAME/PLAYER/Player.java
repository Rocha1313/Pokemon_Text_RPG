package GAME.PLAYER;

import GAME.INVENTORY.*;
import POKEMON.*;
import POKEMON.ALL_POKEMONS.Ekans;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private int level;
    private int XP;
    private int maxXP;
    private int cash;
    private int matchesPlayed;
    private ArrayList<PokemonImp> allPokemons = new ArrayList<>();
    private PokemonImp[] pokemonDeck = new PokemonImp[6];
    private ArrayList<InventorySpace> inventory = new ArrayList<>();

    //Constructor's
    public Player(String name){
        this.name = name;
        level = 1;
        XP = 0;
        maxXP = 100;
        cash = 100;
        matchesPlayed = 0;

        allPokemons.add(new Ekans());
        pokemonDeck[0] = allPokemons.get(0);
    }

    //Method's

    //Chose Pokemon to attack
    public PokemonImp chosePokemon(){
        Scanner sc = new Scanner(System.in);

        String input;
        int numberInput;
        int numberOfPokemons = numberOfPokemons();

        for (int i = 0; i < numberOfPokemons; i++){
            System.out.println();
            System.out.println((i+1) + ".");
            System.out.println();
            System.out.println(pokemonDeck[i].getName());
            System.out.println(pokemonDeck[i].getLevel());
            System.out.println(pokemonDeck[i].getHealth() + " - of - " + pokemonDeck[i].getMaxHealth());
            System.out.println(pokemonDeck[i].getDamage());
            System.out.println();
            System.out.println("============================================");
        }

        while (true){
            System.out.println();
            System.out.println("Chose a Pokemon to attack");
            input = sc.next();

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                continue;
            }

            if (numberInput >= 1 && numberInput <= numberOfPokemons){
                return pokemonDeck[numberInput - 1];
            }
        }
    }

    //Give how many pokemon is on deck
    public int numberOfPokemons(){
        int numberOfPokemons = 0;
        for (PokemonImp pokemonImp : pokemonDeck) {
            if (pokemonImp == null) {
                break;
            }
            numberOfPokemons++;
        }
        return numberOfPokemons;
    }

    //Check if any pokemon is alive
    public boolean checkDeckVitality() {

        for (PokemonImp pokemon : pokemonDeck){
            //Check if position on deck is null
            if (Objects.isNull(pokemon)){
                return false;
            }

            //Check if pokemon is alive
            if (pokemon.getHealth() > 0){
                return true;
            }
        }

        return false;
    }

    //Method may level up player
    public boolean checkLevel(){
        if (XP >= maxXP){
            level++;
            XP = XP - maxXP;
            maxXP *= 1.15;
            return true;
        }
        return false;
    }


    //Getter's
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXP() {
        return XP;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public int getCash() {
        return cash;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public ArrayList<PokemonImp> getAllPokemons() {
        return allPokemons;
    }

    public PokemonImp[] getPokemonDeck() {
        return pokemonDeck;
    }

    public ArrayList<InventorySpace> getInventory() {
        return inventory;
    }

    //Setter's
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setAllPokemons(ArrayList<PokemonImp> allPokemons) {
        this.allPokemons = allPokemons;
    }

    public void setPokemonDeck(PokemonImp[] pokemonDeck) {
        this.pokemonDeck = pokemonDeck;
    }

    public void setInventory(ArrayList<InventorySpace> inventory) {
        this.inventory = inventory;
    }
}
