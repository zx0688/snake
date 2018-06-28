package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Map<String, Image> imageCache = new HashMap<>();
    private GameField gameField;

    public static Image getImage(String name) {
        
        Image image = imageCache.get(name);
        if (image == null) {
            String url = Main.class.getResource("body.png").toString();
            image = new Image(url);
            imageCache.put(name, image);
        }
        return image;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Parent root = loader.load();

        primaryStage.setTitle("Snake");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();

        gameField = new GameField();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                //classic game cycle
                update();
            }
        };

        timer.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void update() {

    }
}
