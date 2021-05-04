package model;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class App {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    public static void setScene(Parent parent) {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }


}
