package GAME.PLAYER;

import GAME.INVENTORY.*;
import POKEMON.*;
import POKEMON.ALL_POKEMONS.Ekans;

import java.util.ArrayList;

public class Player {
    private String name;
    private int level;
    private int XP;
    private int maxXP;
    private int cash;
    private int matchesPlayed;
    private ArrayList<Pokemon> allPokemons = new ArrayList<>();
    Pokemon[] pokemonDeck = new Pokemon[6];
    ArrayList<InventorySpace> inventory = new ArrayList<>();

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

    public ArrayList<Pokemon> getAllPokemons() {
        return allPokemons;
    }

    public Pokemon[] getPokemonDeck() {
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

    public void setAllPokemons(ArrayList<Pokemon> allPokemons) {
        this.allPokemons = allPokemons;
    }

    public void setPokemonDeck(Pokemon[] pokemonDeck) {
        this.pokemonDeck = pokemonDeck;
    }

    public void setInventory(ArrayList<InventorySpace> inventory) {
        this.inventory = inventory;
    }
}
