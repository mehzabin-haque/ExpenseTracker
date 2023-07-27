package sample.SwitchScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.IOException;
import java.util.Objects;

public class Scene1Main {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    int input1;
    @FXML
    private TextField TextField1;
    @FXML
    private TextField TextField2;
    @FXML
    private TextField TextField3;
    @FXML
    private TextField TextField4;
    @FXML
    private TextField TextField5;
    @FXML
    private TextField TextField6;

    @FXML
    private Label Label1;
    public void switchToScene1_Source(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_Source.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Input1(ActionEvent event) {

        try {
            input1 = Integer.parseInt(TextField1.getText());
            input1 = Integer.parseInt(TextField2.getText());
            input1 = Integer.parseInt(TextField3.getText());
            input1 = Integer.parseInt(TextField4.getText());
            input1 = Integer.parseInt(TextField5.getText());
            input1 = Integer.parseInt(TextField6.getText());

            if(input1 >= 0) {
                Label1.setText("Thanks for the info.");
            }
            else {
                Label1.setText("You must enter some valid number.");
            }
        }
        catch (NumberFormatException e){
            Label1.setText("Enter only numbers please");
        }
        catch (Exception e) {
            Label1.setText("Error");
        }
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_RemainedBalance.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}