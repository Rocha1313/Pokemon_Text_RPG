package ITEMS.RUNES.RUNE_TYPES;

import ENUMS.Types;
import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class TypeRune extends Rune {

    private final Types pokemonTypeRune;

    public TypeRune(String name, int price, Types pokemonTypeRune) {
        super(name, price, RuneTypes.TYPERUNE);
        this.pokemonTypeRune = pokemonTypeRune;
    }

    public PokemonImp use() {
        return Summon.PokemonByType(this.pokemonTypeRune);
    }

    public Types getPokemonTypeRune() {
        return this.pokemonTypeRune;
    }
}
