package GameEntity.Enemy;

import javafx.scene.image.Image;

public interface EnemyProperty {
    static final double NORMAL_ENEMY_HEALTH = 200;
    static final double NORMAL_ENEMY_ARMOR= 10;
    static final int NORMAL_ENEMY_SPEED = 3;
    static final double NORMAL_ENEMY_WIDTH = 10;
    static final double NORMAL_ENEMY_HEIGHT = 10;
    static final int NORMAL_ENEMY_REWARD = 30;
    static final Image NORMAL_ENEMY_IMAGE=new Image("file:src/resources/AssetsKit_2/PNG/normal_enemy.png");

    static final double TANKER_ENEMY_HEALTH = 300;
    static final double TANKER_ENEMY_ARMOR= 15;
    static final int TANKER_ENEMY_SPEED = 4;
    static final double TANKER_ENEMY_WIDTH = 16;
    static final double TANKER_ENEMY_HEIGHT = 16;
    static final int TANKER_ENEMY_REWARD = 20;
    static final Image TANKER_ENEMY_IMAGE=new Image("file:src/resources/AssetsKit_2/PNG/tanker_enemy.png");

    static final double SMALLER_ENEMY_HEALTH = 100;
    static final double SMALLER_ENEMY_ARMOR= 6;
    static final int SMALLER_ENEMY_SPEED = 1;
    static final double SMALLER_ENEMY_WIDTH = 6;
    static final double SMALLER_ENEMY_HEIGHT = 6;
    static final int SMALLER_ENEMY_REWARD = 50;
    static final Image SMALLER_ENEMY_IMAGE=new Image("file:src/resources/AssetsKit_2/PNG/smaller_enemy.png");

    static final double BOSS_ENEMY_HEALTH = 500;
    static final double BOSS_ENEMY_ARMOR= 25;
    static final int BOSS_ENEMY_SPEED = 2;
    static final double BOSS_ENEMY_WIDTH = 14;
    static final double BOSS_ENEMY_HEIGHT = 14;
    static final int BOSS_ENEMY_REWARD = 70;
    static final Image BOSS_ENEMY_IMAGE=new Image("file:src/resources/AssetsKit_2/PNG/boss_enemy.png");
}
