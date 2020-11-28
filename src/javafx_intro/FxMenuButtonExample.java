package javafx_intro;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxMenuButtonExample extends Application {

    Label messageLbl = new Label("Choose your car!");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MenuItem ford = new MenuItem("Ford");
        ford.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                printMessage("You have selected: Ford");
            }
        });

        MenuItem audi = new MenuItem("Audi");
        audi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have selected: Audi");
            }
        });

        MenuItem ferrari = new MenuItem("Ferrari");
        ferrari.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have selected: Ferrari");
            }
        });

        MenuItem porsche = new MenuItem("Porsche");
        porsche.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                printMessage("You have selected: Porsche");
            }
        });

        MenuButton cars = new MenuButton("Select");
        cars.getItems().addAll(ford, audi, ferrari, porsche);

        VBox root = new VBox();
        root.getChildren().addAll(cars, messageLbl);
        root.setMinSize(350, 250);


        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A MenuButton Example");
        stage.show();
    }

    public void printMessage(String message) {
        messageLbl.setText(message);
    }
}




