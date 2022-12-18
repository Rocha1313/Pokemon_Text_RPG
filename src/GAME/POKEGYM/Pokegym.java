package GAME.POKEGYM;

import GAME.Battle;
import GAME.PLAYER.Player;
import GAME.SPAWNER.Summon;
import ITEMS.Item;

public class Pokegym {
    private int rooms;
    private Item item;
    private int difficulty;

    public Pokegym(){}

    //Method's

    //Start Gym
    public boolean startPokegym(Player player, int difficulty){
        newGym(difficulty);
        while (rooms > 0){
            Battle battle = new Battle();
            if (battle.startBattle(this.difficulty, player)){
                rooms--;
                continue;
            }

            return false;
        }
        player.setCash(player.getCash() + (50 * difficulty));
        player.setXP(player.getXP() + (50 * difficulty));
        player.addItemOnInventory(this.item, 1);
        return true;
    }

    //New Gym
    private void newGym(int difficulty){
        this.difficulty = difficulty;
        this.rooms = (int) (Math.random() * 4) + 4;
        this.item = Summon.Item();
    }
}
