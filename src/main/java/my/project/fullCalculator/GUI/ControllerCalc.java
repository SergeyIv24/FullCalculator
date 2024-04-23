package my.project.fullCalculator.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import my.project.fullCalculator.GUI.numbersId;

import java.io.IOException;

public class ControllerCalc {

    @FXML
    private Button one;

    @FXML
    private TextField fieldForExpression;

    @FXML
    protected void pressingEveryNumber(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        System.out.println(btn.getId());

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



    }


}
