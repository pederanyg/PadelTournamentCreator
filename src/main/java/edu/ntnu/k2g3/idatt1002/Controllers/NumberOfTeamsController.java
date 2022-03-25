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
    public ChoiceBox choiceBox;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button confirm;

    @FXML
    public void initialize() {
        confirm.setDisable(true);
    }

    @FXML
    public void teamsSelected(ActionEvent e) {
        confirm.setDisable(false);
    }

    public void goToNameTeams(ActionEvent event) throws IOException {
        int numberOfTeams = Integer.parseInt((String) choiceBox.getValue());

        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/nameTeams.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        root = loader.load();

        NameTeamsController nameTeamsController = loader.getController();
        nameTeamsController.createTeamList(numberOfTeams);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }









}
