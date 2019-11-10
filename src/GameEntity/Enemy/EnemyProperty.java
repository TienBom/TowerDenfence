package GameEntity.Enemy;

import javafx.scene.image.Image;

public interface EnemyProperty {
    double NORMAL_ENEMY_HEALTH = 45;
    double NORMAL_ENEMY_ARMOR= 10;
    double NORMAL_ENEMY_SPEED = 5;
    double NORMAL_ENEMY_WIDTH = 10;
    double NORMAL_ENEMY_HEIGHT = 10;
    int NORMAL_ENEMY_REWARD = 1;
    Image NORMAL_ENEMY_IMAGE= new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile291.png");

    double TANKER_ENEMY_HEALTH = 300;
    double TANKER_ENEMY_ARMOR= 15;
    double TANKER_ENEMY_SPEED = 2;
    double TANKER_ENEMY_WIDTH = 16;
    double TANKER_ENEMY_HEIGHT = 16;
    int TANKER_ENEMY_REWARD = 5;
    Image TANKER_ENEMY_IMAGE= new Image("file:src/resources/AssetsKit_2/PNG/tanker_enemy.png");

    double SMALLER_ENEMY_HEALTH = 25;
    double SMALLER_ENEMY_ARMOR= 6;
    double SMALLER_ENEMY_SPEED = 10;
    double SMALLER_ENEMY_WIDTH = 6;
    double SMALLER_ENEMY_HEIGHT = 6;
    int SMALLER_ENEMY_REWARD = 1;
    Image SMALLER_ENEMY_IMAGE=new Image("file:src/resources/AssetsKit_2/PNG/smaller_enemy.png");

    double BOSS_ENEMY_HEALTH = 2800;
    double BOSS_ENEMY_ARMOR= 25;
    double BOSS_ENEMY_SPEED = 2;
    double BOSS_ENEMY_WIDTH = 14;
    double BOSS_ENEMY_HEIGHT = 14;
    int BOSS_ENEMY_REWARD = 25;
    Image BOSS_ENEMY_IMAGE= new Image("file:src/resources/AssetsKit_2/PNG/boss_enemy.png");
}
