package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;


public class Tournament4Controller extends TournamentController {
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
    private Button exitTournament, saveResult;
    @FXML
    private AnchorPane rightAnchor, leftAnchor, finalAnchor;


    @FXML
    public void initialize() {
        rightAnchor.setDisable(true);
        leftAnchor.setDisable(true);
        finalAnchor.setVisible(false);
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
        saveResult.setVisible(false);
    }

    public void winnerSemi1() {
        if(checkAllBrackets()){
            getTournament().createNewMatches();
            leftAnchor.setDisable(false);
            rightAnchor.setDisable(false);
            finalAnchor.setVisible(true);}
    }

    private boolean checkAllBrackets(){
       return (setNextBracket(spinnerTeam1, spinnerTeam2, winnerBracket1, team1Label) ||
                setNextBracket(spinnerTeam2, spinnerTeam1, winnerBracket1, team2Label)) &&
                (setNextBracket(spinnerTeam3, spinnerTeam4, winnerBracket2, team3Label) ||
                        setNextBracket(spinnerTeam4, spinnerTeam3, winnerBracket2, team4Label));
    }


    @FXML
    public void winnerFinal() {
        if(setNextBracket(winnerBracket1Spinner, winnerBracket2Spinner, winnerFinal, winnerBracket1) ||
        setNextBracket(winnerBracket2Spinner, winnerBracket1Spinner, winnerFinal, winnerBracket2)){
            finalAnchor.setVisible(true);
            leftAnchor.setDisable(true);
            rightAnchor.setDisable(true);
            saveResult.setVisible(true);
            setWinner(winnerDisplay, winnerFinal, exitTournament);
        }
    }


    @FXML
    public void displayNames() {
        getTournament().createNewMatches();
        Label[] labels = {team1Label, team2Label, team3Label, team4Label};
        int i = 0;
        for (Label label: labels) {
            label.setText(getListOfNames().get(i));
            i++;
        }
    }


}