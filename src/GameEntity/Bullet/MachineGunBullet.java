package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Tower.Tower;

public class MachineGunBullet extends Bullet implements BulletProperty {
    public MachineGunBullet( Tower tower) {
        super(tower);
        this.x=tower.x;
        this.y=tower.y;
        this.range=MACHINEGUN_BULLET_RANGE;
        this.damage=MACHINEGUN_BULLET_DAMAGE;
        this.speed=MACHINEGUN_BULLET_SPEED;
        this.width=MACHINEGUN_BULLET_WIDTH;
        this.height=MACHINEGUN_BULLET_HEIGHT;
        this.color=MACHINEGUN_BULLET_COLOR;
    }
}
