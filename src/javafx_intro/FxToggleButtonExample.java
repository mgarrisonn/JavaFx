package javafx_intro;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxToggleButtonExample extends Application {

    Label selectionMsg = new Label("Your selection: None");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ToggleButton fordBtn = new ToggleButton("Ford");
        ToggleButton audiBtn = new ToggleButton("Audi");
        ToggleButton ferrariBtn = new ToggleButton("Ferrari");
        ToggleButton porscheBtn = new ToggleButton("Porsche");

        final ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(fordBtn, audiBtn, ferrariBtn, porscheBtn);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                final Toggle toggle, final Toggle new_toggle) {
                String toggleBtn = ((ToggleButton) new_toggle).getText();
                selectionMsg.setText("Your selection: " + toggleBtn);
            }
        });

        Label selectLbl = new Label("Select the car you like:");

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(fordBtn, audiBtn, ferrariBtn, porscheBtn);
        buttonBox.setSpacing(10);

        VBox root = new VBox();
        root.getChildren().addAll(selectionMsg, selectLbl, buttonBox);
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
        stage.setTitle("A ToggleButton Example");
        stage.show();
    }

}

