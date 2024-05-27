package my.project.fullCalculator.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import my.project.fullCalculator.GUI.controllers.SettableWindowSize;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CalculatorApp extends Application implements SettableWindowSize {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoaderMenu = new FXMLLoader(CalculatorApp.class.getResource("/menu-view.fxml")); //Загрузка XML файла
        Parent rootNode = fxmlLoaderMenu.load(); //Корневой узел
        Scene sceneMenu = sceneCreator(rootNode, stage);
        String pathToCss = "";
        try { //Путь к файлу css
            pathToCss = Objects.requireNonNull(this.getClass().getResource("/styleMenu.css")).toExternalForm();
        } catch (NullPointerException e) {
            e.getMessage();
        }
        sceneMenu.getStylesheets().add(pathToCss); //Подключение стилей
        stage.setTitle("Калькулятор"); //Заголовок окна
        InputStream iconStream = CalculatorApp.class.getResourceAsStream("/calc-icon.png");
        Image iconApp = null;
        if (iconStream != null) {
            iconApp = new Image(iconStream);
        }
        stage.getIcons().add(iconApp); //Установка иконки приложения
        stage.setScene(sceneMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}