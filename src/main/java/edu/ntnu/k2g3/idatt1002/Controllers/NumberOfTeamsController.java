package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class NumberOfTeamsController {
    @FXML
    public ChoiceBox<Integer> choiceBox;
    @FXML
    private Button confirm;

    @FXML
    public void initialize() {
        choiceBox.getItems().setAll(2,4,8,16);
        confirm.setDisable(true);
    }

    @FXML
    public void teamsSelected() {
        confirm.setDisable(false);
    }

    public void goToNameTeams(ActionEvent event) throws IOException {
        int numberOfTeams = choiceBox.getValue();

        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/nameTeams.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        NameTeamsController nameTeamsController = loader.getController();
        nameTeamsController.createTeamList(numberOfTeams);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }









}
