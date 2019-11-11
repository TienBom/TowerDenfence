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
        listEnemy.add(new NormalEnemy(player));
    }

    public static void update() {
       counter++;
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) {
                enemy.update();
            }
            listEnemy.removeIf(Enemy::isDestroy);
        }
        if(counter%100==0)
          listEnemy.add(new NormalEnemy(player));
    }

    public static void render() {
        if (!listEnemy.isEmpty()) {
            for (Enemy enemy : listEnemy) {
                enemy.render(graphicsContext);
                System.out.println(listEnemy.size());
            }
        }
    }
}
