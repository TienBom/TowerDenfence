package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
import GameEntity.Enemy.NormalEnemy;
import GameEntity.Enemy.SmallerEnemy;
import GameEntity.Enemy.TankerEnemy;
import GameEntity.GameObject;
import GameEntity.Tower.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends GameObject {

    protected double speed;
    protected double damage;
    protected double range;
    protected Enemy target;
    protected Tower tower;
    private double xLoc;
    private double yLoc;
    private boolean destroy = false;
    protected double width;
    protected double height;
    protected Color color;

    public Bullet(Tower tower) {
        this.tower=tower;
        target = tower.getTarget();
        xLoc = tower.x + 12 * Math.cos(angleOfProjectileInRadians());
        yLoc = tower.y + 12 * Math.sin(angleOfProjectileInRadians());
    }

    public double angleOfProjectileInRadians() {
        return Math.atan2(target.y - tower.y, target.x - tower.x);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(xLoc, yLoc, width, height);
    }

    public void doDamage() {
        target.beAttacked(damage);
    }

    public void doDestroy() {
        destroy = true;
    }

    public boolean isDestroy() {
        return destroy;
    }
    public void move(){
        xLoc += speed*Math.cos(angleOfProjectileInRadians());

        yLoc += speed*Math.sin(angleOfProjectileInRadians());
    }
    public boolean isHit(){
        return (Math.abs(xLoc - target.x)< speed/2 || Math.abs(yLoc - target.y)< speed/2);
    }
    @Override
    public void update() {
        move();
        if (isHit()) {
            doDamage();
            doDestroy();
        } else if (Math.sqrt(Math.pow(this.x - tower.x, 2) + Math.pow(this.y - tower.y, 2)) > tower.getRange())
            doDestroy();
    }
}


