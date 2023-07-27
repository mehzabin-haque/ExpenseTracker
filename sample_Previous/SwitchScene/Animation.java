package sample.SwitchScene;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Animation {
    @FXML
    private Circle c1;

    @FXML
    private Circle c2;


    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void play(ActionEvent event){
        setRotate(c1,true,360,10);
        setRotate(c2,true,180,18);
    }

    private void setRotate(Circle c,boolean reverse , int angle , int duration){
        RotateTransition rt = new RotateTransition(Duration.seconds(duration),c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(18);
        rt.play();

    }

    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_Main.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
