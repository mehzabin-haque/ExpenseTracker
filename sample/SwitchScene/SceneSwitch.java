package sample.SwitchScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {

    @FXML
    public Stage stage;
    public Scene scene;
    public Parent root;

    public void sceneSwitching(String fxmlFileName, ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxmlFileName)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }
}
