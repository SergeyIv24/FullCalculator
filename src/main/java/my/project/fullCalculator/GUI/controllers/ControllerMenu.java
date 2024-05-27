package my.project.fullCalculator.GUI.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu implements SettableWindowSize {
    @FXML
    private Button solveExpression;

    @FXML
    private Button converter;

    @FXML
    private Button romanConverter;

    @FXML
    private Button solveInDifferentSystems;

    @FXML
    protected void goToSolve() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-expression.fxml"));
        Stage stage = (Stage) solveExpression.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goToConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/system-converter.fxml"));
        Stage stage = (Stage) converter.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goToRomanConverter() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/roman-converter.fxml"));
        Stage stage = (Stage) romanConverter.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }

    @FXML
    protected void goToSolveInDifferentSystems() throws IOException {
        FXMLLoader loaderNextScene = new FXMLLoader(this.getClass().getResource("/solve-in-diff-systems.fxml"));
        Stage stage = (Stage) solveInDifferentSystems.getScene().getWindow();
        Parent root = loaderNextScene.load();
        Scene scene = sceneCreator(root, stage);
        stage.setScene(scene);
    }
}
