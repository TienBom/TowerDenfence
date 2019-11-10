package GameEntity.Bullet;

import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashSet;
import java.util.Set;

public class BulletManager {
    public static Set<Bullet> bulletList;
    public static GraphicsContext  graphicsContext;
    public static Player player;

    public static boolean init( Player _player,GraphicsContext _graphicsContext){
        player=_player;
        graphicsContext=_graphicsContext;
        bulletList = new HashSet<Bullet>();
        return true;
    }
    public static void deleteBullet(Bullet bullet){
        bulletList.remove(bullet);
    }
    public static void update(){
        if(!bulletList.isEmpty()){
            for(Bullet bullet: bulletList) bullet.update();
            bulletList.removeIf(Bullet::isDestroy);
        }
    }
    public static void reset(){
        bulletList.clear();
    }
    public static void render(){
        if(!bulletList.isEmpty())
            for(Bullet bullet:bulletList){
                bullet.render(graphicsContext);
                System.out.println("ok");
            }

    }
    public static void addBullet(Bullet bullet){
        bulletList.add(bullet);
    }
}
