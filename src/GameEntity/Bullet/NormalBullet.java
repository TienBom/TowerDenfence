package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Tower.Tower;

import java.awt.*;

public class NormalBullet extends Bullet implements BulletProperty {
    public NormalBullet(Tower tower) {
        super(tower);
        this.x=tower.x;
        this.y=tower.y;
        this.range=NORMAL_BULLET_RANGE;
        this.damage=NORMAL_BULLET_DAMAGE;
        this.speed=NORMAL_BULLET_SPEED;
        calculateVector(target);
    }

}
