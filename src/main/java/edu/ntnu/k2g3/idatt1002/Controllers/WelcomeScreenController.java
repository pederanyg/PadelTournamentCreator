package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Welcome screen controller.
 */
public class WelcomeScreenController {

    /**
     * Go to next stage singels or doubles.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void goToSinglesDoubles(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/single-double.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Exit the program.
     */
    public void exitProgram() {
        System.exit(0);
    }
}
