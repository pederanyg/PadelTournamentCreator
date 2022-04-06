package edu.ntnu.k2g3.idatt1002.Controllers;

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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TournamentController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Spinner spinnerTeam1;
    @FXML
    private Spinner spinnerTeam2;
    @FXML
    private Spinner spinnerTeam3;
    @FXML
    private Spinner spinnerTeam4;
    @FXML
    private Spinner winnerBracket1Spinner;
    @FXML
    private Spinner winnerBracket2Spinner;
    @FXML
    private Line line1team1;
    @FXML
    private Line line2team1;
    @FXML
    private Line line1team2;
    @FXML
    private Line line2team2;
    @FXML
    private Line line1team3;
    @FXML
    private Line line2team3;
    @FXML
    private Line line1team4;
    @FXML
    private Line line2team4;
    @FXML
    private Line finalWinnerLine1;
    @FXML
    private Line finalWinnerLine2;
    @FXML
    private Label team1Label;
    @FXML
    private Label team2Label;
    @FXML
    private Label team3Label;
    @FXML
    private Label team4Label;
    @FXML
    private Label winnerBracket1;
    @FXML
    private Label winnerBracket2;
    @FXML
    private Label winnerFinal;
    @FXML
    private Label winnerDisplay;
    @FXML
    private Button exitTournament;

    @FXML
    public void initialize() {
        finalWinnerLine1.setVisible(false);
        finalWinnerLine2.setVisible(false);
        winnerBracket1.setText("");
        winnerBracket2.setText("");
        winnerFinal.setVisible(false);
        winnerBracket1Spinner.setVisible(false);
        winnerBracket2Spinner.setVisible(false);
        winnerDisplay.setVisible(false);
        exitTournament.setVisible(false);
    }
    @FXML
    public void winnerSemi1() {
        if(spinnerTeam1.getValue().equals(6)) {
            line1team1.setVisible(true);
            line2team1.setVisible(true);
            winnerBracket1.setText(team1Label.getText());
            winnerBracket1.setVisible(true);
            spinnerTeam2.setDisable(true);
            winnerBracket1Spinner.setVisible(true);
        } else if(spinnerTeam2.getValue().equals(6)) {
            line1team2.setVisible(true);
            line2team2.setVisible(true);
            winnerBracket1.setText(team2Label.getText());
            winnerBracket1.setVisible(true);
            spinnerTeam1.setDisable(true);
            winnerBracket1Spinner.setVisible(true);
        }
    }

    @FXML
    public void winnerSemi2() {
        if(spinnerTeam3.getValue().equals(6)) {
            line1team3.setVisible(true);
            line2team3.setVisible(true);
            winnerBracket2.setText(team3Label.getText());
            winnerBracket2.setVisible(true);
            spinnerTeam4.setDisable(true);
            winnerBracket2Spinner.setVisible(true);
        } else if(spinnerTeam4.getValue().equals(6)) {
            line1team4.setVisible(true);
            line2team4.setVisible(true);
            winnerBracket2.setText(team4Label.getText());
            winnerBracket2.setVisible(true);
            spinnerTeam3.setDisable(true);
            winnerBracket2Spinner.setVisible(true);
        }
    }

    @FXML
    public void winnerFinal() {
        if(winnerBracket1Spinner.getValue().equals(6)){
            finalWinnerLine1.setVisible(true);
            finalWinnerLine2.setVisible(true);
            winnerFinal.setText(winnerBracket1.getText());
            winnerFinal.setVisible(true);
            winnerDisplay.setVisible(true);
            winnerDisplay.setText(winnerBracket1.getText() + " is the winning team!");
            exitTournament.setVisible(true);
            winnerBracket2Spinner.setDisable(true);
        } else if(winnerBracket2Spinner.getValue().equals(6)){
            finalWinnerLine1.setVisible(true);
            finalWinnerLine2.setVisible(true);
            winnerFinal.setText(winnerBracket2.getText());
            winnerFinal.setVisible(true);
            winnerDisplay.setVisible(true);
            winnerDisplay.setText(winnerBracket2.getText() + " is the winning team!");
            exitTournament.setVisible(true);
            winnerBracket1Spinner.setDisable(true);
        }
    }

    @FXML
    public void displayTeamNames(ObservableList teamNames) {
        team1Label.setText((String) teamNames.get(0));
        team2Label.setText((String) teamNames.get(1));
        team3Label.setText((String) teamNames.get(2));
        team4Label.setText((String) teamNames.get(3));
    }
    public void switchToScene1(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/welcomescreen.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}