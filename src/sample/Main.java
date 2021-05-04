package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.App;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        App.setStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("/view/viewMain.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Checker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
