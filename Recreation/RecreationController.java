package sample.Recreation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RecreationController {
    //Injecting all fxml elements to controller class.
    @FXML
    private Label label, warning;
    @FXML
    private TextField textField;
    @FXML
    private Button add;


    int recreationExpense;

    public void addMoney(ActionEvent event){
        TotalIncome totalIncome =new TotalIncome(10000);
        int previousTotalIncome=totalIncome.getTotalIncome();
        recreationExpense=Integer.parseInt(textField.getText());
        int remainingMoney=previousTotalIncome-recreationExpense;
        label.setText(textField.getText() + "tk has been used for recreational cost" + " total money remaining:"+remainingMoney);
        totalIncome.setTotalIncome(remainingMoney);
        if (totalIncome.getTotalIncome()<1000){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Low Money Alert!!!");
            alert.setHeaderText("You have less than 1000tk in your wallet...");
            //alert.showAndWait();
            alert.show();
        }
    }
}
