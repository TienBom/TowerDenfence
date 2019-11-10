package Main;

import GameEntity.Bullet.BulletManager;
import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManger;
import GameEntity.Tower.Tower;
import GameEntity.Tower.TowerManager;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class GameController extends AnimationTimer {
    public GraphicsContext graphicsContext;
    public Player player;
    public GameController(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        player = new Player();
        player.setGold(500);
        EnemyManger.init(player,graphicsContext);
        TowerManager.init(player,graphicsContext);
        BulletManager.init(player,graphicsContext);
    }

    @Override
    public void handle(long now) {
        render();
        update();

    }

    public void start() {
        super.start();
    }

    public void render() {
        DrawMap.draw(graphicsContext);
        EnemyManger.render();
        TowerManager.render();
        BulletManager.render();
    }

    public void update() {
        EnemyManger.update();
        TowerManager.update();
        BulletManager.update();
    }
}

