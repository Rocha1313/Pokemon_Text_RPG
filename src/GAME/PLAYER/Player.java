package GAME.PLAYER;

import GAME.INVENTORY.*;
import POKEMON.*;

import java.util.ArrayList;

public class Player {
    private String name;
    private int level;
    private int XP;
    private int cash;
    private int matchesPlayed;
    private ArrayList<Pokemon> allPokemons = new ArrayList<>();
    Pokemon[] pokemonDeck = new Pokemon[6];
    ArrayList<InventorySpace> inventory = new ArrayList<>();


}
