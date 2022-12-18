package GAME;

import ENUMS.States;
import GAME.PLAYER.Player;
import GAME.SPAWNER.Summon;
import HOSPITAL.Hospital;
import POKEMON.PokemonImp;
import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Battle {

    private PokemonImp enemy;
    private int XPOnWin;

    //Constructor's
    public Battle(){}

    //Method's

    //Start new Match
    public boolean startBattle(int difficulty, Player player){
        newMatch(difficulty, player);
        int turn = 1;
        PokemonImp[] pokemonPlaying = whoWillStart(player);
        ArrayList<PokemonImp> pokemonsThatFought = new ArrayList<>();
        String enemyChoice = "";
        String playerChoice = "";
        PokemonImp pokemonOnBattle;

        while (player.checkDeckVitality()){
            // Print the turn of match
            System.out.println("Turn: "+ turn);
            System.out.println();
            // ----------------------------------------------------------------------------------------------------------

            // Check what is the player pokemon
            pokemonOnBattle = pokemonPlaying[0] == enemy ? pokemonPlaying[1] : pokemonPlaying[0];

            //Check if enemy is dead
            if (playerWin(player, pokemonOnBattle, pokemonsThatFought)){
                return true;
            }

            //Check if pokemon playing isn't stunned
            if (!isStunned(pokemonPlaying[0])){
                // Check if it's player pokemon or enemy pokemon
                if (pokemonPlaying[0] == pokemonOnBattle){
                    //Player playing
                    playerChoice = playerPlay(player, enemyChoice, pokemonOnBattle, pokemonPlaying);
                }else {
                    //Enemy playing
                    enemyChoice = botActions(pokemonPlaying[1], playerChoice);
                }

            }

            //Check if pokemon is alive
            if (!pokemonOnBattle.isAlive()){
                //Check if player lost
                if (checkGameOver(player, pokemonOnBattle, pokemonPlaying)){
                    break;
                }

                //Update the pokemon is attacking now
                if (pokemonPlaying[0] == enemy) {
                    pokemonOnBattle = pokemonPlaying[1];
                }else{
                    pokemonOnBattle = pokemonPlaying[0];
                }
            }

            //Check if enemy is dead
            if (playerWin(player, pokemonOnBattle, pokemonsThatFought)){
                return true;
            }

            //Check if pokemon playing isn't stunned
            if (!isStunned(pokemonPlaying[1])){
                // Check if it's player pokemon or enemy pokemon
                if (pokemonPlaying[1] == pokemonOnBattle){
                    //Player playing
                    playerChoice = playerPlay(player, enemyChoice, pokemonOnBattle, pokemonPlaying);
                }else {
                    //Enemy playing
                    enemyChoice = botActions(pokemonPlaying[0], playerChoice);
                }
            }

            //Check if pokemon is alive
            if (!pokemonOnBattle.isAlive()){
                //Check if player lost
                if (checkGameOver(player, pokemonOnBattle, pokemonPlaying)){
                    break;
                }

                //Update the pokemon is attacking now
                if (pokemonPlaying[0] == enemy) {
                    pokemonOnBattle = pokemonPlaying[1];
                }else{
                    pokemonOnBattle = pokemonPlaying[0];
                }
            }


            //Verify the state of pokemons
            pokemonPlaying[0].checkState();
            pokemonPlaying[1].checkState();

            //Next Turn
            turn++;
        }
        return false;
    }

    //Check if player lost
    private boolean checkGameOver(Player player, PokemonImp pokemonOnBattle, PokemonImp[] pokemonPlaying){
        //Check if Player still have pokemon's alive on deck
        if (player.checkDeckVitality()){
            if (pokemonPlaying[0] == pokemonOnBattle) {
                pokemonPlaying[0] = changePokemon(player, pokemonOnBattle);
            }else {
                pokemonPlaying[1] = changePokemon(player, pokemonOnBattle);
            }
        }else{
            System.out.println("Player Lost");
            return true;
        }
        return false;
    }

    //Change pokemon
    private PokemonImp changePokemon(Player player, PokemonImp pokemonOnBattle){
        PokemonImp tempPokemon;
        while (true) {
            tempPokemon = player.chosePokemon();

            if (tempPokemon.isAlive()){
                System.out.println("Pokemon is set");
                return tempPokemon;
            }
            System.out.println("This pokemon is dead!");
        }
    }

    //Check Option
    private String playerPlay(Player player, String enemyChoice, PokemonImp pokemonOnBattle, PokemonImp[] pokemonPlaying){
        String playerChoice;
        PokemonImp tempPokemon;
        while (true) {
            if (pokemonOnBattle == pokemonPlaying[0]) {
                playerChoice = playerActions(pokemonPlaying[0], enemyChoice);
            } else {
                playerChoice = playerActions(pokemonPlaying[1], enemyChoice);
            }

            if (!playerChoice.equals("0")) {
                break;
            }

            tempPokemon = player.chosePokemon();

            if (!tempPokemon.isAlive()){
                System.out.println("This pokemon is dead");
                continue;
            }

            if (tempPokemon == pokemonOnBattle){
                System.out.println("This Pokemon is already on fight!");
                System.out.println("Play Again");
            }else {
                if (pokemonOnBattle == pokemonPlaying[0]) {
                    pokemonPlaying[0] = tempPokemon;
                    System.out.println("Pokemon Set");
                    break;
                }
                pokemonPlaying[1] = tempPokemon;
                System.out.println("Pokemon Set");
                break;
            }
        }
        return playerChoice;
    }

    //Bot Actions
    private String botActions(PokemonImp playerPokemon, String playerChoice){
        int random;

        //Check if enemy ultimate is ready and add at possible options
        if (enemy.ultimateIsReady()) {
            //Bot has 80% chance of choose the ultimate option
            int chance = (int) (Math.random() * 100) + 1;
            if (chance <= 80){
                random = 3;
            } else {
                // 50/50 for attack of defend
                random = (int) (Math.random() * 2) + 1;
            }

        }else {
            // 50/50 for attack of defend
            random = (int) (Math.random() * 2) + 1;
        }

        switch (random){
            case 1 -> {
                if (playerChoice.equals("2")){
                    playerPokemon.defend(enemy.attack(), enemy);
                }
                playerPokemon.getAttacked(enemy.attack(), enemy);
                return "1";
            }
            case 2 -> {
                return "2";
            }
            default -> {
                enemy.useUltimate(playerPokemon);
                return "3";
            }
        }
    }

    //Player actions
    private String playerActions(PokemonImp pokemon, String enemyChoice){
        Scanner sc = new Scanner(System.in);
        String input;
        //Show pokemon art ----------------------------------------------------------------------------------------------
        //show options --------------------------------------------------------------------------------------------------
        while (true) {
            System.out.print("1 - Attack     2 - Defend     ");
            if (pokemon.ultimateIsReady()){
                System.out.println("3 - Ultimate      0 - Change Pokemon");
            }else {
                System.out.println("0 - Change Pokemon");
            }
            System.out.println();
            System.out.println("Chose a option:");
            input = sc.next();
            System.out.println();

            if (input.equals("1") || input.equals("2") || input.equals("0")){
                break;
            }

            if (pokemon.ultimateIsReady() && input.equals("3")){
                break;
            }
        }

        switch (input){
            case "1" -> {
                if (enemyChoice.equals("2")){
                    enemy.defend(pokemon.attack(), pokemon);
                }
                enemy.getAttacked(pokemon.attack(), pokemon);
                return "1";
            }
            case "2" -> {
                return "2";
            }
            case "3" -> {
                pokemon.useUltimate(enemy);
                return "3";
            }
            default -> {
                return "0";
            }
        }
    }

    //Verify if enemy is not stunned
    private boolean isStunned(PokemonImp pokemon){
        return pokemon.getState() == States.ELECTRIC;
    }

    //Check if enemy is dead
    private boolean playerWin(Player player, PokemonImp lastHitPokemon, ArrayList<PokemonImp> pokemonsThatFought){
        if (!enemy.isAlive()){
            xpDistributor(lastHitPokemon, pokemonsThatFought);
            player.setXP(player.getXP() + XPOnWin);
            if (player.checkLevel()){

                //Subiu de Nivel ----------------------------------------------------------------------------------------
                System.out.println("Level Up");

            }
            return true;
        }
        return false;
    }

    //Share between all pokemons the xp
    private void xpDistributor(PokemonImp lastHitPokemon, ArrayList<PokemonImp> pokemonsThatFought){
        lastHitPokemon.setXP(lastHitPokemon.getXP() + XPOnWin / 2);
        if(lastHitPokemon.checkLevel()){

            //Subiu de Nivel --------------------------------------------------------------------------------------------
            System.out.println("Level Up");

        }
        pokemonsThatFought.forEach(e -> {
            if (e != lastHitPokemon){
                e.setXP(e.getXP() + (XPOnWin / 2) / (pokemonsThatFought.size() - 1));
                if(e.checkLevel()){

                    //Subiu de Nivel ------------------------------------------------------------------------------------
                    System.out.println("Level Up");

                }
            }
        });
    }

    //Set the order of who will start first
    private PokemonImp[] whoWillStart(Player player){
        int whenEnemyPlay = (int) (Math.round(Math.random()));

        return whenEnemyPlay == 0? new PokemonImp[]{enemy, player.chosePokemon()} : new PokemonImp[]{player.chosePokemon(), enemy};
    }

    //Set new enemy
    private void newMatch(int difficulty, Player player){
        enemy = Summon.pokemonByRarity(difficulty);
        setLevel(getAverage(player));
        setXP();
        enemy.heal();
    }

    //Get average of Pokemon Level's
    private int getAverage(Player player){
        int sumOfLevels = 0;
        int numberOfPokemons = player.numberOfPokemons();

        for(int i = 0; i < numberOfPokemons; i++){
            sumOfLevels += player.getPokemonDeck()[i].getLevel();
        }

        return sumOfLevels / numberOfPokemons;
    }

    //Let Pokemon at same level
    private int setLevel(int level){
        if (level == 0){
            return 0;
        }
        enemy.checkLevel();
        return setLevel(level - 1);
    }

    //Set XP
    private void setXP(){
        //Percentage of maxXP of other pokemon that will give to other pokemon
        //That will give a number between 0.11 and 0.01
        double percentage = (Math.random() / 10) + 0.01;

        this.XPOnWin = (int) (this.enemy.getNextLevel() * percentage);
    }

    //Getter's
    public PokemonImp getEnemy() {
        return enemy;
    }

    public int getXPOnWin() {
        return XPOnWin;
    }

    //Setter's
    public void setEnemy(PokemonImp enemy) {
        this.enemy = enemy;
    }

    public void setXPOnWin(int XPOnWin) {
        this.XPOnWin = XPOnWin;
    }
}
