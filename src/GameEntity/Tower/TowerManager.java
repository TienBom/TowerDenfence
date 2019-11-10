package GameEntity.Tower;

import Main.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashSet;
import java.util.Set;

public class TowerManager  {
    public static Set<Tower> towerList;
    private static Player player;
    private static GraphicsContext graphicsContext;
    public static boolean init(Player _player,GraphicsContext _graphicsContext){
        player = _player;
        towerList = new HashSet<Tower>();
        graphicsContext=_graphicsContext;
        TowerManager.addTower(new NormalTower());
        return true;
    }

    public static void addTower(Tower tower){
        towerList.add(tower);
    }
    public static void update(){
        if(!towerList.isEmpty())
            for(Tower tower:towerList)
                tower.update();
    }
    public static void render(){
        if(!towerList.isEmpty())
            for (Tower tower:towerList)
                tower.render(graphicsContext);

    }
}
