package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class Main extends Application {
    public static Label label_health=new Label("health");
    public static Label label_coin=new Label("coin");
    public  static Scene sceneStart,sceneField,sceneExit,sceneWin;


    public static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        AnchorPane root2=new AnchorPane();// màn hình GameOver
        AnchorPane root1=new AnchorPane();// màn hình Start
        AnchorPane root3=new AnchorPane();// màn hình WinGame
        AnchorPane root = new AnchorPane();// màn hình gameField

        ImageView imgV_Win=new ImageView(new Image("file:src/resources/AssetsKit_2/PNG/win.png"));
        Button buttonExit1=new Button("   EXIT   ");
        buttonExit1.setStyle("-fx-background-color: #F2662A;-fx-font-weight: bold");
        AnchorPane.setTopAnchor(buttonExit1,500.0);
        AnchorPane.setLeftAnchor(buttonExit1,450.0);

        ImageView imgV_Exit=new ImageView(new Image("file:src/resources/AssetsKit_2/PNG/exit.png"));

        Button buttonExit=new Button("   EXIT   ");
        buttonExit.setStyle("-fx-background-color: #F2662A;-fx-font-weight: bold");
        AnchorPane.setTopAnchor(buttonExit,500.0);
        AnchorPane.setLeftAnchor(buttonExit,450.0);

        ImageView imgV_title=new ImageView(new Image("file:src/resources/AssetsKit_2/PNG/tower_denfence.png"));

        Button buttonStart=new Button("START GAME");
        buttonStart.setStyle("-fx-background-color: #F2662A;-fx-font-weight: bold");
        AnchorPane.setTopAnchor(buttonStart,400.0);
        AnchorPane.setLeftAnchor(buttonStart,450.0);


       // window.setScene(new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
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

        Button btnNormalTower = new Button("NormalTower - 250$");
        btnNormalTower.setId("NormalTower");
        Button btnSmallerTower = new Button("SmallerTower - 500$");
        btnSmallerTower.setId("SmallerTower");
        Button btnSniperTower = new Button("SniperTower - 550$");
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

        AnchorPane.setTopAnchor(label_health,20.0);
        AnchorPane.setLeftAnchor(label_health,850.0);

        AnchorPane.setTopAnchor(label_coin,50.0);
        AnchorPane.setLeftAnchor(label_coin,850.0);

        Button buttonBack=new Button("BACK");
        buttonBack.setStyle("-fx-background-color: #F2662A;-fx-font-weight: bold");
        AnchorPane.setTopAnchor(buttonBack, 200.0);
        AnchorPane.setLeftAnchor(buttonBack, 850.0);

        Canvas canvas = new Canvas(Config.SCREEN_WIDTH - 150.0, Config.SCREEN_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GameController gameController = new GameController(graphicsContext);
        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        root.getChildren().addAll(btnNormalTower, btnSmallerTower, btnSniperTower, canvas,imgV_health,imgV_gold,imgV_normal_tower,imgV_smaller_tower,imgV_sniper_tower,label_coin,label_health,buttonBack);

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
        sceneField=new Scene(root,Config.SCREEN_WIDTH+30,Config.SCREEN_HEIGHT);
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneField);
                window.show();
                gameController.restart();
                gameController.start();
            }
        });
        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneStart);
                gameController.restart();
                window.show();
            }
        });
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneStart);
                window.show();
            }
        });
        buttonExit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneStart);
                window.show();
            }
        });

        root2.getChildren().addAll(imgV_Exit,buttonExit);
        root1.getChildren().addAll(imgV_title,buttonStart);
        root3.getChildren().addAll(imgV_Win,buttonExit1);
        sceneWin=new Scene(root3,990,550);
        sceneStart=new Scene(root1,990,550);
        sceneExit=new Scene(root2,990,550);
        window.setScene(sceneStart);
        window.setResizable(false);
        window.setTitle(Config.GAME_NAME);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
