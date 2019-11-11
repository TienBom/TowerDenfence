package GameEntity.Enemy;

import GameEntity.GameObject;
import Main.Player;
import Main.Points;
import Main.Position;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Enemy extends GameObject {
    private double health;
    private double armor;
    private double speed;
    private int reward;
    private Image gunImg;
    private boolean destroy;

    // all Enemy use the same player and map
    private Player player;

    public Direction direction = Direction.UP;
    public int wayPointIndex = 0;

    public Enemy(double health, double armor, double speed, int reward, Player player) {
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.gunImg = gunImg;
        this.direction = Direction.UP;
        this.wayPointIndex = 0;
        this.player = player;
    }

    //Cập nhật vị trí
    public Position getNextWayPoint() {
        if (wayPointIndex < Points.wayPoints.length - 1)
            return Points.wayPoints[++wayPointIndex];
        return null;
    }

    public void render(GraphicsContext gc) {
        /*SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);

        /*gc.drawImage(base, x, y);
        gc.drawImage(gun, x, y);*/
        gc.setFill(Color.YELLOW);
        gc.fillRect(x, y, 10, 10);


    }

    void calculateDirection() {
        if (wayPointIndex >= Points.wayPoints.length) {
            // Enemy den way point cuoi
            doDamage();
            doDestroy();
            return;
        }
        Position currentWP = Points.wayPoints[wayPointIndex];
        if ((Math.sqrt(Math.pow(x - currentWP.x, 2) + Math.pow(y - currentWP.y, 2))) <= speed) {
            x = currentWP.x;
            y = currentWP.y;
            Position nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }

    @Override
    public void update() {
        if (health <= 0) {
            doDestroy();
        } else if(wayPointIndex>=Points.wayPoints.length-1){
            doDamage();
            doDestroy();
        }else{
            calculateDirection();
            switch (direction) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
            }
        }
    }

    enum Direction {
        LEFT(1), UP(-1), RIGHT(2), DOWN(-2);

        public int degree;

        Direction(int i) {
            degree = i;
        }

        public int getDegree() {
            return degree;
        }
    }
    //

    public void doDestroy() {
        /**
         * TODO:
         *  - Call EnemyManager to delete this enemy
         */
        destroy = true;
    }

    public void doDamage() {
        player.beAttacked();
    }


    public void beAttacked(final double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            doDestroy();
            player.earnMoney(this.reward);
        }
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
