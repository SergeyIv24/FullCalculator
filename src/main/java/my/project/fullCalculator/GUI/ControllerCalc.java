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
import my.project.fullCalculator.calculators.CheckerInput;
import my.project.fullCalculator.calculators.OrdinaryCalculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCalc implements Initializable {

    @FXML
    private TextField fieldForExpression;

    @FXML
    private Label result;

    @FXML
    private MenuButton menu;

    @FXML
    protected void pressingEveryNumber(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if (btn.getId().equals(numbersId.ONE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "1");
        }

        if (btn.getId().equals(numbersId.TWO)) {
            fieldForExpression.setText(fieldForExpression.getText() + "2");
        }

        if (btn.getId().equals(numbersId.THREE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "3");
        }

        if (btn.getId().equals(numbersId.FOUR)) {
            fieldForExpression.setText(fieldForExpression.getText() + "4");
        }

        if (btn.getId().equals(numbersId.FIVE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "5");
        }

        if (btn.getId().equals(numbersId.SIX)) {
            fieldForExpression.setText(fieldForExpression.getText() + "6");
        }

        if (btn.getId().equals(numbersId.SEVEN)) {
            fieldForExpression.setText(fieldForExpression.getText() + "7");
        }

        if (btn.getId().equals(numbersId.EIGHT)) {
            fieldForExpression.setText(fieldForExpression.getText() + "8");
        }

        if (btn.getId().equals(numbersId.NINE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "9");
        }

        if (btn.getId().equals(numbersId.ZERO)) {
            fieldForExpression.setText(fieldForExpression.getText() + "0");
        }

        if (btn.getId().equals(numbersId.OPENED_BRACKET)) {
            if (fieldForExpression.getText().isEmpty()) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + ")");
        }

        if (btn.getId().equals(numbersId.CLOSED_BRACKET)) {
            fieldForExpression.setText(fieldForExpression.getText() + "(");
        }

        if (btn.getId().equals(numbersId.POINT)) {
            fieldForExpression.setText(fieldForExpression.getText() + ".");
        }

        if (btn.getId().equals(numbersId.PLUS)) {

            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "+");
        }

        if (btn.getId().equals(numbersId.MINUS)) {
            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "-");
        }

        if (btn.getId().equals(numbersId.MULTIPLICATION)) {

            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "*");
        }

        if (btn.getId().equals(numbersId.DIVISION)) {

            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "/");
        }

        if (btn.getId().equals(numbersId.SOLUTION)) {
            String exp = fieldForExpression.getText();
            result.setText(solveExp(exp));
        }


        if (btn.getId().equals(numbersId.CLEAR)) {
            fieldForExpression.setText("");
            result.setText("");
        }

        if (btn.getId().equals(numbersId.DELETE_LAST)) {
            StringBuilder stringBuilder = new StringBuilder(fieldForExpression.getText());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fieldForExpression.setText(stringBuilder.toString());
        }
    }

    private String solveExp(String exp) {
        CheckerInput.checkInput(exp);
        OrdinaryCalculator calculator = new OrdinaryCalculator(CheckerInput.convertUsualMinusToUnaryMinus(exp));
        return "" + calculator.solvePolandNotation();
    }

    private boolean isPressingProhibited(String exp) {
        return isMathOperator(exp.substring(exp.length() - 1));
    }

    private boolean isMathOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
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
    protected void goToRomanConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/poman-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image iconMenu = new Image(RomanConverterController.class.getResourceAsStream("/menu-icon.png"));
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        menu.graphicProperty().setValue(imageView);
    }
}
