package GameEntity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
    public int i, j;
    public int x;
    public int y;
    public Image img;

    abstract public  void render(GraphicsContext gc);

    abstract public void update();
}
