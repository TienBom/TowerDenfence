package GameEntity.Enemy;

import Main.Player;
import javafx.scene.image.Image;

public class SmallerEnemy extends Enemy implements EnemyProperty {

    public SmallerEnemy(double health, double armor, double speed, int reward, Image gunImg, Player player) {
        super(health, armor, speed, reward, gunImg, player);
    }
    public SmallerEnemy(Player player){
        super(SMALLER_ENEMY_HEALTH,SMALLER_ENEMY_ARMOR,SMALLER_ENEMY_SPEED,SMALLER_ENEMY_REWARD,SMALLER_ENEMY_IMAGE,player);
        this.direction=Direction.UP;
        this.img= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        this.i=0;
        this.j=6;
        this.x=this.i*80+40;
        this.y=this.j*80;

    }
}
