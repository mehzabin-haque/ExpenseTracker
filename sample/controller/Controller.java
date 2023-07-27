package sample.controller;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import sample.Main.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.SwitchScene.Scene2Source;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller extends Scene2Source {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    @FXML
    LineChart<String , Number > lineChart;

    public void switchToScene1(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene1_RemainedBalance.fxml",event);
    }

    public void onlyswitchToScene4(ActionEvent event) throws IOException {
        sceneSwitching("../SwitchScene/Scene4_AfterAddingMoney.fxml",event);
    }

    public void switchToBarChart(ActionEvent event) throws IOException {
        sceneSwitching("../BarChart.fxml",event);
    }

    public void LineGraph(ActionEvent event) throws IOException{
        lineChart.getData().clear();
        XYChart.Series< String,Number > series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("January",200));
        series.getData().add(new XYChart.Data<String,Number>("February",500));
        series.getData().add(new XYChart.Data<String,Number>("March",300));
        series.getData().add(new XYChart.Data<String,Number>("April",600));
        series.getData().add(new XYChart.Data<String,Number>("May",400));
        series.getData().add(new XYChart.Data<String,Number>("June",100));
        series.getData().add(new XYChart.Data<String,Number>("July",150));
        series.getData().add(new XYChart.Data<String,Number>("August",250));
        series.getData().add(new XYChart.Data<String,Number>("September",300));
        series.getData().add(new XYChart.Data<String,Number>("October",420));
        series.getData().add(new XYChart.Data<String,Number>("November",310));
        series.getData().add(new XYChart.Data<String,Number>("December",550));
        lineChart.getData().add(series);
        series.setName("Monthly Update");
        // lineChart.getXAxis().setLabel("Monthly Update");

    }

    @FXML
    private TextField textFieldSavings;

    public void switchToScene4(ActionEvent event) throws IOException {
        createNewFile("Savings.txt");
        int savings=Integer.parseInt(textFieldSavings.getText());
        writingInFile("Savings.txt",Integer.toString(savings));
        writingInFile("remainedBalance.txt",Integer.toString(readDatafromFiles("remainedBalance.txt")-savings));
        //Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("../SwitchScene/Scene4_AfterAddingMoney.fxml")));
        sceneSwitching("../SwitchScene/Scene4_AfterAddingMoney.fxml",event);
    }

    @FXML
    private BarChart<String,Number> barChart;


    public void BarChart(ActionEvent event) throws IOException {

        barChart.getData().clear();
        XYChart.Series< String,Number > series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("January",200));
        series.getData().add(new XYChart.Data<String,Number>("February",500));
        series.getData().add(new XYChart.Data<String,Number>("March",300));
        series.getData().add(new XYChart.Data<String,Number>("April",600));
        series.getData().add(new XYChart.Data<String,Number>("May",400));
        series.getData().add(new XYChart.Data<String,Number>("June",100));
        series.getData().add(new XYChart.Data<String,Number>("July",150));
        series.getData().add(new XYChart.Data<String,Number>("August",250));
        series.getData().add(new XYChart.Data<String,Number>("September",300));
        series.getData().add(new XYChart.Data<String,Number>("October",420));
        series.getData().add(new XYChart.Data<String,Number>("November",310));
        series.getData().add(new XYChart.Data<String,Number>("December",550));
        barChart.getData().add(series);
        series.setName("Monthly Update");

    }
}