package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ControllerHelp {

    @FXML private ImageView imgView;

    @FXML void initialize() throws FileNotFoundException {
        InputStream stream = new FileInputStream("cheatsheet.png");
        Image image = new Image(stream);
        imgView.setImage(image);
    }

    @FXML void back() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/viewMain.fxml"));
        App.setScene(parent);
    }
}
