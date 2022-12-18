package GAME.PLAYER;

import GAME.INVENTORY.*;
import ITEMS.Item;
import POKEMON.*;
import POKEMON.ALL_POKEMONS.Ekans;

import java.util.ArrayList;
import java.util.Arrays;
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

    //Chose Pokemons to deck
    public void setPokemonsDeck(){
        Scanner sc = new Scanner(System.in);
        String input;
        while(true){
            System.out.println();
            System.out.println("1 - Show Deck");
            System.out.println("2 - Show All Pokemons");
            System.out.println("3 - Remove Pokemon on Deck");
            System.out.println("4 - Set Pokemon on Deck");
            System.out.println("5 - Clean Deck");
            System.out.println();
            System.out.println("X - EXIT");
            System.out.println();

            System.out.println("Chose a option: ");
            input = sc.next();

            if (input.equals("x") || input.equals("X")){
                System.out.println();
                break;
            }

            switch (input){
                case "1" -> {
                    showPokemonDeck();
                }
                case "2" -> {
                    showAllPokemons();
                }
                case "3" -> {
                    removePokemonOnDeck();
                }
                case "4" -> {
                    setPokemonOnDeck();
                }
                case "5" -> {
                    cleanDeck();
                }
                default -> {}
            }

        }
    }

    //Remove Pokemon on deck
    private void removePokemonOnDeck(){
        Scanner sc = new Scanner(System.in);
        String input;
        int numberInput;

        while(true){

            System.out.println("What Pokemon do you want to remove of deck? (Ex:/ 2)");
            input = sc.next();

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("Not valid input!");
                continue;
            }

            if (!(numberInput >= 1) || !(numberInput <= pokemonDeck.length)){
                System.out.println("Not valid position!");
                continue;
            }

            pokemonDeck[numberInput - 1] = null;

            if (numberInput != pokemonDeck.length) {
                for (int i = 0; i < pokemonDeck.length; i++) {
                    if (i == pokemonDeck.length - 1) {
                        break;
                    }
                    if (Objects.isNull(pokemonDeck[i]) && !Objects.isNull(pokemonDeck[i + 1])){
                        pokemonDeck[i] = pokemonDeck[i+1];
                        pokemonDeck[i+1] = null;
                    }
                }
            }

            while (true) {
                System.out.println();
                System.out.println("Still want to set pokemon's on deck?");
                System.out.println();
                System.out.println("1 - YES");
                System.out.println("0 - NO");
                System.out.println();
                input = sc.next();
                if (input.equals("1") || input.equals("0")) {
                    break;
                }
            }

            if (input.equals("0")){
                break;
            }
        }
    }

    //Set Pokemon on Deck
    private void setPokemonOnDeck(){
        Scanner sc = new Scanner(System.in);
        String input;
        PokemonImp tempPokemon;

        while(true){
            tempPokemon = catchPokemon();
            verifyPositionOnDeck(tempPokemon);

            while (true) {
                System.out.println();
                System.out.println("Still want to set pokemon's on deck?");
                System.out.println();
                System.out.println("1 - YES");
                System.out.println("0 - NO");
                System.out.println();
                input = sc.next();
                if (input.equals("1") || input.equals("0")) {
                    break;
                }
            }

            if (input.equals("0")){
                break;
            }
        }
    }

    //Verify position on Deck
    private void verifyPositionOnDeck(PokemonImp pokemon){
        Scanner sc = new Scanner(System.in);
        String input;
        int numberInput;
        boolean existNull = false;
        boolean existOnDeck = false;

        while (true) {
            System.out.println();
            System.out.println("Chose a position on deck! (ex:/ 5 )");
            System.out.println();
            input = sc.next();

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("Not valid input!");
                continue;
            }

            if (!(numberInput >= 1) || !(numberInput <= pokemonDeck.length)) {
                System.out.println();
                System.out.println("Invalid Position!");
                continue;
            }

            //Verify if position is null and if it's the first position null
            //If not this will find the first position null and set there the pokemon
            if (Objects.isNull(pokemonDeck[numberInput - 1])){
                for (int i = numberInput - 1; i > 0; i--){
                    if ((i - 1) == 0){
                        pokemonDeck[0] = pokemon;
                        break;
                    }
                    if (Objects.isNull(pokemonDeck[i - 1])){
                        continue;
                    }
                    pokemonDeck[i] = pokemon;
                    break;
                }
                System.out.println("Pokemon is Set");
                return;
            }

            for (PokemonImp pokemonImp : pokemonDeck) {
                if (pokemonImp == pokemon) {
                    existOnDeck = true;
                    break;
                }
            }
            if (existOnDeck){
                System.out.println("Already on Deck");
                continue;
            }

            for (int i = 0; i < pokemonDeck.length ; i++){
                if (Objects.isNull(pokemonDeck[i])){
                    pokemonDeck[i] = pokemon;
                    System.out.println("Pokemon is Set");
                    return;
                }
            }

            pokemonDeck[numberInput - 1] = pokemon;
            System.out.println("Pokemon is Set");
            return;
        }
    }

    //Catch pokemon
    private PokemonImp catchPokemon(){
        Scanner sc = new Scanner(System.in);
        String input;
        int numberInput;

        while (true) {
            System.out.println();
            System.out.println("Chose a pokemon of all pokemons! (ex:/ 5 )");
            System.out.println();
            input = sc.next();

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("Not valid input!");
                continue;
            }

            if (!(numberInput >= 1) || !(numberInput <= allPokemons.size())) {
                System.out.println();
                System.out.println("Invalid Position!");
                continue;
            }

            return allPokemons.get(numberInput - 1);
        }
    }

    //Clean deck
    private void cleanDeck(){
        Arrays.fill(pokemonDeck, null);
    }

    //Search on inventory
    public void addItemOnInventory(Item item, int quantity){
        if (inventory.size() == 0){
            inventory.add(new InventorySpace(item, quantity));
            return;
        }

        for (InventorySpace i : inventory){
            if (i.getItem().getName().equals(item.getName())){
                i.addItemOnSpace(quantity);
                break;
            }
        }

        inventory.add(new InventorySpace(item, quantity));
    }

    //Show Items Inventory
    public void showInventory(){
        System.out.println();
        for (InventorySpace i : inventory){
            System.out.println(i.getItem().getName());
            System.out.println("Num of Items: "+ i.getQuantity());
            System.out.println();
        }
    }

    //Show all Pokemon's
    public void showAllPokemons(){
        System.out.println();
        for (int i = 0; i < allPokemons.size(); i++){
            System.out.println(i+". ");
            System.out.println(allPokemons.get(i).getName());
            System.out.println("Health: " + allPokemons.get(i).getHealth() + "/" + allPokemons.get(i).getMaxHealth());
            System.out.println("Damage: " + allPokemons.get(i).getDamage());
            System.out.println();
        }
    }

    //Show Pokemon Deck
    public void showPokemonDeck(){
        System.out.println();
        for (int i = 0; i < pokemonDeck.length; i++){
            if (Objects.isNull(pokemonDeck[i])){
                System.out.println();
                return;
            }
            System.out.println(i+". ");
            System.out.println(pokemonDeck[i].getName());
            System.out.println("Health: " + pokemonDeck[i].getHealth() + "/" + pokemonDeck[i].getMaxHealth());
            System.out.println("Damage: " + pokemonDeck[i].getDamage());
            System.out.println();
        }
    }

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
