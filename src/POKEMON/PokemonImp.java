package POKEMON;

public abstract class PokemonImp implements Pokemon{
    private String name;
    private int level;
    private int XP;
    private String type;
    private int health;
    private String state;
    private int ultimateCoolDown;
    private int rarity;
    private int damage;

    //Constructor's
    public PokemonImp(){

    }

    //Method's

    //Decrease life by attack
    public void getAttacked(Pokemon enemyPokemon){

    }

    //Defend part or all damage to Pokemon that attacked
    public void defend(Pokemon enemyPokemon){

    }

    //Attack enemy Pokemon
    public void attack(Pokemon enemyPokemon){

    }

    //Use ultimate
    public abstract void useUltimate(Pokemon enemyPokemon);

    //Getter's
    public String getName(){
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getXP() {
        return this.XP;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    public String getState() {
        return this.state;
    }

    public int getUltimateCoolDown() {
        return this.ultimateCoolDown;
    }

    public int getRarity() {
        return this.rarity;
    }

    public int getDamage() {
        return this.damage;
    }

    //Setter's
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUltimateCoolDown(int ultimateCoolDown) {
        this.ultimateCoolDown = ultimateCoolDown;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}