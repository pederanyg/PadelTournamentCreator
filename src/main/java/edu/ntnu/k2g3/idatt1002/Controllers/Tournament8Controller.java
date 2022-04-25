package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileReader;
import edu.ntnu.k2g3.idatt1002.Tournament;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Tournament8Controller {
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
    private Line line1Bracket1, line2Bracket1;
    @FXML
    private Line line1Bracket2, line2Bracket2;
    @FXML
    private Line line1Bracket3, line2Bracket3;
    @FXML
    private Line line1Bracket4, line2Bracket4;
    @FXML
    private Line finalist1Line, finalist2Line;
    @FXML
    private Line winnerLine;

    @FXML
    private AnchorPane anchorLeftUpperCorner, anchorRightUpperCorner, anchorLeftLowerCorner, anchorRightLowerCorner;
    @FXML
    private AnchorPane firstRightAnchor, firstLeftAnchor, anchorFinalLeft, anchorFinalRight, finalAnchor;

    @FXML
    private Button exitTournament;

    private Tournament tournament;

    public void setTournament(Tournament tournament){
        this.tournament = tournament;
    }

    @FXML
    public void initialize() {
        displayTeamNames();
        anchorLeftLowerCorner.setVisible(false);
        anchorRightLowerCorner.setVisible(false);
        anchorLeftUpperCorner.setVisible(false);
        anchorRightUpperCorner.setVisible(false);
        anchorFinalLeft.setVisible(false);
        anchorFinalRight.setVisible(false);
        finalAnchor.setVisible(false);
    }

    @FXML
    public void displayTeamNames() {
        ArrayList<String> listOfNames = PadelFileReader.readTeamNames("src/main/resources/edu/ntnu/k2g3/idatt1002/tournamentFiles/listOfTeamNames.txt");
        Label[] labels = {team1Label,team2Label, team3Label,team4Label,team5Label,team6Label,team7Label,team8Label};
        int i = 0;
        for (Label label: labels) {
            label.setText(listOfNames.get(i));
            i++;
        }
    }

    private boolean setNextMatch(Spinner<Integer> spinner, Label winner, Label nextBracket){
        if (spinner.getValue() >= 6){
            nextBracket.setText(winner.getText());
            return true;
        }else{return false;}
    }

    @FXML
    public void decideWinnerBracket1() {
        if (setNextMatch(spinnerTeam1, team1Label, winnerBracket1) || setNextMatch(spinnerTeam2, team2Label, winnerBracket1)){
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }/*
        if(spinnerTeam1.getValue().equals(6)) {

            winnerBracket1.setText(team1Label.getText());
            winnerBracket1.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
            bracket1Spinner.setVisible(true);
        } else if(spinnerTeam2.getValue().equals(6)) {
            winnerBracket1.setText(team2Label.getText());
            winnerBracket1.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
            bracket1Spinner.setVisible(true);*/

    }

    @FXML
    public void decideWinnerBracket2() {
        if (setNextMatch(spinnerTeam3, team3Label, winnerBracket2) || setNextMatch(spinnerTeam4, team4Label, winnerBracket2)) {
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }
        /*if(spinnerTeam3.getValue().equals(6)) {
            winnerBracket2.setText(team3Label.getText());
            winnerBracket2.setVisible(true);
            spinnerTeam4.setDisable(true);
            spinnerTeam3.setDisable(true);
            bracket2Spinner.setVisible(true);
        } else if(spinnerTeam4.getValue().equals(6)) {
            winnerBracket2.setText(team4Label.getText());
            winnerBracket2.setVisible(true);
            spinnerTeam4.setDisable(true);
            spinnerTeam3.setDisable(true);
            bracket2Spinner.setVisible(true);*/

    }

    @FXML
    public void decideWinnerBracket3() {

        if (setNextMatch(spinnerTeam5, team5Label, winnerBracket3) || setNextMatch(spinnerTeam7, team7Label, winnerBracket3)) {
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }
        /*if(spinnerTeam5.getValue().equals(6)) {
            winnerBracket3.setText(team5Label.getText());
            winnerBracket3.setVisible(true);
            spinnerTeam7.setDisable(true);
            spinnerTeam5.setDisable(true);
            bracket3Spinner.setVisible(true);
        } else if(spinnerTeam7.getValue().equals(6)) {
            winnerBracket3.setText(team6Label.getText());
            winnerBracket3.setVisible(true);
            spinnerTeam7.setDisable(true);
            spinnerTeam5.setDisable(true);
            bracket3Spinner.setVisible(true);
        }*/
    }

    @FXML
    public void decideWinnerBracket4() {
        if (setNextMatch(spinnerTeam6, team6Label, winnerBracket4) || setNextMatch(spinnerTeam8, team8Label, winnerBracket4)) {
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }
        /*if(spinnerTeam6.getValue().equals(6)) {
            winnerBracket4.setText(team7Label.getText());
            winnerBracket4.setVisible(true);
            spinnerTeam8.setDisable(true);
            spinnerTeam6.setDisable(true);
            bracket4Spinner.setVisible(true);
        } else if(spinnerTeam8.getValue().equals(6)) {
            winnerBracket4.setText(team8Label.getText());
            winnerBracket4.setVisible(true);
            spinnerTeam8.setDisable(true);
            spinnerTeam6.setDisable(true);
            bracket4Spinner.setVisible(true);
        }*/
    }

    @FXML
    public void decideWinnerSemi1() {
        if (setNextMatch(bracket1Spinner, winnerBracket1, finalist1) || setNextMatch(bracket3Spinner, winnerBracket3, finalist1)) {
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }/*
        if(bracket1Spinner.getValue().equals(6)) {
            finalist1.setText(winnerBracket1.getText());
            finalist1.setVisible(true);
            bracket1Spinner.setDisable(true);
            bracket3Spinner.setDisable(true);
            finalist1Spinner.setVisible(true);
            line1Bracket1.setVisible(true);
            line2Bracket1.setVisible(true);
        } else if(bracket3Spinner.getValue().equals(6)) {
            finalist1.setText(winnerBracket3.getText());
            finalist1.setVisible(true);
            bracket1Spinner.setDisable(true);
            bracket3Spinner.setDisable(true);
            finalist1Spinner.setVisible(true);
            line1Bracket3.setVisible(true);
            line2Bracket3.setVisible(true);
        }*/
    }

    @FXML
    public void decideWinnerSemi2() {
        if (setNextMatch(bracket2Spinner, winnerBracket2, finalist2) || setNextMatch(bracket4Spinner, winnerBracket4, finalist2)) {
            anchorLeftUpperCorner.setVisible(true);
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
        }/*
        if(bracket2Spinner.getValue().equals(6)) {
            finalist2.setText(winnerBracket2.getText());
            finalist2.setVisible(true);
            bracket2Spinner.setDisable(true);
            bracket4Spinner.setDisable(true);
            finalist2Spinner.setVisible(true);
            line1Bracket2.setVisible(true);
            line2Bracket2.setVisible(true);
        } else if(bracket4Spinner.getValue().equals(6)) {
            finalist2.setText(winnerBracket4.getText());
            finalist2.setVisible(true);
            bracket2Spinner.setDisable(true);
            bracket4Spinner.setDisable(true);
            finalist2Spinner.setVisible(true);
            line1Bracket4.setVisible(true);
            line2Bracket4.setVisible(true);
        }*/
    }

    @FXML
    public void decideWinnerFinal() {
        if(finalist1Spinner.getValue().equals(6)){
            finalist1Line.setVisible(true);
            winnerLine.setVisible(true);
            winnerFinal.setText(finalist1.getText());
            winnerFinal.setVisible(true);
            winnerDisplay.setVisible(true);
            winnerDisplay.setText(finalist1.getText() + " is the winning team!");
            exitTournament.setVisible(true);
            finalist1Spinner.setDisable(true);
            finalist2Spinner.setDisable(true);
        } else if(finalist2Spinner.getValue().equals(6)){
            finalist2Line.setVisible(true);
            winnerLine.setVisible(true);
            winnerFinal.setText(winnerBracket2.getText());
            winnerFinal.setVisible(true);
            winnerDisplay.setVisible(true);
            winnerDisplay.setText(winnerBracket2.getText() + " is the winning team!");
            exitTournament.setVisible(true);
            finalist1Spinner.setDisable(true);
            finalist2Spinner.setDisable(true);
        }
    }
}
