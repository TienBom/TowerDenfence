package GameEntity.Tower;

import GameEntity.Bullet.BulletManager;
import GameEntity.Bullet.MachineGunBullet;
import GameEntity.Bullet.NormalBullet;
import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.EnemyManger;
import GameEntity.GameObject;
import Main.Player;
import javafx.scene.canvas.GraphicsContext;

public class Tower extends GameObject {
    protected int range;
    protected Enemy target;

    protected int attackRate;//attackRate time giữa 2 lần bắn
    protected int lastAttacked;//time kể từ lần bắn trc
    private Player player;
    private boolean destroy = false;

    public Tower(int range, int attackRate) {
        this.range = range;
        this.attackRate = attackRate;
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
        gc.fillRect(x + 20, y + 20, 10, 10);
    }

    @Override
    public void update() {
        //update lastAttacked
        if (target != null) lastAttacked++;
        else lastAttacked = 0;

        //update target
        checkRange();

        //fire a bullet
        if (lastAttacked > attackRate && target != null) {
            lastAttacked = 0;
            if (this instanceof NormalTower) {
                //BulletManager.addBullet("NormalBullet", target, this);
                BulletManager.addBullet(new NormalBullet(target,this));
            }
            if (this instanceof SmallerTower) {
                // BulletManager.addBullet("MachineGunBullet", target, this);
                BulletManager.addBullet(new MachineGunBullet(target,this));
            }
            if (this instanceof SniperTower) {
                BulletManager.addBullet(new NormalBullet(target,this));
            }
        }
    }
}
