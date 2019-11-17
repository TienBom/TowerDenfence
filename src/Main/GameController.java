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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.util.Optional;

public class GameController extends AnimationTimer {
    public GraphicsContext graphicsContext;
    public Player player;
    public String towerType;
    public boolean chooseTower = false;
    public static boolean STOP = false;

    public void MouseHandling(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (chooseTower) {
            chooseTower = false;
            if (towerType.equals("NormalTower")) {
                if (player.getGold() >= Config.NORMAL_TOWER_COST) {
                    TowerManager.addTower(new NormalTower(x, y));
                    player.setGold(player.getGold() - Config.NORMAL_TOWER_COST);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Bạn không đủ tiền");
                    alert.show();
                }
            } else if (towerType.equals("SmallerTower")) {
                if (player.getGold() >= Config.SMALLER_TOWER_COST) {
                    TowerManager.addTower(new SmallerTower(x, y));
                    player.setGold(player.getGold() - Config.SMALLER_TOWER_COST);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Bạn không đủ tiền");
                    alert.show();
                }
            } else {
                if (player.getGold() >= Config.SNIPER_TOWER_COST) {
                    TowerManager.addTower(new SniperTower(x, y));
                    player.setGold(player.getGold() - Config.SNIPER_TOWER_COST);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Bạn không đủ tiền");
                    alert.show();
                }
            }
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
        player.setHealth(10);
        player.setGold(500);
        EnemyManger.init(player, graphicsContext);
        TowerManager.init(player, graphicsContext);
        BulletManager.init(player, graphicsContext);
    }

    @Override
    public void handle(long now) {
        if (player.getHealth() <= 0) {
            EnemyManger.counter = 0;
            this.restart();
            player.setHealth(10);
            player.setGold(500);
            Main.window.setScene(Main.sceneExit);
            Main.window.show();
            //this.stop();
            return;
        } else if (EnemyManger.winGame()) {
            this.restart();
            EnemyManger.counter = 0;
            player.setHealth(10);
            player.setGold(500);
            Main.window.setScene(Main.sceneWin);
            Main.window.show();
            //this.stop();
            return;
        } else {
            update();
            render();
            String health = "" + player.getHealth();
            String coin = "" + player.getGold();
            Main.label_health.setText(health);
            Main.label_coin.setText(coin);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    }

    public void update() {
        EnemyManger.update();
        TowerManager.update();
        BulletManager.update();
    }

    public void restart() {
        EnemyManger.listEnemy.clear();
        TowerManager.towerList.clear();
        BulletManager.bulletList.clear();
        player.setHealth(10);
        player.setGold(500);
    }

    public void restartGame() {
        restart();
        Main.window.setScene(Main.sceneStart);
        Main.window.show();
    }

}

