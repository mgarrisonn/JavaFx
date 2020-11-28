package javafx_intro;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxCheckboxExample extends Application {

    Label selectionMsg = new Label("Choose your Car");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckBox fordCbx = new CheckBox("Ford");
        // Create a CheckBox to support three states
        CheckBox audiCbx = new CheckBox("Audi");
        audiCbx.setAllowIndeterminate(true);

        fordCbx.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, final Boolean value, final Boolean newValue) {
                if (newValue != null && newValue) {
                    printMessage("Your Selection: Ford");
                }
            }
        });

        audiCbx.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, final Boolean value, final Boolean newValue) {
                if (newValue != null && newValue) {
                    printMessage("Your Selection: Audi");
                }
            }
        });

        audiCbx.indeterminateProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, final Boolean value, final Boolean newValue) {
                if (newValue != null && newValue) {
                    printMessage("Your indeterminate Selection: Audi");
                }
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(selectionMsg, fordCbx, audiCbx);
        root.setSpacing(20);
        root.setMinSize(350, 250);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A CheckBox Example");
        stage.show();
    }

    public void printMessage(String message) {
        selectionMsg.setText(message);
    }
}
