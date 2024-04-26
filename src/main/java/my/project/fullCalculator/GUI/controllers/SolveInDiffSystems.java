package my.project.fullCalculator.GUI.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import my.project.fullCalculator.calculators.ConvertToDifferentSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SolveInDiffSystems implements Initializable {

    private final ObservableList<String> systemsTo =
            FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9",
                    "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");
    private final SpinnerValueFactory<String> factoryTo =
            new SpinnerValueFactory.ListSpinnerValueFactory<>(systemsTo);

    private final ObservableList<String> systemsFrom =
            FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7","8", "9","10", "11", "12",
                    "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");
    private final SpinnerValueFactory<String> factoryFrom =
            new SpinnerValueFactory.ListSpinnerValueFactory<>(systemsFrom);

    @FXML
    private MenuButton menu;

    @FXML
    private Spinner<String> systemFrom;

    @FXML
    private Spinner<String> systemTo;

    @FXML
    private TextField field;

    @FXML
    private Label result;

    @FXML
    protected void pressingSolution(ActionEvent event) {
        String to = systemTo.getValue();
        String from = systemFrom.getValue();
        String expression = field.getText();
        result.setText(ConvertToDifferentSystem.calculateTotal(expression, Integer.parseInt(from), Integer.parseInt(to)));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factoryTo.setValue("10");
        factoryFrom.setValue("2");
        systemTo.setValueFactory(factoryTo);
        systemFrom.setValueFactory(factoryFrom);
        Image iconMenu = new Image(RomanConverterController.class.getResourceAsStream("/menu-icon.png"));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
    }

    @FXML
    protected void pressingClear(ActionEvent event) {
        factoryTo.setValue("10");
        factoryFrom.setValue("2");
        if (!field.getText().isEmpty()) {
            field.setText("");
        }
        result.setText("");
    }


    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/menu-view.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @FXML
    protected void goToConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/system-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @FXML
    protected void goCalculator() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-expression.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @FXML
    protected void goToRomanConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/roman-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }
}
