package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class NameTeamsController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] teamList;
    @FXML
    private ListView listOfTeams;
    @FXML
    private Button startButton;
    @FXML
    private Button addButton;

    @FXML
    private TextField nameTeamField;

    @FXML
    private Label teamChooser;

    @FXML
    private Label teamNameLabel;

    @FXML
    public void initialize() {
        startButton.setVisible(false);
    }

    @FXML
    public void createTeamList(int numberOfTeams) {
        this.teamList = new String[numberOfTeams];
        for(int i = 0; i < numberOfTeams; i++) {
            this.teamList[i] = ("Team " + (i + 1));
        }
        choiceBox.getItems().addAll(teamList);
    }

    @FXML
    public void chosenTeam() {
        nameTeamField.setText(choiceBox.getValue());
    }

    @FXML
    public void addTeamToListOfTeams() {
        listOfTeams.getItems().add(nameTeamField.getText());
        choiceBox.getItems().remove(choiceBox.getSelectionModel().getSelectedItem());
        if(choiceBox.getItems().size() == 0) {
            startButton.setVisible(true);
            choiceBox.setVisible(false);
            addButton.setVisible(false);
            nameTeamField.setVisible(false);
            teamNameLabel.setVisible(false);
            teamChooser.setText("All teams have been added.");

        }
    }

    @FXML
    public void goToTournament(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        root = loader.load();
        TournamentController nameTeamsController = loader.getController();
        nameTeamsController.displayTeamNames(listOfTeams.getItems());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
