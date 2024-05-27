package my.project.fullCalculator.GUI.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import my.project.fullCalculator.GUI.Constance;

public interface SettableWindowSize {
    default Scene sceneCreator(Parent root, Stage stage) {
        Scene scene = new Scene(root, Constance.windowWeight, Constance.windowHeight);
        stage.setMinHeight(Constance.minWindowHeight);
        stage.setMinWidth(Constance.minWindowWeight);
        stage.setMaxHeight(Constance.maxWindowHeight);
        stage.setMaxWidth(Constance.maxWindowWeight);
        return scene;
    }
}
