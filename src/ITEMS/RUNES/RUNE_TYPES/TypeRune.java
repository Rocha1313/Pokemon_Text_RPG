package ITEMS.RUNES.RUNE_TYPES;

import ENUMS.Types;
import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class TypeRune extends Rune {

    public TypeRune(String name, int price) {
        super(name, price, RuneTypes.TYPERUNE);
    }

    public PokemonImp use(Types type) {
        return Summon.PokemonByType(type);
    }
}
