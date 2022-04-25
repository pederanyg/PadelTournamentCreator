package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileReader;
import edu.ntnu.k2g3.idatt1002.Match;
import edu.ntnu.k2g3.idatt1002.Tournament;
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

public class Tournament8Controller extends TournamentController {
    @FXML
    private Spinner<Integer> spinnerTeam1, spinnerTeam2, spinnerTeam3, spinnerTeam4;
    @FXML
    private Spinner<Integer> spinnerTeam5, spinnerTeam6, spinnerTeam7, spinnerTeam8;
    @FXML
    private Spinner<Integer> bracket1Spinner, bracket2Spinner, bracket3Spinner, bracket4Spinner;
    @FXML
    private Spinner<Integer> finalist1Spinner, finalist2Spinner;

    @FXML
    private Label team1Label, team2Label, team3Label, team4Label;
    @FXML
    private Label team5Label, team6Label, team7Label, team8Label;
    @FXML
    private Label winnerBracket1, winnerBracket2, winnerBracket3, winnerBracket4;
    @FXML
    private Label finalist1, finalist2;
    @FXML
    private Label winnerDisplay, winnerFinal;

    @FXML
    private AnchorPane leftUpAnchor1, leftLowerAnchor1, leftAnchor2;

    @FXML
    private AnchorPane rightUpAnchor1, rightLowerAnchor1, rightAnchor2;

    @FXML
    private AnchorPane finalMatchAnchor, finalAnchor;

    @FXML
    private Button exitTournament, saveResult;


    @FXML
    public void initialize() {
        leftAnchor2.setDisable(true);
        rightAnchor2.setDisable(true);
        finalMatchAnchor.setDisable(true);
        finalAnchor.setDisable(true);
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
        saveResult.setVisible(false);
    }

    @FXML
    public void displayNames() {
        getTournament().createNewMatches();
        Label[] labels = {team1Label,team2Label, team3Label,team4Label,team5Label,team6Label,team7Label,team8Label};
        int i = 0;
        for (Label label: labels) {
            label.setText(getListOfNames().get(i));
            i++;
        }
    }

    @FXML
    public void setRoundTwo(){
        if (checkAllBracketsRound1()){
            getTournament().createNewMatches();
            rightLowerAnchor1.setDisable(true);
            rightUpAnchor1.setDisable(true);
            leftLowerAnchor1.setDisable(true);
            leftUpAnchor1.setDisable(true);

            leftAnchor2.setDisable(false);
            rightAnchor2.setDisable(false);
        }}

    @FXML
    public void setFinalRound(){
        if (checkALlBracketsRound2()){
            getTournament().createNewMatches();
            finalMatchAnchor.setDisable(false);
            leftAnchor2.setDisable(true);
            rightAnchor2.setDisable(true);
        }
    }

    @FXML
    public void setWinner(){
        if (setNextBracket(finalist1Spinner, finalist2Spinner, winnerFinal, finalist1) ||
                setNextBracket(finalist2Spinner, finalist1Spinner, winnerFinal, finalist2)){
        finalMatchAnchor.setDisable(true);
        finalAnchor.setDisable(false);
        saveResult.setVisible(true);
        setWinner(winnerDisplay, winnerFinal, exitTournament);
        }
    }


    private boolean checkAllBracketsRound1(){
        boolean one = setNextBracket(spinnerTeam1, spinnerTeam2, winnerBracket1, team1Label) ||
                setNextBracket(spinnerTeam2, spinnerTeam1, winnerBracket1, team2Label);
        boolean two = setNextBracket(spinnerTeam3, spinnerTeam4, winnerBracket2, team3Label) ||
                setNextBracket(spinnerTeam4, spinnerTeam3, winnerBracket2, team4Label);
        boolean three = setNextBracket(spinnerTeam5, spinnerTeam6, winnerBracket3, team5Label) ||
                setNextBracket(spinnerTeam6, spinnerTeam5, winnerBracket3,team6Label);
        boolean four = setNextBracket(spinnerTeam7, spinnerTeam8, winnerBracket4, team7Label) ||
                setNextBracket(spinnerTeam8, spinnerTeam7,winnerBracket4, team8Label);

        return one && two && three && four;
    }

    private boolean checkALlBracketsRound2(){
        boolean one = setNextBracket(bracket1Spinner, bracket2Spinner, finalist1, winnerBracket1) ||
                setNextBracket(bracket2Spinner, bracket1Spinner, finalist1, winnerBracket2);
        boolean two = setNextBracket(bracket3Spinner, bracket4Spinner, finalist2, winnerBracket3) ||
                setNextBracket(bracket4Spinner, bracket3Spinner, finalist2, winnerBracket4);

        return one && two;
    }
}
