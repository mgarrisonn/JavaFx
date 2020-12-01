package javafx_intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxChoiceBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label carLbl = new Label("Car:");

        ChoiceBox<String> cars = new ChoiceBox<>();
        cars.getItems().addAll("Ford", "Audi", "Ferrari", "Porsche");

        Label selectionMsgLbl = new Label("Your selection:");

        Label selectedValueLbl = new Label();
        selectedValueLbl.textProperty().bind(cars.valueProperty());

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);

        root.addRow(0, carLbl, cars);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);

        root.setMinSize(350, 250);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A ChoiceBox Example");
        stage.show();
    }
}
