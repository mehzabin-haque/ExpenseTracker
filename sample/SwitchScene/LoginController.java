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

public class LoginController extends Scene1Main {
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
    @FXML
    public Label username1,password,Sign_in,login_success;
    @FXML
    public Button log_in;
    @FXML
    public TextField user_name,pass_word;
    @FXML
    String user, pass;

    public void onClick_btn_login(ActionEvent e) {

        user = user_name.getText();
        pass = pass_word.getText();
        // System.out.println(user + " " + pass);
        boolean grantAccess = false;

        File f = new File("login.txt");
        try {
            Scanner read = new Scanner(f);

            while (read.hasNextLine()) {
                String S = read.nextLine();
                if (S.equals(user)) {
                    // System.out.println("user name match");
                    if (read.nextLine().equals(pass)) {
                        //System.out.println("password match");
                        grantAccess = true;
                        break;
                    }
                }
            }
            if (grantAccess) {
                login_success.setText("Login Successful.");
                switchToScene1_Source(e);


            } else {
                login_success.setText("Invalid information. Try again.");
            }
            read.close();

        } catch (FileNotFoundException m) {

            m.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_Main.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}