package sample.SwitchScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Main.Main;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
public class Scene1Main extends SceneSwitch{

    int input1;
    @FXML
    private TextField TextField1,TextField2,TextField3,TextField4,TextField5,TextField6;
    @FXML
    private Label Label1;

    public void switchToScene1_Source(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_Source.fxml",event);
    }
    public void createNewFile(String fileName)  {
        File file= new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writingInFile(String fileName, String writtenString) {
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(writtenString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Input1(ActionEvent event) throws  IOException{
        createNewFile("TotalExpenses.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter("TotalExpenses.txt"));
        out.write(TextField1.getText()+"\n");
        out.close();

        //2
        out = new BufferedWriter(new FileWriter("TotalExpenses.txt",true));
        out.write(TextField2.getText()+"\n");
        out.close();

        //3
        out = new BufferedWriter(new FileWriter("TotalExpenses.txt",true));
        out.write(TextField3.getText()+"\n");
        out.close();

        //4
        out = new BufferedWriter(new FileWriter("TotalExpenses.txt",true));
        out.write(TextField4.getText()+"\n");
        out.close();
        //5
        out = new BufferedWriter(new FileWriter("TotalExpenses.txt",true));
        out.write(TextField5.getText()+"\n");
        out.close();

        //6
        out = new BufferedWriter(new FileWriter("TotalExpenses.txt",true));
        out.write(TextField6.getText());
        out.close();
    }
    public int readDatafromFiles(String filename){
        File file=new File(filename);
        int totalExpense=0;
        String line = null;
        try {
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                line=scanner.nextLine();
                totalExpense +=Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  totalExpense;

    }

    public int remainedBalances;
    public void calculatingRemainedBalance(){
        remainedBalances =readDatafromFiles("SourceOfIncome.txt")-readDatafromFiles("TotalExpenses.txt");
        createNewFile("remainedBalance.txt");
        writingInFile("remainedBalance.txt",Integer.toString(remainedBalances));
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        calculatingRemainedBalance();
        sceneSwitching("../SwitchScene/Scene1_RemainedBalance.fxml" , event);
    }
    public void onlySwitchToScene1(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_RemainedBalance.fxml" , event);
    }
    public void switchToMain(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_Main.fxml", event);
    }
    public void switchToScene4(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene4_AfterAddingMoney.fxml" , event);
    }
    public void switchToRecreation(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Recreation.fxml",event);
    }

    @FXML
    LineChart<String , Number > lineChart;
    public void LineGraphSwitch(ActionEvent event) throws IOException {
        sceneSwitching("../sample.fxml" , event);
    }

    public void switchToScene1_Login(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/loginController.fxml" , event);
    }
    public void switchToTextEditor(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/TextEditor.fxml" , event);
    }

}