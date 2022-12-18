package GAME;

import GAME.PLAYER.Player;
import GAME.POKEGYM.Pokegym;
import HOSPITAL.Hospital;
import ITEMS.Item;
import ITEMS.POTIONS.Potion;
import STORE.Store;

import java.util.Scanner;

public class Game {

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Hospital hospital = new Hospital();

        System.out.println("What's your first name?");
        Player player = new Player(sc.next());

        String input;

        while (true) {
            store.NewCatalog(player.getMatchesPlayed());


            System.out.println("0 - Player");
            System.out.println();
            System.out.println("1 - Store");
            System.out.println("2 - Battle");
            System.out.println("3 - PokeGym");
            System.out.println("4 - Hospital");
            System.out.println();
            System.out.println("X - EXIT");
            System.out.println();

            System.out.println("Chose a option: ");
            input = sc.next();

            if (input.equals("x") || input.equals("X")){
                System.out.println();
                System.out.println("bye bye :(");
                break;
            }

            switch (input){
                case "0" ->{
                    playerOptions(sc, player);
                }
                case "1" ->{
                    storeOptions(sc, player, store);
                }
                case "2" ->{
                    Battle battle = new Battle();
                    int difficulty = (int) (Math.random() * 5) + 1;
                    battle.startBattle(difficulty, player);
                }
                case "3" ->{
                    Pokegym pokegym = new Pokegym();
                    int difficulty = (int) (Math.random() * 5) + 1;
                    pokegym.startPokegym(player, difficulty);
                }
                case "4" ->{
                    hospital.chosePokemonsToHeal(player);
                }
                default -> {

                }
            }
        }
    }

    //Shop Options
    private static void storeOptions(Scanner sc, Player player, Store store){
        String input;
        int numberInput;
        while (true) {
            System.out.println();
            System.out.println("1 - Buy Something");
            System.out.println("2 - Show Items");
            System.out.println();
            System.out.println("X - Exit");
            System.out.println();

            System.out.println("Chose a option: ");
            input = sc.next();

            if (input.equals("x") || input.equals("X")) {
                System.out.println();
                break;
            }

            switch (input) {
                case "1" -> {
                    store.showItems();
                    while (true) {
                        System.out.println();
                        System.out.println("Chose something to buy! (Ex:/ 5)");
                        input = sc.next();

                        try {
                            numberInput = Integer.parseInt(input);
                        } catch (NumberFormatException nfe) {
                            System.out.println();
                            System.out.println("Not valid input!");
                            continue;
                        }

                        if (!(numberInput >= 1) || !(numberInput <= store.getCatalog().size())){
                            System.out.println();
                            System.out.println("Invalid Position!");
                            continue;
                        }

                        Item tempItem = store.buySomething(numberInput - 1);


                        if (player.getCash() < tempItem.getPrice()){
                            System.out.println();
                            System.out.println("No cash bro!");
                            return;
                        }

                        player.setCash(player.getCash() - tempItem.getPrice());
                        player.addItemOnInventory(tempItem, 1);

                        return;
                    }

                }
                case "2" -> {
                    store.showItems();
                    return;
                }
                default -> {

                }
            }
        }
    }

    //Player Options
    private static void playerOptions(Scanner sc, Player player){
        String input;
        while (true){
            System.out.println();
            System.out.println("1 - Show Player Status");
            System.out.println("2 - Show Inventory");
            System.out.println("3 - Show All Pokemons");
            System.out.println("4 - Show Pokemon Deck");
            System.out.println("5 - Set Pokemon Deck");
            System.out.println();
            System.out.println("X - Exit");
            System.out.println();

            System.out.println("Chose a option: ");
            input = sc.next();

            if (input.equals("x") || input.equals("X")){
                System.out.println();
                break;
            }

            switch (input){
                case "1" ->{
                    System.out.println();
                    System.out.println(player.getName());
                    System.out.println("Cash: "+player.getCash());
                    System.out.println("Level: "+ player.getLevel() + " | " + player.getXP() + "/" + player.getMaxXP() + " | " + (player.getLevel() + 1));
                    System.out.println("Matches played: " + player.getMatchesPlayed());
                    System.out.println();
                    return;
                }
                case "2" ->{
                    player.showInventory();
                    return;
                }
                case "3" ->{
                    player.showAllPokemons();
                    return;
                }
                case "4" ->{
                    player.showPokemonDeck();
                    return;
                }
                case "5" ->{
                    player.setPokemonsDeck();
                    return;
                }
                default -> {

                }
            }
        }
    }
}
