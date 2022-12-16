package GET_RARITY;

import ENUMS.Pokedex;
import ENUMS.Types;

public class Odds {

    public static int getRarity(){
        int random = (int) (Math.random() * 100) + 1;

        //1% chance
        if (random == 100){
            return 1;
        }
        //5% chance
        if (random >= 94 && random <= 99){
            return 2;
        }
        //10% chance
        if (random >= 83 && random <= 93){
            return 3;
        }
        //20% chance
        if (random >= 62 && random <= 82){
            return 4;
        }
        //27% chance
        if (random >= 34 && random <= 61){
            return 5;
        }

        //37% chance
        return 6;
    }

    public static Types getType(){
        int random = (int) (Math.random() * 6) + 1;
        return switch (random) {
            case 1 -> Types.PSYCHIC;
            case 2 -> Types.WATER;
            case 3 -> Types.FIGHTING;
            case 4 -> Types.ELECTRIC;
            case 5 -> Types.FIRE;
            default -> Types.POISON;
        };
    }

    public static Pokedex getPokemon(){
        int random = (int) (Math.random() * 6) + 1;
        return switch (random) {
            case 1 -> Pokedex.MEW;
            case 2 -> Pokedex.SQUIRTLE;
            case 3 -> Pokedex.MACHOP;
            case 4 -> Pokedex.PIKACHU;
            case 5 -> Pokedex.CHARMANDER;
            default -> Pokedex.EKANS;
        };
    }

}
