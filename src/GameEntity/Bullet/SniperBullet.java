package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Tower.Tower;

public class SniperBullet extends Bullet implements BulletProperty {
    public SniperBullet(Enemy target, Tower tower) {
        super(target, tower);
        this.x=tower.x;
        this.y=tower.y;
        this.range=SNIPER_BULLET_RANGE;
        this.damage=SNIPER_BULLET_DAMAGE;
        calculateVector(target);
        this.speed=SNIPER_BULLET_SPEED;
    }
}
