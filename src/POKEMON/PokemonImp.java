package POKEMON;

public abstract class PokemonImp implements Pokemon {
    private int maxHealth;
    private int nextLevel;
    private String name;
    private int level;
    private int XP;
    private String type;
    private String naturalTypeState;
    private int health;
    private String state;
    private int stateCoolDown;
    private int ultimateCoolDown;
    private int rarity;
    private int damage;

    //Constructor's
    public PokemonImp(){}

    //Method's

    //Verify if Pokemon is Alive
    public boolean isAlive(){
        return this.health > 0;
    }

    //Decrease life by attack
    public void getAttacked(int damage, PokemonImp enemyPokemon){

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= this.health) {
            damage = this.health;
        }

        //45% chance defend natural State of the other pokemon
        int defendOfEnemyState = (int) (Math.random() * 100) + 1;
        if (!(defendOfEnemyState <= 45)) {
            this.state = enemyPokemon.getNaturalTypeState();
        }

        this.health = damage;
    }

    //Defend part or all damage to Pokemon that attacked
    public void defend(int damage, PokemonImp enemyPokemon){

        //Verify if damage is bigger than health
        //and change the damage to same amount the health if true
        if (damage >= this.health) {
            damage = this.health;
        }

        //45% chance defend natural State of the other pokemon
        int defendOfEnemyState = (int) (Math.random() * 100) + 1;
        if (!(defendOfEnemyState <= 45)) {
            this.state = enemyPokemon.getNaturalTypeState();
        }

        //10% chance defend all damage
        int defendAllDamage = (int) (Math.random() * 10) + 1;
        if (defendAllDamage == 1) {
            return;
        }

        //30% chance defend part of damage
        int defendPartOfDamage = (int) (Math.random() * 100) + 1;
        if (defendPartOfDamage <= 30) {
            this.health -= damage / 2;
            return;
        }

        //Get all damage
        this.health = damage;
    }

    //Attack enemy Pokemon
    public int attack(){
        return (int) (Math.random() * 12) + this.damage;
    }

    //Check if ultimate is charged
    public boolean ultimateIsReady(){
        return this.ultimateCoolDown >= 100;
    }

    //Use ultimate
    public abstract void useUltimate(PokemonImp enemyPokemon);

    //Check if Pokemon can level up
    public boolean checkLevel(){

        //Check if pokemon level up
        if (this.XP >= this.nextLevel){
            this.level++;
            this.XP = this.XP - this.nextLevel;
            this.nextLevel *= 1.15;
            return true;
        }
        return false;
    }

    //Heal Pokemon
    public void heal(int amount){
        if (this.health + amount >= this.maxHealth){
            this.health = this.maxHealth;
            return;
        }

        this.health += amount;
    }


    //Getter's
    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getNextLevel(){
        return this.nextLevel;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public int getXP(){
        return this.XP;
    }

    public String getType(){
        return this.type;
    }

    public int getHealth(){
        return this.health;
    }

    public String getState(){
        return this.state;
    }

    public String getNaturalTypeState(){
        return this.naturalTypeState;
    }

    public int getStateCoolDown(){
        return this.stateCoolDown;
    }

    public int getUltimateCoolDown(){
        return this.ultimateCoolDown;
    }

    public int getRarity(){
        return this.rarity;
    }

    public int getDamage(){
        return this.damage;
    }


    //Setter's
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void setNextLevel(int nextLevel){
        this.nextLevel = nextLevel;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setXP(int XP){
        this.XP = XP;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setNaturalTypeState(String naturalTypeState){
        this.naturalTypeState = naturalTypeState;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setStateCoolDown(int stateCoolDown){
        this.stateCoolDown = stateCoolDown;
    }

    public void setUltimateCoolDown(int ultimateCoolDown){
        this.ultimateCoolDown = ultimateCoolDown;
    }

    public void setRarity(int rarity){
        this.rarity = rarity;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}