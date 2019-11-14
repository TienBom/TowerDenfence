package GameEntity.Enemy;

import Main.Player;
import javafx.scene.image.Image;

public class BossEnemy extends Enemy implements EnemyProperty {

    public BossEnemy(double health, double armor, double speed, int reward, Player player) {
        super(health, armor, speed, reward, player);
    }
    public BossEnemy(Player player){
        super(BOSS_ENEMY_HEALTH,BOSS_ENEMY_ARMOR,BOSS_ENEMY_SPEED, (int) BOSS_ENEMY_REWARD,player);
        this.direction=Direction.UP;
        //this.img= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        this.i=0;
        this.j=6;
        this.x=0 * 80 + 40;
        this.y=6 * 80 + 00;
        this.image=BOSS_ENEMY_IMAGE;

    }
}
