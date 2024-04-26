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
import my.project.fullCalculator.GUI.numbersId;
import my.project.fullCalculator.calculators.ConvertToDifferentSystem;

import java.io.IOException;
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

    @FXML
    private MenuButton menu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        factoryTo.setValue("10");
        factoryFrom.setValue("2");
        from.setValueFactory(factoryTo);
        to.setValueFactory(factoryFrom);
        Image iconMenu = new Image(RomanConverterController.class.getResourceAsStream("/menu-icon.png"));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
    }

    @FXML
    protected void pressingEveryNumber(ActionEvent event) {
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
            if (isFieldEmpty()) {
                return;
            }
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
            if (isFieldEmpty()) {
                return;
            }
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

    private boolean isFieldEmpty() {
        return fieldForConverting.getText().isEmpty();
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

    @FXML
    protected void goToSolveInDifferentSystems(ActionEvent event) throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-in-diff-systems.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }
}
