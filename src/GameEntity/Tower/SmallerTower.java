package GameEntity.Tower;

import GameEntity.Enemy.SmallerEnemy;
import javafx.scene.image.Image;

public class SmallerTower extends Tower implements TowerProperty {
    public SmallerTower() {;
    }
    public SmallerTower(double x,double y){
        this.range=SMALLER_TOWER_RANGE;
        this.attackRate=SMALLER_TOWER_ATTACKRATE;
        this.x =x;
        this.y =y;
        this.lastAttacked=0;
        this.image=new Image("file:src/resources/AssetsKit_2/PNG/smaller-tower.png");
    }
}
