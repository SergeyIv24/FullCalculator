package my.project.fullCalculator.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import my.project.fullCalculator.calculators.CheckerInput;
import my.project.fullCalculator.calculators.OrdinaryCalculator;

import java.io.IOException;

public class ControllerCalc {

    @FXML
    private TextField fieldForExpression;

    @FXML
    private Label result;

    @FXML
    protected void pressingEveryNumber(ActionEvent event) throws IOException {
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
            fieldForExpression.setText(fieldForExpression.getText() + ")");
        }

        if (btn.getId().equals(numbersId.CLOSED_BRACKET)) {
            fieldForExpression.setText(fieldForExpression.getText() + "(");
        }

        if (btn.getId().equals(numbersId.PLUS)) {
            fieldForExpression.setText(fieldForExpression.getText() + "+");
        }

        if (btn.getId().equals(numbersId.MINUS)) {
            fieldForExpression.setText(fieldForExpression.getText() + "-");
        }

        if (btn.getId().equals(numbersId.MULTIPLICATION)) {
            fieldForExpression.setText(fieldForExpression.getText() + "*");
        }

        if (btn.getId().equals(numbersId.DIVISION)) {
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

}
