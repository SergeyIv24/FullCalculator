package my.project.fullCalculator.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {
    @FXML
    private Button solveExpression;

    @FXML
    private Button converter;

    @FXML
    private Button romanConverter;

    @FXML
    protected void goToSolve(ActionEvent event) throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-expression.fxml"));
        Stage stage = (Stage) solveExpression.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @FXML
    protected void goToConverter(ActionEvent event) throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/system-converter.fxml"));
        Stage stage = (Stage) converter.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }

    @FXML
    protected void goToRomanConverter(ActionEvent event) throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/poman-converter.fxml"));
        Stage stage = (Stage) converter.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
    }
}
