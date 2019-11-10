package GameEntity.Tower;

public class NormalTower extends Tower implements TowerProperty{
    public NormalTower(int range, int attackRate) {
        super(range, attackRate);
    }
    public NormalTower(){
        super(NORMAL_TOWER_RANGE,NORMAL_TOWER_ATTACKRATE);
        this.x = 4 * 80;
        this.y = 2 * 80;
    }
}
