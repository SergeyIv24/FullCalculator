module my.project.fullCalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens my.project.fullCalculator to javafx.fxml;
    exports my.project.fullCalculator;
    exports my.project.fullCalculator.GUI;
    opens my.project.fullCalculator.GUI to javafx.fxml;
    exports my.project.fullCalculator.exception;
    opens my.project.fullCalculator.exception to javafx.fxml;
    exports my.project.fullCalculator.calculators;
    opens my.project.fullCalculator.calculators to javafx.fxml;
}