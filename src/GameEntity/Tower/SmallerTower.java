package GameEntity.Tower;

import GameEntity.Enemy.SmallerEnemy;

public class SmallerTower extends Tower implements TowerProperty {
    public SmallerTower(int range, int attackRate) {
        super(range, attackRate);
    }
    public SmallerTower(){
        super(SMALLER_TOWER_RANGE,SMALLER_TOWER_ATTACKRATE);
        this.x = 4 * 80;
        this.y = 2 * 80;
    }
}
