package GAME.INVENTORY;

import ITEMS.*;

public class InventorySpace {
    private Item item;
    private int quantity;

    //Constructor
    public InventorySpace(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    //Getter's
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    //Setter's
    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
