package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileReader;
import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileWriter;
import edu.ntnu.k2g3.idatt1002.Match;
import edu.ntnu.k2g3.idatt1002.Tournament;
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
import java.util.Arrays;

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

    private Tournament tournament;

    @FXML
    public void initialize() {
        rightAnchor.setDisable(true);
        leftAnchor.setDisable(true);
        finalAnchor.setVisible(false);
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
    }

    public void winnerSemi1() {
        if((setNextBracket(spinnerTeam1, spinnerTeam2, winnerBracket1, team1Label) ||
                setNextBracket(spinnerTeam2, spinnerTeam1, winnerBracket1, team2Label)) &&
               (setNextBracket(spinnerTeam3, spinnerTeam4, winnerBracket2, team3Label) ||
                setNextBracket(spinnerTeam4, spinnerTeam3, winnerBracket2, team4Label))){
            tournament.createNewMatches();
            leftAnchor.setDisable(false);
            rightAnchor.setDisable(false);
            finalAnchor.setVisible(true);}
    }

    private boolean setNextBracket(Spinner<Integer> spinner1, Spinner<Integer> spinner2, Label winnerBracket, Label teamLabel) {
        if (spinner1.getValue().equals(6)){
            tournament.getMatches().forEach(match -> {
                       if (match.getTeam1().getTeamName().equals(teamLabel.getText())){
                           match.setResult(spinner1.getValue(), spinner2.getValue(), match.getTeam1());
                       }else if (match.getTeam2().getTeamName().equals(teamLabel.getText())){
                           match.setResult(spinner2.getValue(), spinner1.getValue(), match.getTeam1());
            }});
            spinner1.setDisable(true);
            spinner2.setDisable(true);
            winnerBracket.setText(teamLabel.getText());
            return true;
        }else {return false;}
    }

    @FXML
    public void winnerFinal() {
        if(setNextBracket(winnerBracket1Spinner, winnerBracket2Spinner, winnerFinal, winnerBracket1) ||
        setNextBracket(winnerBracket2Spinner, winnerBracket1Spinner, winnerFinal, winnerBracket2)){
            finalAnchor.setVisible(true);
            setWinner();
        }
    }

    private void setWinner(){
        leftAnchor.setDisable(true);
        rightAnchor.setDisable(true);
        winnerDisplay.setVisible(true);
        winnerDisplay.setText(winnerFinal.getText() + " is the winning team!");
        exitTournament.setVisible(true);
        tournament.getMatches().forEach(System.out::println);
    }

    public void setTournament(Tournament tournament){
        this.tournament = tournament;
        displayTeamNames();
    }

    @FXML
    public void displayTeamNames() {
        tournament.createNewMatches();
        Label[] labels = {team1Label, team2Label, team3Label, team4Label};
        ArrayList<String> listOfNames2 = new ArrayList<>();
        for (Match match : tournament.getMatches()) {
            listOfNames2.add(match.getTeam1().getTeamName());
            listOfNames2.add(match.getTeam2().getTeamName());
        }
        int i = 0;
        for (Label label: labels) {
            label.setText(listOfNames2.get(i));
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