package my.project.fullCalculator.GUI.controllers;

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
import my.project.fullCalculator.GUI.ConstanceId;
import my.project.fullCalculator.calculators.CheckerInput;
import my.project.fullCalculator.calculators.OrdinaryCalculator;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
        Button btn = (Button) event.getSource(); //id нажатой кнопки

        if (btn.getId().equals(ConstanceId.ONE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "1");
        }

        if (btn.getId().equals(ConstanceId.TWO)) {
            fieldForExpression.setText(fieldForExpression.getText() + "2");
        }

        if (btn.getId().equals(ConstanceId.THREE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "3");
        }

        if (btn.getId().equals(ConstanceId.FOUR)) {
            fieldForExpression.setText(fieldForExpression.getText() + "4");
        }

        if (btn.getId().equals(ConstanceId.FIVE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "5");
        }

        if (btn.getId().equals(ConstanceId.SIX)) {
            fieldForExpression.setText(fieldForExpression.getText() + "6");
        }

        if (btn.getId().equals(ConstanceId.SEVEN)) {
            fieldForExpression.setText(fieldForExpression.getText() + "7");
        }

        if (btn.getId().equals(ConstanceId.EIGHT)) {
            fieldForExpression.setText(fieldForExpression.getText() + "8");
        }

        if (btn.getId().equals(ConstanceId.NINE)) {
            fieldForExpression.setText(fieldForExpression.getText() + "9");
        }

        if (btn.getId().equals(ConstanceId.ZERO)) {
            fieldForExpression.setText(fieldForExpression.getText() + "0");
        }

        if (btn.getId().equals(ConstanceId.OPENED_BRACKET)) {
            if (fieldForExpression.getText().isEmpty()) {
                return; //Нельзя поставить открывающую скобку самым первым символом
            }
            fieldForExpression.setText(fieldForExpression.getText() + ")");
        }

        if (btn.getId().equals(ConstanceId.CLOSED_BRACKET)) {
            fieldForExpression.setText(fieldForExpression.getText() + "(");
        }

        if (btn.getId().equals(ConstanceId.POINT)) {
            fieldForExpression.setText(fieldForExpression.getText() + ".");
        }

        if (btn.getId().equals(ConstanceId.PLUS)) {
            //Если пользователь ввел первым символом +, перед + будет добавлен 0
            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "+");
        }

        if (btn.getId().equals(ConstanceId.MINUS)) {
            //Если пользователь ввел первым символом -, перед - будет добавлен 0
            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "-");
        }

        if (btn.getId().equals(ConstanceId.MULTIPLICATION)) {
            //Если пользователь ввел первым символом *, перед * будет добавлен 0
            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "*");
        }

        if (btn.getId().equals(ConstanceId.DIVISION)) {
            //Если пользователь ввел первым символом /, перед / будет добавлен 0
            if (fieldForExpression.getText().isEmpty()) {
                fieldForExpression.setText("0");
            }

            if (isPressingProhibited(fieldForExpression.getText())) {
                return;
            }
            fieldForExpression.setText(fieldForExpression.getText() + "/");
        }

        if (btn.getId().equals(ConstanceId.SOLUTION)) {
            String exp = fieldForExpression.getText();
            result.setText(solveExp(exp)); //Решение выражения
        }

        //Очистка всех полей
        if (btn.getId().equals(ConstanceId.CLEAR)) {
            fieldForExpression.setText("");
            result.setText("");
        }

        //Удаление последнего символа в поле ввода
        if (btn.getId().equals(ConstanceId.DELETE_LAST)) {
            StringBuilder stringBuilder = new StringBuilder(fieldForExpression.getText());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fieldForExpression.setText(stringBuilder.toString());
        }
    }

    //Вычисление выражения
    private String solveExp(String exp) {
        CheckerInput.checkInput(exp);
        OrdinaryCalculator calculator = new OrdinaryCalculator(CheckerInput.convertUsualMinusToUnaryMinus(exp));
        return "" + calculator.solvePolandNotation();
    }

    //Нажатие запрещено, если пользователь хочет поставить оператор после оператора
    private boolean isPressingProhibited(String exp) {
        return isMathOperator(exp.substring(exp.length() - 1));
    }

    //Является ли строка математическим оператором
    private boolean isMathOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    @FXML
    protected void goBack() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/menu-view.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void goToConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/system-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void goToRomanConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/roman-converter.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void goToSolveInDifferentSystems() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-in-diff-systems.fxml"));
        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image iconMenu =
                new Image(Objects.requireNonNull(RomanConverterController.class
                        .getResourceAsStream("/menu-icon.png"))); //Иконка для меню
        ImageView imageView = new ImageView(iconMenu);
        imageView.setFitHeight(30); //Высота иконки
        imageView.setFitWidth(30); //Ширина иконки
        menu.graphicProperty().setValue(imageView);
    }
}
