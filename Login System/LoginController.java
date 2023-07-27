package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginController {
    @FXML
    public Label username;
    @FXML
    public Label password;
    @FXML
    public Label Sign_in;
    @FXML
    public Button log_in;
    @FXML
    public TextField user_name;
    @FXML
    public TextField pass_word;
    @FXML
    public Label login_success;
    @FXML
    String user, pass;

    public void onClick_btn_login(ActionEvent e) {

            user = user_name.getText();
            pass = pass_word.getText();
            System.out.println(user + " " + pass);
             boolean grantAccess = false;

            File f = new File("login.txt");
            try {
                Scanner read = new Scanner(f);

                while (read.hasNextLine()) {
                    String S = read.nextLine();
                    if (S.equals(user)) {
                        System.out.println("user name match");
                        if (read.nextLine().equals(pass)) {
                            System.out.println("password match");
                            grantAccess = true;
                            break;
                        }
                    }
                }
                if (grantAccess) {
                    login_success.setText("Login Successful.");
                } else {
                    login_success.setText("Invalid information. Try again.");
                }
                read.close();

            } catch (FileNotFoundException m) {

                m.printStackTrace();
            }
        }

    }
