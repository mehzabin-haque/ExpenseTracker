package sample.SwitchScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class LoginController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    public void switchToScene1_Login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/loginController.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene_CreatAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/CreateAccount.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}