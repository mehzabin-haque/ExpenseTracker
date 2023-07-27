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
public class Scene1Main {
    @FXML
    public Stage stage;
    public Scene scene;
    public Parent root;
    int input1;
    @FXML
    private TextField TextField1,TextField2,TextField3,TextField4,TextField5,TextField6;
    @FXML
    private Label Label1;

    public void switchToScene1_Source(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_Source.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        //remainedBalance.setText(Integer.toString(remainedBalances));
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        calculatingRemainedBalance();
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_RemainedBalance.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onlySwitchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_RemainedBalance.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_Main.fxml")));
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
    public void switchToRecreation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Recreation.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    LineChart<String , Number > lineChart;
    public void LineGraphSwitch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../sample.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public Button btn_register,btn_switch1,btn_switch2,go_to_next;
    @FXML
    public TextField username,email_id,contact_no;
    @FXML
    public Label label;
    @FXML
    public PasswordField passwordField;
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
    public void switchToScene1_Login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/loginController.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTextEditor(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/TextEditor.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public Button btn_copy,btn_copySelect,btn_save,btn_exit,btn_import;
    @FXML
    public Label lbl_FontSize;
    @FXML
    public Slider s;
    @FXML
    public TextArea txtOutput;
    private Object ResourceBundle;

    @FXML
    public void onClick_btn_exit(ActionEvent e) {
        Platform.exit();
    }
    @FXML
    public void onClick_btn_copy(ActionEvent e) {
        String myText = txtOutput.getText().toString();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(myText);
        clipboard.setContent(content);
    }
    @FXML
    public void onClick_btn_copySelect(ActionEvent e) {
        String myText = txtOutput.getSelectedText().toString();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(myText);
        clipboard.setContent(content);
    }
    @FXML
    public void onClick_btn_Import(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File.");
        File selectedFile = chooser.showOpenDialog(stage);
        FileReader FR = new FileReader(selectedFile.getAbsolutePath().toString());
        BufferedReader BR = new BufferedReader(FR);
        StringBuilder sb = new StringBuilder();
        String myText = "";
        while ((myText = BR.readLine()) != null) {
            sb.append(myText + "\n");
            txtOutput.setText(sb.toString());
        }

    }
    @FXML
    public void onClick_btn_Save(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File.");
        File selectedFile = chooser.showSaveDialog(stage);
        FileWriter FW = new FileWriter(selectedFile.getAbsolutePath());
        FW.write(txtOutput.getText().toString());
        FW.close();
    }
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myLabel;
    public void getDate(ActionEvent event) {

        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        myLabel.setText(myFormattedDate);
    }
}