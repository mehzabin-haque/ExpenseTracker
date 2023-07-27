package sample.SwitchScene;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Registration extends SceneSwitch {
    @FXML
    public Button btn_register,btn_switch1,btn_switch2,go_to_next;
    @FXML
    public TextField username,email_id,contact_no;
    @FXML
    public Label label;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Stage stage;
    public Scene scene;
    public Parent root;
    @FXML
    public void onClick_btn_register(ActionEvent e){
        StringBuilder sb = new StringBuilder();
        sb.append(username.getText().toString()+"\n");
        sb.append(passwordField.getText().toString());
        label.setText("Registration successful.");
        File file = new File("login.txt");
        try {
            FileWriter w = new FileWriter(file);
            w.write(sb.toString());
            w.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        File f = new File("information.txt");
        try{
            FileWriter w= new FileWriter(f);
            w.write(email_id.getText()+"\n");
            w.append(contact_no.getText()+"\n");
            w.close();
        }
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void switchToScene1_Login(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/loginController.fxml",event);
    }
    public void switchToMain(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_Main.fxml",event);
    }

}
