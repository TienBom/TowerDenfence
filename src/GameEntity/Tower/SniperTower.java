package GameEntity.Tower;

public class SniperTower extends Tower implements TowerProperty {
    public SniperTower(int range, int attackRate) {
        super(range, attackRate);
    }
    public SniperTower(){
        super(SNIPER_TOWER_RANGE,SNIPER_TOWER_ATTACKRATE);
        this.x = 4 * 80;
        this.y = 2 * 80;
    }
}
