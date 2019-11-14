package GameEntity.Enemy;

import Main.Player;
import javafx.scene.image.Image;

public class TankerEnemy extends Enemy implements EnemyProperty {
    public TankerEnemy(double health, double armor, double speed, int reward, Player player) {
        super(health, armor, speed, reward, player);
    }
    public TankerEnemy(Player player){
        super(TANKER_ENEMY_HEALTH,TANKER_ENEMY_ARMOR,TANKER_ENEMY_SPEED, (int) TANKER_ENEMY_REWARD,player);
        this.direction=Direction.UP;
        //this.img= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        this.i=0;
        this.j=6;
        this.x=0 * 80 + 40;
        this.y=6 * 80 + 00;
        this.image=TANKER_ENEMY_IMAGE;

    }
}
