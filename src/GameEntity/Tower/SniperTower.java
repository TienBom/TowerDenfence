package GameEntity.Tower;

import javafx.scene.image.Image;

public class SniperTower extends Tower implements TowerProperty {
    public SniperTower() {

    }
    public SniperTower(double x,double y){
        this.range=SNIPER_TOWER_RANGE;
        this.attackRate=SNIPER_TOWER_ATTACKRATE;
        this.x = x;
        this.y = y;
        this.lastAttacked=0;
        this.image=new Image("file:src/resources/AssetsKit_2/PNG/sniper_tower.png");
    }
}
