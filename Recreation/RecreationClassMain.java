package sample.Recreation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RecreationClassMain {


    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RecreationClass.fxml"));
        stage.setTitle("Recreation Cost Add");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        Image image = new Image("sample/Recreation/Recreation.png");
        stage.getIcons().add(image);
        stage.show();
    }
}



