package Main;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DrawMap {
    public static final String[][] MAP_SPRITES = new String[][]{
            {"024", "024", "003", "047", "047", "047", "004", "024", "024", "024"},
            {"024", "024", "025", "299", "001", "002", "023", "024", "024", "024"},
            {"024", "024", "025", "023", "024", "025", "023", "024", "024", "024"},
            {"003", "047", "048", "023", "024", "025", "023", "024", "024", "024"},
            {"025", "299", "001", "027", "024", "025", "046", "047", "047", "047"},
            {"025", "023", "024", "024", "024", "026", "001", "001", "001", "001"},
            {"025", "023", "024", "024", "024", "024", "024", "024", "024", "024"},
    };
    public static void draw(GraphicsContext graphicsContext){
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                graphicsContext.drawImage(new Image("file:src/resources/AssetsKit_2/PNG/Retina/towerDefense_tile" + MAP_SPRITES[i][j] + ".png"), j * 80, i * 80);
            }
        }
    }
}

