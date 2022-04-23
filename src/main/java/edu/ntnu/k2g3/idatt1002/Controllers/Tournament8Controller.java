package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Tournament8Controller {
    @FXML
    private Spinner<String> spinnerTeam1, spinnerTeam2, spinnerTeam3, spinnerTeam4;
    @FXML
    private Spinner<String> spinnerTeam5, spinnerTeam6, spinnerTeam7, spinnerTeam8;
    @FXML
    private Spinner<String> bracket1Spinner, bracket2Spinner, bracket3Spinner, bracket4Spinner;
    @FXML
    private Spinner<String> finalist1Spinner, finalist2Spinner;

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
    private Button exitTournament;

    @FXML
    public void initialize() {
        displayTeamNames();
        finalist1Line.setVisible(false);
        finalist2Line.setVisible(false);
        winnerBracket1.setText("");
        winnerBracket2.setText("");
        winnerBracket3.setText("");
        winnerBracket4.setText("");
        winnerFinal.setVisible(false);
        bracket1Spinner.setVisible(false);
        bracket2Spinner.setVisible(false);
        bracket3Spinner.setVisible(false);
        bracket4Spinner.setVisible(false);
        finalist1Spinner.setVisible(false);
        finalist2Spinner.setVisible(false);
        line1Bracket1.setVisible(false);
        line2Bracket1.setVisible(false);
        line1Bracket2.setVisible(false);
        line2Bracket2.setVisible(false);
        line1Bracket3.setVisible(false);
        line2Bracket3.setVisible(false);
        line1Bracket4.setVisible(false);
        line2Bracket4.setVisible(false);
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
        finalist1.setVisible(false);
        finalist2.setVisible(false);
        winnerLine.setVisible(false);
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

    @FXML
    public void decideWinnerBracket1() {
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
            bracket1Spinner.setVisible(true);
        }
    }

    @FXML
    public void decideWinnerBracket2() {
        if(spinnerTeam3.getValue().equals(6)) {
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
            bracket2Spinner.setVisible(true);
        }
    }

    @FXML
    public void decideWinnerBracket3() {
        if(spinnerTeam5.getValue().equals(6)) {
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
        }
    }

    @FXML
    public void decideWinnerBracket4() {
        if(spinnerTeam6.getValue().equals(6)) {
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
        }
    }

    @FXML
    public void decideWinnerSemi1() {
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
        }
    }

    @FXML
    public void decideWinnerSemi2() {
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
        }
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
