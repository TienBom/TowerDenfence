package GameEntity.Tower;

public class NormalTower extends Tower implements TowerProperty{
    public NormalTower() {

    }
    public NormalTower(int x,int y){
       this.range=NORMAL_TOWER_RANGE;
       this.attackRate=NORMAL_TOWER_ATTACKRATE;
       this.x = x;
       this.y = y;
       this.lastAttacked=0;

    }
}
