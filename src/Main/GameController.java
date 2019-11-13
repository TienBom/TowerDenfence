package Main;

import GameEntity.Bullet.Bullet;
import GameEntity.Bullet.BulletManager;
import GameEntity.Bullet.NormalBullet;
import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManger;
import GameEntity.Tower.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class GameController extends AnimationTimer {
    public GraphicsContext graphicsContext;
    public Player player;
    public String towerType;
    public boolean chooseTower = false;
    /*public void MouseHandling(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if (chooseTower) {
            chooseTower = false;
            int i = (int) Math.ceil(x * 1.0 / Config.GRID_WIDTH);
            int j = (int) Math.ceil(y * 1.0 / Config.GRID_HEIGHT);
            if (towerType.equals("NormalTower"))
                TowerManager.addTower(new NormalTower(i, j));
            else if (towerType.equals("SmallerTower"))
                TowerManager.addTower(new SmallerTower(i, j));
            else TowerManager.addTower(new SniperTower(i, j));
        }
    }

    public void chooseNormalTower(ActionEvent event) {

    }
    public void chooseSmallerTower(ActionEvent event){

    }
    public void chooseSniperTower(ActionEvent event){

    }*/

    public GameController(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        player = new Player();
        player.setGold(500);
        EnemyManger.init(player, graphicsContext);
        TowerManager.init(player, graphicsContext);
        BulletManager.init(player, graphicsContext);
    }

    @Override
    public void handle(long now) {
        update();
        render();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        render();
        super.start();
    }

    public void render() {

        DrawMap.draw(graphicsContext);
        TowerManager.render();
        EnemyManger.render();
        BulletManager.render();
        //TowerManager.render();
        // BulletManager.render();
    }

    public void update() {
        EnemyManger.update();
        TowerManager.update();
        BulletManager.update();
    }

}

