package GameEntity.Enemy;

import Main.Player;
import javafx.scene.image.Image;

public class TankerEnemy extends Enemy implements EnemyProperty {
    public TankerEnemy(double health, double armor, double speed, int reward, Image gunImg, Player player) {
        super(health, armor, speed, reward, gunImg, player);
    }
    public TankerEnemy(Player player){
        super(TANKER_ENEMY_HEALTH,TANKER_ENEMY_ARMOR,TANKER_ENEMY_SPEED,TANKER_ENEMY_REWARD,TANKER_ENEMY_IMAGE,player);
        this.direction=Direction.UP;
        this.img= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        this.i=0;
        this.j=6;
        this.x=this.i*80+40;
        this.y=this.j*80;

    }
}
