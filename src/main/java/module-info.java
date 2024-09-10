module my.project.fullCalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports my.project.fullCalculator.GUI;
    opens my.project.fullCalculator.GUI to javafx.fxml;
    exports my.project.fullCalculator.exception;
    opens my.project.fullCalculator.exception to javafx.fxml;
    exports my.project.fullCalculator.calculators;
    opens my.project.fullCalculator.calculators to javafx.fxml;
    exports my.project.fullCalculator.GUI.controllers;
    opens my.project.fullCalculator.GUI.controllers to javafx.fxml;
    exports my.project.fullCalculator.consoleGUI;
    opens my.project.fullCalculator.consoleGUI to javafx.fxml;
    exports my.project.fullCalculator;
    opens my.project.fullCalculator to javafx.fxml;
}

