package Main;

public class Player {
    private int health;
    private Boolean lose;
    private int gold;

    public Player() {
        health=500;
        gold=1000;
    }

    public void update() {
        if (health <= 0) lose = true;
    }

    public void beAttacked() {
        this.health--;
    }

    public boolean isLose() {
        return this.lose;
    }

    public int getGold() {
        return gold;
    }

    public void earnMoney(int reward) {
        gold += reward;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}