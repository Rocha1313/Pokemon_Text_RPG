package ITEMS.RUNES.RUNE_TYPES;

import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class RarityRune extends Rune {

    public RarityRune(String name, int price) {
        super(name, price, RuneTypes.RARITYRUNE);
    }

    public PokemonImp use(int rarity){
        return Summon.pokemonByRarity(rarity);
    }
}