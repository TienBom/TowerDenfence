package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //AnchorPane root =  (AnchorPane) FXMLLoader.load(Main.class.getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
        Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GameController gameController = new GameController(graphicsContext);
        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        //root.getChildren().add(canvas);
        /*canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameController.MouseHandling(event);
            }
        });*/
        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.show();
        gameController.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
