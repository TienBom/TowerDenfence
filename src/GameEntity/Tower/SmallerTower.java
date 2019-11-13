package GameEntity.Tower;

import GameEntity.Enemy.SmallerEnemy;

public class SmallerTower extends Tower implements TowerProperty {
    public SmallerTower() {;
    }
    public SmallerTower(int x,int y){
        this.range=SMALLER_TOWER_RANGE;
        this.attackRate=SMALLER_TOWER_ATTACKRATE;
        this.x =x;
        this.y =y;
        this.lastAttacked=0;
    }
}
