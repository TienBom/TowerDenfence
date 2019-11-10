package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Tower.Tower;

public class MachineGunBullet extends Bullet implements BulletProperty {
    public MachineGunBullet(Enemy target, Tower tower) {
        super(target, tower);
        this.x=tower.x;
        this.y=tower.y;
        this.range=MACHINEGUN_BULLET_RANGE;
        this.damage=MACHINEGUN_BULLET_DAMAGE;
        calculateVector(target);
        this.speed=MACHINEGUN_BULLET_SPEED;
    }
}
