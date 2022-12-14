package ITEMS.RUNES.RUNE_TYPES;

import ENUMS.Pokedex;
import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class PokemonRune extends Rune {

    public PokemonRune(String name, int price) {
        super(name, price, RuneTypes.POKEMONRUNE);
    }

    public PokemonImp use(Pokedex pokemon) {
        return Summon.PokemonByName(pokemon);
    }
}
