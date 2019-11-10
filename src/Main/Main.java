package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas=new Canvas(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
        GraphicsContext graphicsContext=canvas.getGraphicsContext2D();
        GameController gameController=new GameController(graphicsContext);
        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
        gameController.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
