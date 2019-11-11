package GameEntity.Bullet;

import GameEntity.Enemy.Enemy;
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
    protected double dx;
    protected double dy;
    private boolean destroy=false;

    public Bullet(Enemy target, Tower tower){
        this.target = target;
        this.tower = tower;
    }
    public void doDestroy() {
        destroy = true;
    }

    /**
     Hàm tính toán làm cho đạn bay thẳng
     tham khảo https://github.com/tdnguyenND/Tower-Defence.git
     */
    public void calculateVector(Enemy target) {
        double radian = Math.atan2(target.x - tower.x,
                target.y - tower.y);
        this.dx = Math.sin(radian) * speed;
        this.dy = Math.cos(radian) * speed;
    }
    public void doDamage(){
        target.beAttacked(damage);
    }
    public boolean isDestroy() {
        return destroy;
    }
    public void move(){
       x+=dx;
       y+=dy;
    }

    @Override
    public void render(GraphicsContext gc) {
            gc.setFill(Color.WHITE);
            gc.fillRect(x,y,20,20);
    }
    public boolean isHit(){
        return (Math.sqrt(Math.pow(this.x-target.y,2)+Math.pow(this.y-target.y,2)) <= target.x*10);
    }
    @Override
    public void update() {

            /**
             * TODO: - move
             *       - check isHit -> do dmg, doDes
             *       - check out of range -> do destroy
             */
            move();
            if(isHit()){
                doDamage();
                doDestroy();
            }
            else if( Math.sqrt(Math.pow(this.x-tower.y,2)+Math.pow(this.y-tower.y,2))> tower.getRange())
                doDestroy();
        }

}
