package sample.SwitchScene;

import sample.TotalIncome.TotalIncome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


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


    //    int recreationExpense;
//    public int readDatafromFiles(String filename){
//        File file=new File(filename);
//        String line = null;
//        try {
//            Scanner scanner=new Scanner(file);
//            while(scanner.hasNextLine()){
//                line=scanner.nextLine();
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return Integer.parseInt(line);
//    }
//    int remainedBl=readDatafromFiles("remainedBalance.txt");
//
//    public void addMoney(ActionEvent event){
//        TotalIncome totalIncome =new TotalIncome(remainedBl);
//        int previousTotalIncome=totalIncome.getTotalIncome();
//        recreationExpense=Integer.parseInt(textField.getText());
//        int remainingMoney=previousTotalIncome-recreationExpense;
//        label.setText(textField.getText() + "tk has been used for recreational cost" + " total money remaining:"+remainingMoney);
//        totalIncome.setTotalIncome(remainingMoney);
//        if (totalIncome.getTotalIncome()<1000){
//            Alert alert=new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Low Money Alert!!!");
//            alert.setHeaderText("You have less than 1000tk in your wallet...");
//            alert.show();
//        }
//    }
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
                   alert.setHeaderText("You have only "+remained+"tk left in your wallet...");
                   alert.show();
               }
            }
        }
        catch (NegativeNumberException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }


    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene3_Recreation.fxml")));
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