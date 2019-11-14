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

    public void MouseHandling(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        if (chooseTower) {
            chooseTower = false;
            //int i = ((int) Math.ceil(x * 1.0 / Config.GRID_WIDTH))*Config.GRID_WIDTH;
            //int j = ((int) Math.ceil(y * 1.0 / Config.GRID_HEIGHT))*Config.GRID_HEIGHT;
            //System.out.println("i="+i);
            //System.out.println("j="+j);
            if (towerType.equals("NormalTower"))
                TowerManager.addTower(new NormalTower(x,y));
            else if (towerType.equals("SmallerTower"))
                TowerManager.addTower(new SmallerTower(x,y));
            else TowerManager.addTower(new SniperTower(x,y));
        }
    }

    public void chooseTower(ActionEvent event) {
        String id = ((Control) event.getSource()).getId();
        towerType = id;
        chooseTower = !chooseTower;
    }

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
        //System.out.println(towerType);
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

