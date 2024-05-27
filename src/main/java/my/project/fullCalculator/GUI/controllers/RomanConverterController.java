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
import my.project.fullCalculator.calculators.ConverterRomanSystem;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RomanConverterController implements Initializable, SettableWindowSize {

    @FXML
    RadioButton toRoman;

    @FXML
    RadioButton fromRoman;

    @FXML
    TextField field;

    @FXML
    Label result;

    @FXML
    Button clear;

    @FXML
    private MenuButton menu;

    @FXML
    protected void pressingSolution() {
        String response;
        if (field.getText().isEmpty()) {
            return;
        }
        if (toRoman.isSelected()) { //Если выбрана конвертация в римские цифры
            response = ConverterRomanSystem.numberToRoman(Integer.parseInt(field.getText()));
            result.setText(response);
        }
        if (fromRoman.isSelected()) { //Если выбрана конвертация из римских цифр
            response = String.valueOf(ConverterRomanSystem.romanToInt(field.getText()));
            result.setText(response);
        }
    }

    @FXML
    protected void pressingClear() {
        toRoman.setSelected(false); //Снять выбор с кнопки
        fromRoman.setSelected(false); //Снять выбор с кнопки
        if (!field.getText().isEmpty()) {
            field.setText("");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image iconMenu =
                new Image(Objects.requireNonNull(RomanConverterController.class
                        .getResourceAsStream("/menu-icon.png")));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
        ToggleGroup toggleGroup = new ToggleGroup();
        toRoman.setToggleGroup(toggleGroup);
        fromRoman.setToggleGroup(toggleGroup);
    }

    @FXML
    protected void goBack() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/menu-view.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goToConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/system-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goCalculator() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-expression.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goToSolveInDifferentSystems() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-in-diff-systems.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }
}
