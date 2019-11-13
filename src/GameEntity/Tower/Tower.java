package GameEntity.Tower;

import GameEntity.Bullet.*;
import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManger;
import GameEntity.GameObject;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tower extends GameObject {
    protected int range;
    protected Enemy target;

    protected int attackRate;//attackRate time giữa 2 lần bắn
    protected int lastAttacked;//time kể từ lần bắn trc
    private Player player;
    private boolean destroy = false;

    public Tower() {
    }

    public Enemy getTarget() {
        return target;
    }

    public int getRange() {
        return this.range;
    }

    public int getAttackRate() {
        return attackRate;
    }

    public void doDestroy() {
        destroy = true;
    }

    public void checkRange() {
        if (target != null) {
            if (target.isDestroy()) target = null;
            else {
                double distance = Math.sqrt(Math.sqrt(Math.pow(this.x - target.x, 2) + Math.pow(this.y - target.y, 2)));
                if (distance > range) target = null;
            }
        }
        if (target == null) {
            for (Enemy enemy : EnemyManger.listEnemy) {
                double distance = Math.sqrt(Math.sqrt(Math.pow(this.x - enemy.x, 2) + Math.pow(this.y - enemy.y, 2)));
                if (distance <= range) {
                    target = enemy;
                    break;
                }
            }
        }
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.PINK);
        gc.fillRect(x + 20, y + 20, 30, 30);
    }

    @Override
    public void update() {
        if (target != null) lastAttacked++;
        else lastAttacked = 0;
        checkRange();


        if (lastAttacked > attackRate && target != null) {
            lastAttacked = 0;
            if(this instanceof NormalTower){
                BulletManager.addBullet(new NormalBullet(this));
                System.out.println("OK");
            }
            else if(this instanceof SmallerTower){
                BulletManager.addBullet(new MachineGunBullet(this));
                BulletManager.render();
            }
            else{
                BulletManager.addBullet(new SniperBullet(this));
                BulletManager.render();
            }
            /*if (this instanceof NormalTower) {
                BulletManager.addBullet(new NormalBullet(this));
            }
            if (this instanceof SmallerTower) {
                BulletManager.addBullet(new MachineGunBullet(this));
            }
            if (this instanceof SniperTower) {
                BulletManager.addBullet(new SniperBullet(this));
            }*/
        }
    }
}
