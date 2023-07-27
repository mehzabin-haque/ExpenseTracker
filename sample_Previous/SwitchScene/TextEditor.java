package sample.SwitchScene;

import java.io.IOException;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main.Main;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class TextEditor implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button btn_copy;
    @FXML
    public Button btn_copySelect;
    @FXML
    public Button btn_save;
    @FXML
    public Button btn_exit;
    @FXML
    public Button btn_import;
    @FXML
    public Label lbl_FontSize;
    @FXML
    public Slider s;
    @FXML
    public TextArea txtOutput;
    private Object ResourceBundle;

    public TextEditor() {
    }
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


    public void switchToScene2_Source(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene2_Source.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene1_RemainedBalance.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize (URL url, ResourceBundle rb){
        s.setMax(100);
        s.setMin(0);
        s.setValue(20);
        lbl_FontSize.setText(String.valueOf(s.getValue()));
        s.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                {
                    lbl_FontSize.setText(String.format("%0.f",newValue));
                    txtOutput.setFont(Font.font("SansSerif",s.getValue()));
                }
            }
        }
        );


    }
}


