package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button btn_register;
    @FXML
    public Button btn_switch1;
    @FXML
    public Button btn_switch2;
    @FXML
    public TextField username;
    @FXML
    public TextField email_id;
    @FXML
    public TextField contact_no;
    @FXML
    public Label label;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button go_to_next;
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("loginController.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

    @FXML
    public void onClick_btn_register(ActionEvent e){
        StringBuilder sb = new StringBuilder();
        sb.append(username.getText().toString()+"\n");
        //sb.append(email_id.getText().toString()+",");
        //sb.append(contact_no.getText().toString()+",");
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
}
