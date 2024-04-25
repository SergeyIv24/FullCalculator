package my.project.fullCalculator.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import my.project.fullCalculator.calculators.ConverterRomanSystem;

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
        ToggleGroup toggleGroup = new ToggleGroup();
        toRoman.setToggleGroup(toggleGroup);
        fromRoman.setToggleGroup(toggleGroup);
    }
}
