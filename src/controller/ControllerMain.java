package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.App;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerMain {

    @FXML private TextField fieldRegularExpression;
    @FXML private TextArea areaTestString;
    @FXML private Label labelStatus;
    @FXML private ToggleGroup groupCase;
    @FXML private RadioButton radioSensitive;
    @FXML private RadioButton radioInsensitive;

    private static Color ERROR = Color.rgb(255, 0, 0);
    private static Color SUCCESS = Color.rgb(0, 255, 0);

    private void setStatus(Color color, String message) {
        labelStatus.setText(message);
        labelStatus.setTextFill(color);

        // Tomas Mikula https://stackoverflow.com/a/24025508/14409632
        new Timeline(
                new KeyFrame(Duration.millis(2500), l -> labelStatus.setText(""))
        ).play();
    }

    private boolean validate(String regularExpression) {
        if (regularExpression == null || regularExpression.length() == 0) {
            setStatus(ERROR, "Enter regular expression");
            return false;
        } else {
            labelStatus.setText("");
            return true;
        }
    }

    @FXML void help() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/viewHelp.fxml"));
        App.setScene(parent);
    }

    @FXML void clean() {
        String testString = areaTestString.getText();
        testString = testString.trim().replaceAll("[^\\x00-\\xFF]", " ");
        areaTestString.setText(testString);
    }

    @FXML void check() {
        String regularExpression = fieldRegularExpression.getText();
        String testString = areaTestString.getText();

        if (validate(regularExpression)) {

            Pattern pattern;
            if (radioSensitive.isSelected()) {
                pattern = Pattern.compile(regularExpression);
            } else {
                pattern = Pattern.compile(regularExpression, Pattern.CASE_INSENSITIVE);
            }
            Matcher matcher = pattern.matcher(testString);

            if (matcher.find()) {
                setStatus(SUCCESS, "OK");
            } else {
                setStatus(ERROR, "NO");
            }

        }
    }
}
