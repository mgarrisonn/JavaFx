package javafx_intro;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxButtonExample extends Application {

    Label messageLbl = new Label("Press any Button to see the message");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button newBtn = new Button("_New");
        newBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have pressed the new Button");
            }
        });

        Button saveBtn = new Button("_Save");
        saveBtn.setDefaultButton(true);
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have pressed the save Button");
            }
        });

        Button cancelBtn = new Button("_Cancel");
        cancelBtn.setCancelButton(true);
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have pressed the cancel Button");
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(newBtn, saveBtn, cancelBtn);
        buttonBox.setSpacing(15);

        VBox root = new VBox();
        root.getChildren().addAll(messageLbl, buttonBox);
        root.setSpacing(15);
        root.setMinSize(350, 250);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Button Example");
        stage.show();
    }

    public void printMessage(String message) {
        messageLbl.setText(message);
    }
}

