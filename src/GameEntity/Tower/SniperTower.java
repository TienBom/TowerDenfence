package GameEntity.Tower;

public class SniperTower extends Tower implements TowerProperty {
    public SniperTower() {

    }
    public SniperTower(int x,int y){
        this.range=SNIPER_TOWER_RANGE;
        this.attackRate=SNIPER_TOWER_ATTACKRATE;
        this.x = x;
        this.y = y;
        this.lastAttacked=0;
    }
}
