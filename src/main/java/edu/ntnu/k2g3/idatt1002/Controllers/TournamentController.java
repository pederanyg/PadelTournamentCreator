package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileReader;
import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileWriter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TournamentController {
    @FXML
    private Spinner<Integer> spinnerTeam1, spinnerTeam2, spinnerTeam3, spinnerTeam4;
    @FXML
    private Spinner<Integer> winnerBracket1Spinner, winnerBracket2Spinner;
    @FXML
    private Label team1Label, team2Label, team3Label, team4Label;
    @FXML
    private Label winnerBracket1, winnerBracket2;
    @FXML
    private Label winnerFinal, winnerDisplay;
    @FXML
    private Button exitTournament;
    @FXML
    private AnchorPane rightAnchor, leftAnchor, finalAnchor;

    @FXML
    public void initialize() {
        rightAnchor.setVisible(false);
        leftAnchor.setVisible(false);
        finalAnchor.setVisible(false);
        displayTeamNames();
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
    }

    @FXML
    public void winnerSemi1() {
        if (spinnerTeam1.getValue().equals(6)){
            setFinalMatch(spinnerTeam1, spinnerTeam2, winnerBracket1, team1Label);
            leftAnchor.setVisible(true);
        }else if(spinnerTeam2.getValue().equals(6)){
            setFinalMatch(spinnerTeam1, spinnerTeam2, winnerBracket1, team2Label);
            leftAnchor.setVisible(true);
    }}

    @FXML
    public void winnerSemi2() {
        if (spinnerTeam3.getValue().equals(6)){
            setFinalMatch(spinnerTeam3, spinnerTeam4, winnerBracket2, team3Label);
            rightAnchor.setVisible(true);
        }else if (spinnerTeam4.getValue().equals(6)){
            setFinalMatch(spinnerTeam3, spinnerTeam4, winnerBracket2, team4Label);
            rightAnchor.setVisible(true);
    }}

    private void setFinalMatch(Spinner<Integer> spinnerOne, Spinner<Integer> spinnerTwo, Label winnerBracket, Label teamLabel) {
            spinnerOne.setDisable(true);
            spinnerTwo.setDisable(true);
            winnerBracket.setText(teamLabel.getText());
    }

    @FXML
    public void winnerFinal() {
        if(winnerBracket1Spinner.getValue().equals(6)){
            setWinner(winnerBracket1);

        } else if(winnerBracket2Spinner.getValue().equals(6)){
            setWinner(winnerBracket2);
        }
    }

    private void setWinner(Label label){
        leftAnchor.setDisable(true);
        rightAnchor.setDisable(true);
        finalAnchor.setVisible(true);
        winnerFinal.setText(label.getText());
        winnerDisplay.setVisible(true);
        winnerDisplay.setText(label.getText() + " is the winning team!");
        exitTournament.setVisible(true);
    }

    @FXML
    public void displayTeamNames() {
        ArrayList<String> listOfNames = PadelFileReader.readTeamNames("src/main/resources/edu/ntnu/k2g3/idatt1002/tournamentFiles/listOfTeamNames.txt");
        Label[] labels = {team1Label,team2Label, team3Label,team4Label};
        int i = 0;
        for (Label label: labels) {
            label.setText(listOfNames.get(i));
            i++;
        }
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/welcomescreen.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}