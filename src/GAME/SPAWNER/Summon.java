package GAME.SPAWNER;

import ENUMS.*;
import ITEMS.*;
import POKEMON.*;
import POKEMON.ALL_POKEMONS.*;

public class Summon {

    static PokemonImp Pokemon (){
        int randomRarity = (int) (Math.random() * 100) + 1;

        //37% chance
        int rarity = 6;

        //27% chance
        if (randomRarity >= 37 && randomRarity <= 63){
            rarity = 5;
        }

        //20% chance
        if (randomRarity >= 64 && randomRarity <= 83){
            rarity = 4;
        }

        //10% chance
        if (randomRarity >= 84 && randomRarity <= 95){
            rarity = 3;
        }

        //5% chance
        if (randomRarity >= 94 && randomRarity <= 99){
            rarity = 2;
        }

        //1% chance
        if (randomRarity == 100){
            rarity = 1;
        }

        switch (rarity) {
            case 1 -> new Mew();
            case 2 -> new Squirtle();
            case 3 -> new Machop();
            case 4 -> new Pikachu();
            case 5 -> new Charmander();
            case 6 -> new Ekans();
        };

        return new Ekans();
    }

    static PokemonImp pokemonByRarity (int rarity){
        return switch (rarity) {
            case 1 -> new Mew();
            case 2 -> new Squirtle();
            case 3 -> new Machop();
            case 4 -> new Pikachu();
            case 5 -> new Charmander();
            default -> new Ekans();
        };
    }

    static PokemonImp PokemonByType (Types type){
        return switch (type) {
            case PSYCHIC -> new Mew();
            case WATER -> new Squirtle();
            case FIGHTING -> new Machop();
            case ELECTRIC -> new Pikachu();
            case FIRE -> new Charmander();
            case POISON -> new Ekans();
        };
    }

    static PokemonImp PokemonByName (Pokedex pokemon){
        return switch (pokemon) {
            case MEW -> new Mew();
            case SQUIRTLE -> new Squirtle();
            case MACHOP -> new Machop();
            case PIKACHU -> new Pikachu();
            case CHARMANDER -> new Charmander();
            case EKANS -> new Ekans();
        };
    }

    static Item Item(){
        return null;
    }
}
