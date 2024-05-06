package my.project.fullCalculator.GUI.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import my.project.fullCalculator.GUI.Constance;
import my.project.fullCalculator.calculators.ConvertToDifferentSystem;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SolveInDiffSystems implements Initializable {

    //Значение для Spinner
    private final SpinnerValueFactory<String> factoryTo =
            new SpinnerValueFactory.ListSpinnerValueFactory<>(Constance.systems);
    private final SpinnerValueFactory<String> factoryFrom =
            new SpinnerValueFactory.ListSpinnerValueFactory<>(Constance.systems);

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
    protected void pressingSolution() {
        String to = systemTo.getValue();
        String from = systemFrom.getValue();
        String expression = field.getText();
        result.setText(ConvertToDifferentSystem.calculateTotal(expression, Integer.parseInt(from), Integer.parseInt(to)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factoryTo.setValue("10"); //Начальное значение для Spinner
        factoryFrom.setValue("2"); //Начальное значение для Spinner
        systemTo.setValueFactory(factoryTo); //Установка всех значений для Spinner
        systemFrom.setValueFactory(factoryFrom); //Установка всех значений для Spinner
        Image iconMenu =
                new Image(Objects.requireNonNull(RomanConverterController.class
                        .getResourceAsStream("/menu-icon.png")));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
    }

    @FXML
    protected void pressingClear() {
        factoryTo.setValue("10");
        factoryFrom.setValue("2");
        if (!field.getText().isEmpty()) {
            field.setText("");
        }
        result.setText("");
    }

    @FXML
    protected void goBack() throws IOException {
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
