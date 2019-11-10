package GameEntity.Enemy;

import Main.Player;
import javafx.scene.image.Image;

public class NormalEnemy extends Enemy implements EnemyProperty {

    public NormalEnemy(double health, double armor, double speed, int reward,Player player) {
        super(health, armor, speed, reward,null,player);
    }
    public NormalEnemy(Player player){
        super(NORMAL_ENEMY_HEALTH,NORMAL_ENEMY_ARMOR,NORMAL_ENEMY_SPEED,NORMAL_ENEMY_REWARD, NORMAL_ENEMY_IMAGE,player);
        this.direction=Direction.UP;
        this.img= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        this.i=0;
        this.j=6;
        this.x=this.i*80+40;
        this.y=this.j*80;
    }
}
