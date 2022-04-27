package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.FileHandling.PadelFileWriter;
import edu.ntnu.k2g3.idatt1002.Match;
import edu.ntnu.k2g3.idatt1002.Tournament;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Tournament controller.
 */
public abstract class TournamentController {

    private Tournament tournament;

    /**
     * Sets the tournament and display.
     *
     * @param tournament the tournament
     */
    public void setTournament(Tournament tournament){
        this.tournament = tournament;
        displayNames();
    }

    /**
     * Get the tournament.
     *
     * @return the tournament
     */
    public Tournament getTournament(){
        return tournament;
    }

    /**
     * Display names.
     */
    public abstract void displayNames();

    /**
     * Get the list of names in the order they ar supposed to be displayed in.
     *
     * @return the array list
     */
    public ArrayList<String> getListOfNames(){
        ArrayList<String> list = new ArrayList<>();
        for (Match match : getTournament().getMatches()) {
            list.add(match.getTeam1().getTeamName());
            list.add(match.getTeam2().getTeamName());
        }
        return list;
    }

    /**
     * Return to first scene.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void returnToFirstScene(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/edu/ntnu/k2g3/idatt1002/welcomescreen.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets the winner of the tournament.
     *
     * @param winnerDisplay the winner label.
     * @param winner        the label with winner name
     * @param button        the button
     */
    protected void setWinner(Label winnerDisplay, Label winner, Button button){
        winnerDisplay.setVisible(true);
        winnerDisplay.setText(winner.getText() + " is the winning team!");
        button.setVisible(true);
    }

    /**
     * Sets the next bracket with the winners name.
     *
     * @param spinner1      the spinner 1
     * @param spinner2      the spinner 2
     * @param winnerBracket the winner bracket
     * @param teamLabel     the team label
     * @return the next bracket
     */
    protected boolean setNextBracket(Spinner<Integer> spinner1, Spinner<Integer> spinner2, Label winnerBracket, Label teamLabel) {
        if (spinner1.getValue().equals(6)) {
            tournament.getMatches().forEach(match -> {
                if (match.getTeam1().getTeamName().equals(teamLabel.getText())) {
                    match.setResult(spinner1.getValue(), spinner2.getValue(), match.getTeam1());
                } else if (match.getTeam2().getTeamName().equals(teamLabel.getText())) {
                    match.setResult(spinner2.getValue(), spinner1.getValue(), match.getTeam2());
                }
            });
            spinner1.setDisable(true);
            spinner2.setDisable(true);
            winnerBracket.setText(teamLabel.getText());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Saves the tournament results in a file.
     */
    public void saveTournamentToFile(){
        PadelFileWriter.checkDirectory();
        if (tournament.isDoubles()){
            PadelFileWriter.writeDoubleTournamentToFile(tournament);
        }else PadelFileWriter.writeSingleTournamentToFile(tournament);
    }



}
