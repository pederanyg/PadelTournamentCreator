package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.shape.Line;

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
    public Label team2;
    public Label team1;
    public Label team4;
    public Label team3;
    public Label team8;
    public Label team7;
    public Label team6;
    public Label team5;
    public Label team10;
    public Label team9;
    public Label team12;
    public Label team11;
    public Label team14;
    public Label team13;
    public Label team16;
    public Label team15;
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
    public void setWinnerQuarter1() {
        if (spinnerTeam1.getValue().equals(6)) {
            spinnerTeam2.setDisable(true);
            spinnerTeam1.setDisable(true);
            line1winner1.setVisible(true);
            line2winner1.setVisible(true);
            winnerQuarter1.setText(team1.getText());
            winnerQuarter1.setVisible(true);
        } else if (spinnerTeam2.getValue().equals(6)) {
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
            line1winner1.setVisible(true);
            line2winner1.setVisible(true);
            winnerQuarter1.setText(team2.getText());
            winnerQuarter1.setVisible(true);
        }
    }
    public void setWinnerQuarter2() {
        if (spinnerTeam3.getValue().equals(6)) {
            spinnerTeam3.setDisable(true);
            spinnerTeam4.setDisable(true);
            line1winner3.setVisible(true);
            line2winner3.setVisible(true);
            winnerQuarter1.setText(team1.getText());
            winnerQuarter1.setVisible(true);
        } else if (spinnerTeam2.getValue().equals(6)) {
            spinnerTeam1.setDisable(true);
            spinnerTeam2.setDisable(true);
            line1winner1.setVisible(true);
            line2winner1.setVisible(true);
            winnerQuarter1.setText(team2.getText());
            winnerQuarter1.setVisible(true);
        }
    }
}
