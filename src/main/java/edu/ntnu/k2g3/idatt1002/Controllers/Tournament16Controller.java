package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;


public class Tournament16Controller extends TournamentController {
    @FXML
    public Spinner<Integer> spinnerFinal1, spinnerFinal2;
    public Spinner<Integer> spinnerSemi1, spinnerSemi2, spinnerSemi3, spinnerSemi4;
    public Spinner<Integer> spinnerQuarter1, spinnerQuarter2, spinnerQuarter3, spinnerQuarter4;
    public Spinner<Integer> spinnerQuarter5, spinnerQuarter6, spinnerQuarter7, spinnerQuarter8;
    public Spinner<Integer> spinner1, spinner2, spinner3, spinner4;
    public Spinner<Integer> spinner5, spinner6, spinner7, spinner8;
    public Spinner<Integer> spinner9, spinner10, spinner11,spinner12;
    public Spinner<Integer> spinner13,spinner14,spinner15,spinner16;
    @FXML
    public Label team1, team2, team3, team4, team5, team6, team7, team8;
    public Label team9, team10, team11, team12, team13, team14, team15, team16;
    public Label quarter1, quarter2, quarter3, quarter4;
    public Label quarter5, quarter6, quarter7, quarter8;
    public Label semi1, semi2, semi3, semi4;
    public Label final1, final2;
    public Label winnerFinal, winnerDisplay;
    public Button exitTournament, saveResult;
    @FXML
    private AnchorPane leftAnchor, leftQuarterAnchor, semiLeftAnchor;
    @FXML
    private AnchorPane rightAnchor, rightQuarterAnchor, semiRightAnchor;
    @FXML
    private AnchorPane finalAnchor, winnerAnchor;

    public void initialize() {
        leftQuarterAnchor.setDisable(true);
        rightQuarterAnchor.setDisable(true);
        winnerDisplay.setVisible(false);
        semiRightAnchor.setDisable(true);
        semiLeftAnchor.setDisable(true);
        finalAnchor.setDisable(true);
        winnerAnchor.setDisable(true);
        exitTournament.setVisible(false);
        saveResult.setVisible(false);
    }

    @FXML
    public void displayNames() {
        getTournament().createNewMatches();
        Label[] labels = {team1, team2, team3, team4, team5, team6, team7, team8, team9, team10, team11, team12, team13, team14, team15, team16};
        int i = 0;
        for (Label label : labels) {
            label.setText(getListOfNames().get(i));
            i++;
        }
    }


    public boolean checkRoundOf16Brackets() {
        boolean one = setNextBracket(spinner1, spinner2, quarter1, team1) || setNextBracket(spinner2, spinner1, quarter1, team2);
        boolean two = setNextBracket(spinner3, spinner4, quarter2, team3) || setNextBracket(spinner4, spinner3, quarter2, team4);
        boolean three = setNextBracket(spinner5, spinner6, quarter3, team5) || setNextBracket(spinner6, spinner5, quarter3, team6);
        boolean four = setNextBracket(spinner7, spinner8, quarter4, team7) || setNextBracket(spinner8, spinner7, quarter4, team8);
        boolean five = setNextBracket(spinner9, spinner10, quarter5, team9) || setNextBracket(spinner10, spinner9, quarter5, team10);
        boolean six = setNextBracket(spinner11, spinner12, quarter6, team11) || setNextBracket(spinner12, spinner11, quarter6, team12);
        boolean seven = setNextBracket(spinner13, spinner14, quarter7, team13) || setNextBracket(spinner14, spinner13, quarter7, team14);
        boolean eight = setNextBracket(spinner15, spinner16, quarter8, team15) || setNextBracket(spinner16, spinner15, quarter8, team16);
        return one && two && three && four && five && six && seven && eight;
    }

    private boolean checkQuarters() {
        boolean quarterOne = setNextBracket(spinnerQuarter1, spinnerQuarter2, semi1, quarter1) || setNextBracket(spinnerQuarter2, spinnerQuarter1, semi1, quarter2);
        boolean quarterTwo = setNextBracket(spinnerQuarter3, spinnerQuarter4, semi2, quarter3) || setNextBracket(spinnerQuarter4, spinnerQuarter3, semi2, quarter4);
        boolean quarterThree = setNextBracket(spinnerQuarter5, spinnerQuarter6, semi3, quarter5) || setNextBracket(spinnerQuarter6, spinnerQuarter5, semi3, quarter6);
        boolean quarterFour = setNextBracket(spinnerQuarter7, spinnerQuarter8, semi4, quarter7) || setNextBracket(spinnerQuarter8, spinnerQuarter7, semi4, quarter8);
        return quarterOne && quarterTwo && quarterThree && quarterFour;
    }

    private boolean checkSemis() {
        boolean semiOne = setNextBracket(spinnerSemi1, spinnerSemi2, final1, semi1) || setNextBracket(spinnerSemi2, spinnerSemi1, final1, semi2);
        boolean semiTwo = setNextBracket(spinnerSemi3, spinnerSemi4, final2, semi3) || setNextBracket(spinnerSemi4, spinnerSemi3, final2, semi4);
        return semiOne && semiTwo;
    }

    @FXML
    public void setQuarters() {
        if(checkRoundOf16Brackets()) {
            getTournament().createNewMatches();
            leftAnchor.setDisable(true);
            rightAnchor.setDisable(true);
            leftQuarterAnchor.setDisable(false);
            rightQuarterAnchor.setDisable(false);
        }
    }

    @FXML
    public void setSemiFinals() {
        if(checkQuarters()) {
            getTournament().createNewMatches();
            leftQuarterAnchor.setDisable(true);
            rightQuarterAnchor.setDisable(true);
            semiLeftAnchor.setDisable(false);
            semiRightAnchor.setDisable(false);
        }
    }

    @FXML
    public void setFinals() {
        if(checkSemis()) {
            getTournament().createNewMatches();
            semiRightAnchor.setDisable(true);
            semiLeftAnchor.setDisable(true);
            finalAnchor.setDisable(false);
        }
    }

    @FXML
    public void setWinner(){
        if (setNextBracket(spinnerFinal1, spinnerFinal2, winnerFinal, final1) ||
                setNextBracket(spinnerFinal2, spinnerFinal1, winnerFinal, final2)){
            finalAnchor.setDisable(true);
            winnerAnchor.setDisable(false);
            saveResult.setVisible(true);
            setWinner(winnerDisplay, winnerFinal, exitTournament);
        }
    }
}