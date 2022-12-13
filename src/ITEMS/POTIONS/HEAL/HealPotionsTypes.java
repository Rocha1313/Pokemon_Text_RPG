package ITEMS.POTIONS.HEAL;

public enum HealPotionsTypes {

    FULL("FULL"),
    HALF("HALF"),
    WISPY("WISPY");

    private final String amount;

    HealPotionsTypes(String amount){
        this.amount = amount;
    }

    //Getter's
    public String getAmount() {
        return amount;
    }
}
