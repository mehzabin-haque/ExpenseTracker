package sample.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) {
        try {
            this.stage = stage;
            Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("../SwitchScene/Intro.fxml")));
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.setTitle("Expense Tracker");
            this.stage.show();
            this.stage.getIcons().add(new Image("sample/Images/logo.png"));
            this.stage.setScene(new Scene(root, 800, 500));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
