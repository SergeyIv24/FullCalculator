package my.project.fullCalculator.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import my.project.fullCalculator.calculators.ConvertToDifferentSystem;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class SystemConverterController implements Initializable {

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
    private Spinner<String> from;

    @FXML
    private Spinner<String> to;

    @FXML
    private TextField fieldForConverting;

    @FXML
    private Label result;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factoryTo.setValue("10");
        factoryFrom.setValue("2");
        from.setValueFactory(factoryTo);
        to.setValueFactory(factoryFrom);
    }

    @FXML
    protected void pressingEveryNumber(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();

        if (btn.getId().equals(numbersId.ONE)) {
            fieldForConverting.setText(fieldForConverting.getText() + "1");
        }

        if (btn.getId().equals(numbersId.TWO)) {
            fieldForConverting.setText(fieldForConverting.getText() + "2");
        }

        if (btn.getId().equals(numbersId.THREE)) {
            fieldForConverting.setText(fieldForConverting.getText() + "3");
        }

        if (btn.getId().equals(numbersId.FOUR)) {
            fieldForConverting.setText(fieldForConverting.getText() + "4");
        }

        if (btn.getId().equals(numbersId.FIVE)) {
            fieldForConverting.setText(fieldForConverting.getText() + "5");
        }

        if (btn.getId().equals(numbersId.SIX)) {
            fieldForConverting.setText(fieldForConverting.getText() + "6");
        }

        if (btn.getId().equals(numbersId.SEVEN)) {
            fieldForConverting.setText(fieldForConverting.getText() + "7");
        }

        if (btn.getId().equals(numbersId.EIGHT)) {
            fieldForConverting.setText(fieldForConverting.getText() + "8");
        }

        if (btn.getId().equals(numbersId.NINE)) {
            fieldForConverting.setText(fieldForConverting.getText() + "9");
        }

        if (btn.getId().equals(numbersId.ZERO)) {
            fieldForConverting.setText(fieldForConverting.getText() + "0");
        }

        if (btn.getId().equals(numbersId.A)) {
            fieldForConverting.setText(fieldForConverting.getText() + "A");
        }

        if (btn.getId().equals(numbersId.B)) {
            fieldForConverting.setText(fieldForConverting.getText() + "B");
        }

        if (btn.getId().equals(numbersId.C)) {
            fieldForConverting.setText(fieldForConverting.getText() + "C");
        }

        if (btn.getId().equals(numbersId.D)) {
            fieldForConverting.setText(fieldForConverting.getText() + "D");
        }

        if (btn.getId().equals(numbersId.E)) {
            fieldForConverting.setText(fieldForConverting.getText() + "E");
        }

        if (btn.getId().equals(numbersId.F)) {
            fieldForConverting.setText(fieldForConverting.getText() + "F");
        }

        if (btn.getId().equals(numbersId.POINT)) {
            fieldForConverting.setText(fieldForConverting.getText() + ".");
        }

        if (btn.getId().equals(numbersId.SOLUTION)) {
            int systemFrom = Integer.parseInt(from.getValue());
            int systemTo = Integer.parseInt(to.getValue());
            String expression = fieldForConverting.getText();
            result.setText(converter(systemFrom, systemTo, expression));

        }


        if (btn.getId().equals(numbersId.CLEAR)) {
            fieldForConverting.setText("");
            result.setText("");
        }

        if (btn.getId().equals(numbersId.DELETE_LAST)) {
            StringBuilder stringBuilder = new StringBuilder(fieldForConverting.getText());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fieldForConverting.setText(stringBuilder.toString());
        }
    }

    private String converter(int systemFrom, int systemTo, String expression) {
        if (systemFrom == 10) {
            return ConvertToDifferentSystem.convertToDiffSystemFrom10(Integer.parseInt(expression), systemTo);
        } else if (systemTo == 10) {
            return String.valueOf(ConvertToDifferentSystem.convertFromDiffSystemTo10(expression, systemFrom));
        } else {
            long numIn10 = ConvertToDifferentSystem.convertFromDiffSystemTo10(expression, systemFrom);
            return ConvertToDifferentSystem.convertToDiffSystemFrom10(numIn10, systemTo);
        }
    }


}
