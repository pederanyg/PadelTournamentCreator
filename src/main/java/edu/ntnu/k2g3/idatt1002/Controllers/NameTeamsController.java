package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileWriter;
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

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ListView<String> listOfTeams;
    @FXML
    private Button startButton, addButton;

    @FXML
    private TextField nameTeamField;

    @FXML
    private Label teamChooser, teamNameLabel;

    @FXML
    public void initialize() {
        startButton.setVisible(false);
    }

    @FXML
    public void createTeamList(int numberOfTeams) {
        for(int i = 0; i < numberOfTeams; i++){
            choiceBox.getItems().add("Team" + (i + 1));
        }
    }

    @FXML
    public void chosenTeam() {
        nameTeamField.setText(choiceBox.getValue()); //set prompt tekst? da må man skrive navn?
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
        URL url;
        ArrayList<String> listOfTeamNames = new ArrayList<>(listOfTeams.getItems());
        PadelFileWriter.writeTeamNamesToFile("src/main/resources/edu/ntnu/k2g3/idatt1002/tournamentFiles/listOfTeamNames.txt", listOfTeamNames);

        switch (listOfTeams.getItems().size()) {
            case 4 -> url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament.fxml").toURI().toURL();

            case 8 -> url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament8.fxml").toURI().toURL();

            case 16 -> url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/tournament16.fxml").toURI().toURL();

            default -> throw new IllegalArgumentException("Number of teams are out of range.");
        }

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
