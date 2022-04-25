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
import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Tournament16Controller {
    @FXML
    public Spinner spinnerRoundOf16nr2;
    public Spinner spinnerRoundOf16nr6;
    public Spinner spinnerRoundOf16nr1;
    public Spinner spinnerRoundOf16nr5;
    public Spinner spinnerQuarter1;
    public Spinner spinnerQuarter3;
    public Spinner spinnerRoundOf16nr3;
    public Spinner spinnerRoundOf16nr4;
    public Spinner spinnerRoundOf16nr8;
    public Spinner spinnerRoundOf16nr7;
    public Spinner spinnerQuarter2;
    public Spinner spinnerQuarter4;
    public Spinner winnerBracket1Spinner1;
    public Spinner winnerBracket2Spinner;
    public Spinner spinnerTeam2;
    public Spinner spinnerTeam3;
    public Spinner spinnerTeam4;
    public Spinner spinnerTeam7;
    public Spinner spinnerTeam8;
    public Spinner spinnerTeam5;
    public Spinner spinnerTeam6;
    public Spinner spinnerTeam10;
    public Spinner spinnerTeam9;
    public Spinner spinnerTeam12;
    public Spinner spinnerTeam11;
    public Spinner spinnerTeam14;
    public Spinner spinnerTeam13;
    public Spinner spinnerTeam16;
    public Spinner spinnerTeam15;
    public Spinner spinnerTeam1;
    @FXML
    public Label winnerRound16nr6;
    public Label winnerRound16nr5;
    public Label winnerRound16nr2;
    public Label winnerRound16nr1;
    public Label winnerQuarter1;
    public Label winnerQuarter3;
    public Label winnerFinal;
    public Label winnerDisplay;
    public Label winnerRound16nr4;
    public Label winnerRound16nr3;
    public Label winnerRound16nr8;
    public Label winnerRound16nr7;
    public Label winnerQuarter2;
    public Label winnerQuarter4;
    public Label winnerSem1;
    public Label winnerSemi2;
    public Label team1, team2,team3, team4, team5, team6, team7, team8;
    public Label team9, team10, team11, team12, team13, team14, team15, team16;
    @FXML
    public Line line1winner1;
    public Line line1winner3;
    public Line line1winner7;
    public Line line1winner6;
    public Line line2winner3;
    public Line line2winner1;
    public Line line2winner7;
    public Line line1winner2;
    public Line finalWinnerLine2;
    public Line line2winner6;
    public Line line1winner4;
    public Line line2winner4;
    public Line line2winner5;
    public Line line1winner5;
    public Line line1winner9;
    public Line line2winner9;
    public Line line1winner10;
    public Line line2winner10;
    public Line line2winner2;
    public Line line1winner8;
    public Line line2winner8;
    public Line line1winner11;
    public Line line2winner11;
    public Line finalWinnerLine1;
    public Line line1winner12;
    public Line line2winner12;
    public Button exitTournament;


    private Tournament tournament;

    public void setTournament(Tournament tournament){
        this.tournament = tournament;
    }

    public void initialize() {
        exitTournament.setVisible(false);
        for (Line line : Arrays.asList(line1winner1,line2winner1,line1winner2, line2winner2, line1winner3,line2winner3,line1winner4,
                line2winner4, line1winner5, line2winner5, line1winner6, line2winner6,line1winner7, line2winner7,line1winner8,line2winner8, line1winner9,
                line2winner9,line1winner10, line2winner10, line1winner11, line2winner11, line1winner12, line2winner12, finalWinnerLine1, finalWinnerLine2)) {
            line.setVisible(false);
        }
        for (Label label : Arrays.asList(winnerQuarter1, winnerQuarter2,winnerQuarter3,
                winnerQuarter4, winnerSem1, winnerSemi2, winnerFinal)) {
            label.setVisible(false);
        }
        for(Spinner spinner : Arrays.asList(spinnerRoundOf16nr1, spinnerRoundOf16nr2, spinnerRoundOf16nr3, spinnerRoundOf16nr4, spinnerRoundOf16nr5
        , spinnerRoundOf16nr6, spinnerRoundOf16nr7, spinnerRoundOf16nr8, spinnerQuarter1,spinnerQuarter2, spinnerQuarter3, spinnerQuarter4,
                winnerBracket1Spinner1, winnerBracket2Spinner)) {
            spinner.setVisible(false);
        }
    }

    @FXML
    public void displayTeamNames() {
        ArrayList<String> listOfNames = PadelFileReader.readTeamNames("src/main/resources/edu/ntnu/k2g3/idatt1002/tournamentFiles/listOfTeamNames.txt");
        Label[] labels = {team1, team2, team3, team4, team5, team6, team7, team8, team9, team10, team11, team12, team13, team14, team15, team16};
        int i = 0;
        for (Label label: labels) {
            label.setText(listOfNames.get(i));
            i++;
        }
    }

    private boolean setNextBracket(Spinner<Integer> spinner1, Spinner<Integer> spinner2, Label winnerBracket, Label teamLabel) {
        if (spinner1.getValue().equals(6)){
            spinner1.setDisable(true);
            spinner2.setDisable(true);
            winnerBracket.setText(teamLabel.getText());
            return true;
        }else return false;
    }


    public void setWinnerRound16nr1() {


        /*
        if (spinnerTeam1.getValue().equals(6)) {
            spinnerTeam2.setDisable(true);
            spinnerTeam1.setDisable(true);
            line1winner1.setVisible(true);
            line2winner1.setVisible(true);
            spinnerRoundOf16nr1.setVisible(true);
            winnerRound16nr1.setText(team1.getText());
            winnerRound16nr1.setVisible(true);
            winnerQuarter1.setVisible(true);
        } else if (spinnerTeam2.getValue().equals(6)) {
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
            spinnerRoundOf16nr1.setVisible(true);
            line1winner1.setVisible(true);
            line2winner1.setVisible(true);
            winnerRound16nr1.setText(team2.getText());
            winnerRound16nr1.setVisible(true);
            winnerQuarter1.setVisible(true);
        } */
    }
    public void setWinnerRound16nr2() {
        if (spinnerTeam3.getValue().equals(6)) {
            spinnerTeam3.setDisable(true);
            spinnerTeam4.setDisable(true);
            line1winner3.setVisible(true);
            line2winner3.setVisible(true);
            winnerRound16nr2.setText(team3.getText());
            winnerRound16nr2.setVisible(true);
            spinnerRoundOf16nr2.setVisible(true);
            winnerQuarter1.setVisible(true);
        } else if (spinnerTeam4.getValue().equals(6)) {
            spinnerTeam4.setDisable(true);
            spinnerTeam3.setDisable(true);
            line1winner3.setVisible(true);
            line2winner3.setVisible(true);
            spinnerRoundOf16nr2.setVisible(true);
            winnerRound16nr2.setText(team4.getText());
            winnerRound16nr2.setVisible(true);
            winnerQuarter1.setVisible(true);
        }
    }

    public void setWinnerRound16nr3() {
        if (spinnerTeam5.getValue().equals(6)) {
            spinnerTeam5.setDisable(true);
            spinnerTeam6.setDisable(true);
            line1winner4.setVisible(true);
            line2winner4.setVisible(true);
            winnerRound16nr3.setText(team5.getText());
            winnerRound16nr3.setVisible(true);
            spinnerRoundOf16nr3.setVisible(true);
            winnerQuarter2.setVisible(true);
        } else if (spinnerTeam6.getValue().equals(6)) {
            spinnerTeam5.setDisable(true);
            spinnerTeam6.setDisable(true);
            line1winner4.setVisible(true);
            line2winner4.setVisible(true);
            spinnerRoundOf16nr3.setVisible(true);
            winnerRound16nr3.setText(team6.getText());
            winnerRound16nr3.setVisible(true);
            winnerQuarter2.setVisible(true);
        }
    }

    public void setWinnerRound16nr4() {
        if (spinnerTeam7.getValue().equals(6)) {
            spinnerTeam7.setDisable(true);
            spinnerTeam8.setDisable(true);
            line1winner5.setVisible(true);
            line2winner5.setVisible(true);
            winnerRound16nr4.setText(team7.getText());
            winnerRound16nr4.setVisible(true);
            winnerQuarter2.setVisible(true);
        } else if (spinnerTeam8.getValue().equals(6)) {
            spinnerTeam7.setDisable(true);
            spinnerTeam8.setDisable(true);
            line1winner5.setVisible(true);
            line2winner5.setVisible(true);
            winnerQuarter2.setVisible(true);
            winnerRound16nr4.setText(team8.getText());
            winnerRound16nr4.setVisible(true);
        }
    }
    public void setWinnerQuarter1() {
        if(spinnerRoundOf16nr1.getValue().equals(6)) {
            spinnerRoundOf16nr1.setDisable(true);
            spinnerRoundOf16nr2.setDisable(true);
            winnerQuarter1.setText(winnerRound16nr1.getText());
            line1winner2.setVisible(true);
            line2winner2.setVisible(true);
            winnerSem1.setVisible(true);
        } else if(spinnerRoundOf16nr2.getValue().equals(6)) {
            spinnerRoundOf16nr1.setDisable(true);
            spinnerRoundOf16nr2.setDisable(true);
            winnerQuarter1.setText(winnerRound16nr2.getText());
            line1winner2.setVisible(true);
            line2winner2.setVisible(true);
            winnerSem1.setVisible(true);
        }
    }

    public void setWinnerQuarter2() {
        if(spinnerRoundOf16nr3.getValue().equals(6)) {
            spinnerRoundOf16nr3.setDisable(true);
            spinnerRoundOf16nr4.setDisable(true);
            line1winner12.setVisible(true);
            line2winner12.setVisible(true);
            winnerSem1.setVisible(true);
            winnerQuarter2.setText(winnerRound16nr3.getText());
        } else if(spinnerRoundOf16nr4.getValue().equals(6)){
            spinnerRoundOf16nr3.setDisable(true);
            spinnerRoundOf16nr4.setDisable(true);
            line1winner12.setVisible(true);
            line2winner12.setVisible(true);
            winnerSem1.setVisible(true);
            winnerQuarter2.setText(winnerRound16nr4.getText());
        }
    }
}
