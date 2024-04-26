package my.project.fullCalculator.GUI;

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
import my.project.fullCalculator.calculators.ConverterRomanSystem;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class RomanConverterController implements Initializable {

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
    protected void pressingSolution(ActionEvent event) {
        String response;
        if (field.getText().isEmpty()) {
            return;
        }
        if (toRoman.isSelected()) {
            response = ConverterRomanSystem.numberToRoman(Integer.parseInt(field.getText()));
            result.setText(response);
        }
        if (fromRoman.isSelected()) {
            response = String.valueOf(ConverterRomanSystem.romanToInt(field.getText()));
            result.setText(response);
        }
    }

    @FXML
    protected void pressingClear(ActionEvent event) {
        toRoman.setSelected(false);
        fromRoman.setSelected(false);
        if (!field.getText().isEmpty()) {
            field.setText("");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image iconMenu = new Image(RomanConverterController.class.getResourceAsStream("/menu-icon.png"));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
        ToggleGroup toggleGroup = new ToggleGroup();
        toRoman.setToggleGroup(toggleGroup);
        fromRoman.setToggleGroup(toggleGroup);
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

}
