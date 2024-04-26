package my.project.fullCalculator.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoaderMenu = new FXMLLoader(CalculatorApp.class.getResource("/menu-view.fxml")); //Загрузка XML файла
        Parent rootNode = fxmlLoaderMenu.load(); //Корневой узел
        Scene sceneMenu = new Scene(rootNode, 500, 500); // Создание сцены по корневому узлу

        String pathToCss = this.getClass().getResource("/styleMenu.css").toExternalForm();
        sceneMenu.getStylesheets().add(pathToCss);

        stage.setTitle("Калькулятор"); //Заголовок окна

        InputStream iconStream = CalculatorApp.class.getResourceAsStream("/calc-icon.png");
        Image iconApp = new Image(iconStream);
        stage.getIcons().add(iconApp);

        stage.setScene(sceneMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}