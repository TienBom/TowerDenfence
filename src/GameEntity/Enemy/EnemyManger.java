package GameEntity.Enemy;

import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class EnemyManger {
    public static ArrayList<Enemy> listEnemy;
    private static Player player;
    private static int counter = 0;
    private static GraphicsContext graphicsContext;

    private static void addEnemy(Enemy enemy) {
        listEnemy.add(enemy);
    }

    public static void init(Player _player, GraphicsContext _graphicsContext) {
        player = _player;
        graphicsContext = _graphicsContext;
        listEnemy = new ArrayList<>();
        EnemyManger.addEnemy(new NormalEnemy(player));
        EnemyManger.addEnemy(new NormalEnemy(player));
        EnemyManger.addEnemy(new NormalEnemy(player));
        EnemyManger.addEnemy(new TankerEnemy(player));
        EnemyManger.addEnemy(new TankerEnemy(player));
        EnemyManger.addEnemy(new SmallerEnemy(player));
        EnemyManger.addEnemy(new SmallerEnemy(player));
        EnemyManger.addEnemy(new BossEnemy(player));
        System.out.println(listEnemy.size());
    }

    public static void update() {
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) enemy.update();
            listEnemy.removeIf(Enemy::isDestroy);
        }
    }

    public static void render() {
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) {
                enemy.render(graphicsContext);
            }
        }

    }
}
