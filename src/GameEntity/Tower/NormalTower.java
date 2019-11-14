package GameEntity.Tower;

import javafx.scene.image.Image;

public class NormalTower extends Tower implements TowerProperty{
    public NormalTower() {

    }
    public NormalTower(double x,double y){
       this.range=NORMAL_TOWER_RANGE;
       this.attackRate=NORMAL_TOWER_ATTACKRATE;
       this.x = x;
       this.y = y;
       this.lastAttacked=0;
       this.image=new Image("file:src/resources/AssetsKit_2/PNG/normal-tower.png");

    }
}
