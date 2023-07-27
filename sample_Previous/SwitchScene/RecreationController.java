package sample.SwitchScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.IOException;
import java.util.Objects;


public class RecreationController extends Scene1Main{
    //Injecting all fxml elements to controller class.
    @FXML
    private Label label, warning,remainingMoney;
    @FXML
    private TextField textFieldRecreation;
    @FXML
    private Button USE;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Object NegativeNumberException;

    public class NegativeNumberException extends Exception {
        @Override
        public String toString() {
            return "Expenses for Recreation can't be greater than remained balance";
        }
    }
    public void useMoney(ActionEvent event){
        int usedMoney=Integer.parseInt(textFieldRecreation.getText());
        try {
            if (readDatafromFiles("remainedBalance.txt")<usedMoney){
                throw new NegativeNumberException();
            }
            else{
                writingInFile("remainedBalance.txt", Integer.toString(readDatafromFiles("remainedBalance.txt")-usedMoney));
                int remained=readDatafromFiles("remainedBalance.txt");
                label.setText(usedMoney+"tk has been used for recreational Expenses");
                remainingMoney.setText("Balance left:- "+remained);
                if (remained<1000 && remained!=0){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Low Money Alert!!!");
                    alert.setHeaderText("You have only "+remained+"tk left in your wallet...");
                    alert.show();
                }
                else if(remained==0){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Balanced Finished");
                    alert.setHeaderText("Your balance is finished.Can't use anymore.");
                    alert.show();
                }
            }
        }
        catch (NegativeNumberException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void onlySwitchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_RemainedBalance.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene4_AfterAddingMoney.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}