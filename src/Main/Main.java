package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        primaryStage.setScene(new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
        Image img_health=new Image("file:src/resources/AssetsKit_2/PNG/like.png");
        Image img_gold=new Image("file:src/resources/AssetsKit_2/PNG/coin.png");
        Image img_normal_tower=new Image("file:src/resources/AssetsKit_2/PNG/normal-tower-icon.png");
        Image img_smaller_tower=new Image("file:src/resources/AssetsKit_2/PNG/smaller-tower-icon.png");
        Image img_sniper_tower=new Image("file:src/resources/AssetsKit_2/PNG/sniper_tower_icon.png");
        ImageView imgV_health=new ImageView(img_health);
        ImageView imgV_gold=new ImageView(img_gold);
        ImageView imgV_normal_tower=new ImageView(img_normal_tower);
        ImageView imgV_smaller_tower=new ImageView(img_smaller_tower);
        ImageView imgV_sniper_tower=new ImageView(img_sniper_tower);

        Button btnNormalTower = new Button("NormalTower");
        btnNormalTower.setId("NormalTower");
        Button btnSmallerTower = new Button("SmallerTower");
        btnSmallerTower.setId("SmallerTower");
        Button btnSniperTower = new Button("SniperTower");
        btnSniperTower.setId("SniperTower");

        AnchorPane.setTopAnchor(btnNormalTower, 80.0);
        AnchorPane.setLeftAnchor(btnNormalTower, 850.0);
        AnchorPane.setTopAnchor(imgV_normal_tower,85.0);
        AnchorPane.setLeftAnchor(imgV_normal_tower,820.0);

        AnchorPane.setTopAnchor(btnSmallerTower, 120.0);
        AnchorPane.setLeftAnchor(btnSmallerTower, 850.0);
        AnchorPane.setTopAnchor(imgV_smaller_tower,125.0);
        AnchorPane.setLeftAnchor(imgV_smaller_tower,820.0);

        AnchorPane.setTopAnchor(btnSniperTower, 160.0);
        AnchorPane.setLeftAnchor(btnSniperTower, 850.0);
        AnchorPane.setTopAnchor(imgV_sniper_tower,165.0);
        AnchorPane.setLeftAnchor(imgV_sniper_tower,820.0);

        AnchorPane.setTopAnchor(imgV_health,20.0);
        AnchorPane.setLeftAnchor(imgV_health,820.0);
        AnchorPane.setTopAnchor(imgV_gold,50.0);
        AnchorPane.setLeftAnchor(imgV_gold,820.0);

        Canvas canvas = new Canvas(Config.SCREEN_WIDTH - 150.0, Config.SCREEN_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GameController gameController = new GameController(graphicsContext);
        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
        root.getChildren().addAll(btnNormalTower, btnSmallerTower, btnSniperTower, canvas,imgV_health,imgV_gold,imgV_normal_tower,imgV_smaller_tower,imgV_sniper_tower);
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameController.MouseHandling(event);
            }
        });
        btnNormalTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameController.chooseTower(event);
            }
        });
        btnSmallerTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameController.chooseTower(event);
            }
        });
        btnSniperTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameController.chooseTower(event);
            }
        });
        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.show();
        gameController.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
