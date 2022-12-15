package ITEMS.RUNES.RUNE_TYPES;

import GAME.SPAWNER.Summon;
import ITEMS.RUNES.Rune;
import ITEMS.RUNES.RuneTypes;
import POKEMON.PokemonImp;

public class RarityRune extends Rune {

    private final int rarity;

    public RarityRune(String name, int price, int rarity) {
        super(name, price, RuneTypes.RARITYRUNE);
        this.rarity = rarity;
    }

    public PokemonImp use(){
        return Summon.pokemonByRarity(this.rarity);
    }

    public int getRarity() {
        return rarity;
    }
}