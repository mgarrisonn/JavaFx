package javafx_intro;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxListViewExample extends Application {

    Label selectionLbl = new Label("Your selection: None");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<String> cars = new ListView<String>();
        cars.getItems().addAll("Ford", "Audi", "Ferrari", "Porsche");
        cars.getSelectionModel().selectFirst();
        cars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                selectionLbl.setText("Your selection: " + newValue);
            }
        });

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, cars);
        root.addRow(1, selectionLbl);
        root.setMinSize(300, 200);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A ListView Example");
        stage.show();
    }
}
