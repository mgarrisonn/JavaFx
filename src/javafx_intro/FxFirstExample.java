package javafx_intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class FxFirstExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text text = new Text("Hello JavaFx");
        VBox root = new VBox();
        root.getChildren().add(text);
        root.setMinSize(350, 250);

        Scene scene = new Scene(root);

        stage.setX(100);
        stage.setY(200);
        stage.setMinHeight(300);
        stage.setMinWidth(400);

        stage.setScene(scene);
        stage.setTitle("JavaFx Example");
        stage.show();
    }
}
