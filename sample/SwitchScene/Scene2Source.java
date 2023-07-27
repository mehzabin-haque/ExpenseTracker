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

import java.io.*;
import java.util.Objects;
import java.io.IOException;
import java.util.Scanner;

public class Scene2Source extends Scene1Main {

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
    int inputB, inputJ, inputO;
    @FXML
    public Button obosistotk;
    @FXML
    public Label remainedBalance;


    public void showRemainedBalance() {
        remainedBalance.setText(Integer.toString(readDatafromFiles("remainedBalance.txt")));
    }

    public void Input(ActionEvent event) throws IOException {
        createNewFile("SourceOfIncome.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter("SourceOfIncome.txt"));
        out.write(myTextField1.getText() + "\n");
        out.close();
        out = new BufferedWriter(new FileWriter("SourceOfIncome.txt", true));
        out.write(myTextField2.getText() + "\n");
        out.close();
        out = new BufferedWriter(new FileWriter("SourceOfIncome.txt", true));
        out.write(myTextField3.getText());
        out.close();

    }

    public void createNewFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writingInFile(String fileName, String writtenString) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(writtenString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToScene2_Source(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene2_Source.fxml" , event );
    }

    public void switchToMain(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_Main.fxml" , event );
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene2_Savings.fxml",event);
    }

    public void onlySwitchToScene1(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_RemainedBalance.fxml",event);
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene4_AfterAddingMoney.fxml",event);
    }

    public void switchToRecreation(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Recreation.fxml",event);
    }
}
