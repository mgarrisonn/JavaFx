package javafx_intro;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxComboBoxExample extends Application {

    Label selectionLbl = new Label("Your selection: None");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label carLbl = new Label("Car:");

        ComboBox<String> cars = new ComboBox<>();
        cars.getItems().addAll("Ford", "Audi", "Ferrari", "Porsche");
        cars.getSelectionModel().selectFirst();

        cars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                selectionLbl.setText("Your selection: " + newValue);
            }
        });

        HBox carbox = new HBox();
        carbox.getChildren().addAll(carLbl, cars);
        carbox.setSpacing(10);

        VBox root = new VBox();
        root.getChildren().addAll(carbox, selectionLbl);
        root.setSpacing(10);
        root.setMinSize(350, 250);


        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A ComboBox Example");
        stage.show();
    }
}
