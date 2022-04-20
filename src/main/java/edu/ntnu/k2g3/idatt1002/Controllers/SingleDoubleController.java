package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SingleDoubleController {
    @FXML
    private RadioButton singlesButton, doublesButton;

    @FXML
    private Button confirm;

    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup();
        singlesButton.setToggleGroup(group);
        doublesButton.setToggleGroup(group);
        confirm.setDisable(true);
    }

    @FXML
    public void enableOkButton() {
        confirm.setDisable(false);
    }

    public void goToNumberOfTeams(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/numberOfTeams.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
