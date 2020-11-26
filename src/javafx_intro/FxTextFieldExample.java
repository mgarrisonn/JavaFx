package javafx_intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FxTextFieldExample extends Application {

    Label messageLbl = new Label("Enter your Name into the Text Fields.");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        firstNameFld.setPrefColumnCount(15);
        lastNameFld.setPrefColumnCount(15);

        firstNameFld.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e)
            {
                printMessage("You have changed the First Name!");
            }
        });

        lastNameFld.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e)
            {
                printMessage("You have changed the Last Name !");
            }
        });

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);

        root.addRow(0, messageLbl);
        root.addRow(1, new Label("First Name:"), firstNameFld);
        root.addRow(2, new Label("Last Name:"), lastNameFld);

        root.setMinSize(350, 250);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TextField Example");
        stage.show();
    }

    public void printMessage(String message) {
        messageLbl.setText(message);
    }

}
