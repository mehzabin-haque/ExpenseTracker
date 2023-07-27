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

import java.io.IOException;
import java.util.Objects;

public class Scene2Source {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label myLabel1;

    @FXML
    private TextField myTextField1;
    @FXML
    private TextField myTextField2;
    @FXML
    private TextField myTextField3;
    @FXML
    private Button myButton1;
    @FXML
    private Button myButton2;
    @FXML
    private Button myButton3;


    public void switchToScene2_Source(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene2_Source.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    int input;
    public void Input(ActionEvent event) {

        try {
            input = Integer.parseInt(myTextField1.getText());
            input = Integer.parseInt(myTextField2.getText());
            input = Integer.parseInt(myTextField3.getText());

            if(input >= 0) {
                myLabel1.setText("Thanks for the info.");

            }
            else {
                myLabel1.setText("You must enter some valid number.");
            }
        }
        catch (NumberFormatException e){
            myLabel1.setText("Enter only numbers please");
        }
        catch (Exception e) {
            myLabel1.setText("Error");

        }
    }
}

