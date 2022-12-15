package ITEMS.RUNES.RUNE_TYPES;

import ENUMS.Pokedex;
import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class PokemonRune extends Rune {

    private final Pokedex pokemonInside;

    public PokemonRune(String name, int price, Pokedex pokemonInside) {
        super(name, price, RuneTypes.POKEMONRUNE);
        this.pokemonInside = pokemonInside;
    }

    //Use Item and generate random pokemon
    public PokemonImp use() {
        return Summon.PokemonByName(pokemonInside);
    }

    public Pokedex getPokemonInside() {
        return pokemonInside;
    }
}
