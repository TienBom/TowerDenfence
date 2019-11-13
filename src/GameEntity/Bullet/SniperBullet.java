package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Tower.Tower;

public class SniperBullet extends Bullet implements BulletProperty {
    public SniperBullet(Tower tower) {
        super(tower);
        this.x=tower.x;
        this.y=tower.y;
        this.range=SNIPER_BULLET_RANGE;
        this.damage=SNIPER_BULLET_DAMAGE;
        this.speed=SNIPER_BULLET_SPEED;
        calculateVector(target);
    }
}
