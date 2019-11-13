package Main;

public class Player {
    private double health;
    private Boolean lose;
    private int gold;

    public Player() {
        health=1000;
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}