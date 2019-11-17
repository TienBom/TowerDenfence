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
        this.width=SNIPER_BULLET_WIDTH;
        this.height=SNIPER_BULLET_HEIGHT;
        this.color=SNIPER_BULLET_COLOR;
    }
}
