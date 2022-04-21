package edu.ntnu.k2g3.idatt1002.Controllers;

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

public class NameTeamsController{

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
        addButton.setDisable(false);
    }

    @FXML
    public void addTeamToListOfTeams() {
        listOfTeams.getItems().add(nameTeamField.getText());
        choiceBox.getItems().remove(choiceBox.getSelectionModel().getSelectedItem());
        choiceBox.valueProperty().setValue(null);
        nameTeamField.clear();
        addButton.setDisable(true);
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
        Parent root;
        URL url;
        FXMLLoader loader;

        switch (listOfTeams.getItems().size()) {
            case 4 -> {
                url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament.fxml").toURI().toURL();
                loader = new FXMLLoader(url);
                root = loader.load();
                TournamentController nameTeamsController = loader.getController();
                nameTeamsController.displayTeamNames(listOfTeams.getItems());
            }
            case 8 -> {
                url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament8.fxml").toURI().toURL();
                loader = new FXMLLoader(url);
                root = loader.load();
            }
            case 16 -> {
                url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament16.fxml").toURI().toURL();
                loader = new FXMLLoader(url);
                root = loader.load();
            }
            default -> throw new IllegalArgumentException("Number of teams are out of range.");
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
