package edu.ntnu.k2g3.idatt1002.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.shape.Line;

public class Tournament8Controller {
    @FXML
    private Spinner spinnerTeam1;
    @FXML
    private Spinner spinnerTeam2;
    @FXML
    private Spinner spinnerTeam3;
    @FXML
    private Spinner spinnerTeam4;
    @FXML
    private Spinner bracket1Spinner;
    @FXML
    private Spinner bracket2Spinner;
    @FXML
    private Spinner bracket3Spinner;
    @FXML
    private Spinner bracket4Spinner;
    @FXML
    private Spinner finalist1Spinner;
    @FXML
    private Spinner finalist2Spinner;
    @FXML
    private Label team1Label;
    @FXML
    private Label team2Label;
    @FXML
    private Label team3Label;
    @FXML
    private Label team4Label;
    @FXML
    private Label team5Label;
    @FXML
    private Label team6Label;
    @FXML
    private Label team7Label;
    @FXML
    private Label team8Label;
    @FXML
    private Label winnerBracket1;
    @FXML
    private Label winnerBracket2;
    @FXML
    private Label winnerBracket3;
    @FXML
    private Label winnerBracket4;
    @FXML
    private Label finalist1;
    @FXML
    private Label finalist2;
    @FXML
    private Label winnerDisplay;
    @FXML
    private Label winnerFinal;
    @FXML
    private Line line1Bracket1;
    @FXML
    private Line line2Bracket1;
    @FXML
    private Line line1Bracket2;
    @FXML
    private Line line2Bracket2;
    @FXML
    private Line line1Bracket3;
    @FXML
    private Line line2Bracket3;
    @FXML
    private Line line1Bracket4;
    @FXML
    private Line line2Bracket4;
    @FXML
    private Line finalist1Line;
    @FXML
    private Line finalist2Line;
    @FXML
    private Line winnerLine;
    @FXML
    private Button exitTournament;

    @FXML
    public void initialize() {
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








}
