package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.Player;
import edu.ntnu.k2g3.idatt1002.Team;
import edu.ntnu.k2g3.idatt1002.Tournament;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the team naming scene
 *
 * @author jensl, annamarieboetvedt, williamlie
 */
public class NameTeamsController{

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ListView<String> listOfTeams;
    @FXML
    private Button startButton, addButton;

    @FXML
    private TextField playerNameField, teamNameField, playerOne, playerTwo;

    @FXML
    private Label teamChooser, teamNameLabel;

    @FXML
    private ChoiceBox<Integer> numberOfTeamsChoiceBox;
    @FXML
    private Button confirm;

    @FXML
    private AnchorPane numberOfTeamsAnchor, doublesAnchor;

    @FXML
    private Rectangle rectangle;

    private Tournament tournament;


    /**
     * Initializing the scene.
     */
    public void initialize() {
        numberOfTeamsChoiceBox.getItems().setAll(4,8,16);
        confirm.setDisable(true);
        numberOfTeamsAnchor.setVisible(true);
        startButton.setVisible(false);

        confirm.setOnAction((event) -> {
            numberOfTeamsAnchor.setVisible(false);
            createTeamList(numberOfTeamsChoiceBox.getValue());
        });

        addButton.setOnAction((event) -> {
            if (tournament.isDoubles()){
                addTeamToListOfTeams(teamNameField);
                playerOne.clear();
                playerTwo.clear();
                playerOne.setPromptText("Firstname + lastname");
                playerTwo.setPromptText("Firstname + lastname");
            }else{
                addTeamToListOfTeams(playerNameField);
            }
        });
    }

    /**
     * When the teams are selected, the confirm button able to be pressed
     */
    @FXML
    public void teamsSelected() {
        confirm.setDisable(false);
    }

    /**
     * Method for setting the tournament
     *
     * @param tournament The tournament to be set
     */
    public void setTournament(Tournament tournament){
        this.tournament = tournament;
        if (tournament.isDoubles()){
            teamChooser.setText("Choose a team from the dropdown menu:");
            teamNameLabel.setText("Enter team name:");
            playerNameField.setPromptText("Team name...");
            addButton.setText("Add team");
            doublesAnchor.setVisible(true);
            playerNameField.setVisible(false);
        }
    }

    /**
     * Method for creating the team list to be visualized for the user
     *
     * @param numberOfTeams The number of teams to added
     */
    public void createTeamList(int numberOfTeams) {
        if(tournament.isDoubles()){
            for(int i = 0; i < numberOfTeams; i++){
                choiceBox.getItems().add("Team" + (i + 1));}
        }else {
            for(int i = 0; i < numberOfTeams; i++){
                choiceBox.getItems().add("Player" + (i + 1));}
        }}

    /**
     * Method for setting the add button to being able to be pressed
     */
    @FXML
    public void chosenTeam() {
        addButton.setDisable(false);
    }

    /**
     * Adds the team to the textField to visualize what teams
     * are created
     *
     * @param nameField the name field in which the player info is stored
     */
    @FXML
    public void addTeamToListOfTeams(TextField nameField) {
        try{
        tournament.addTeam(createTeam());

        listOfTeams.getItems().add(nameField.getText());
        choiceBox.getItems().remove(choiceBox.getSelectionModel().getSelectedItem());
        choiceBox.valueProperty().setValue(null);
        nameField.clear();
        addButton.setDisable(true);

        teamNameField.setPromptText("Team name");
        playerNameField.setPromptText("Firstname + lastname");

        if(choiceBox.getItems().size() == 0) {
            setAllTeamsAdded();
        }
        }catch (IllegalArgumentException e){
            playerNameField.clear();
            teamNameField.clear();
            playerNameField.setPromptText(e.getMessage());
            teamNameField.setPromptText(e.getMessage());
        }
    }

    /**
     * Method for when all teams are added
     * Changes the GUI for the user
     *
     */

    private void setAllTeamsAdded(){
        startButton.setVisible(true);
        rectangle.setVisible(true);
        doublesAnchor.setVisible(false);
        teamChooser.setText("All players have been added.");
        if (tournament.isDoubles()){
            teamChooser.setText("All teams have been added.");
        }
    }

    /**
     * Method for creating a new team
     * Takes different input if the tournament is doubles
     *
     * @return The team
     * @throws IllegalArgumentException
     */

    private Team createTeam()throws IllegalArgumentException{
        if (tournament.isDoubles()){
            return new Team(teamNameField.getText(), createPlayer(playerOne), createPlayer(playerTwo));
        }else return new Team(createPlayer(playerNameField));
    }

    /**
     * Method for creating a player from a text field
     *
     * @param textfield The textfield to get player info from
     * @return returns a new Player by using the input
     * @throws IllegalArgumentException Throws an exception if the player is not given a full name
     */

    private Player createPlayer(TextField textfield)throws IllegalArgumentException {
        String[] list = textfield.getText().split(" ");
        if (list.length < 2){throw new IllegalArgumentException("Player needs a full name!");}
        String surname = list[list.length - 1];
        String firstname = textfield.getText().replace(surname, "");
        return new Player(firstname, surname);
    }


    /**
     * Method for changing scene to the tournament stage
     * Reads the amount of teams registered, and sends the user to the correct scene
     *
     * @param event The event
     * @throws IOException May throw an exception if something fails
     */
    @FXML
    public void goToTournament(ActionEvent event) throws IOException {
        FXMLLoader loader;
        Parent root;

        switch (listOfTeams.getItems().size()) {
            case 4 -> {
                loader = new FXMLLoader(getClass().getResource("/edu/ntnu/k2g3/idatt1002/tournament4.fxml"));
                root = loader.load();
                Tournament4Controller controller = loader.getController();
                controller.setTournament(this.tournament);
            }
            case 8 -> {
                loader = new FXMLLoader(getClass().getResource("/edu/ntnu/k2g3/idatt1002/tournament8.fxml"));
                root = loader.load();
                Tournament8Controller controller8 = loader.getController();
                controller8.setTournament(this.tournament);
            }
            case 16 -> {
                loader = new FXMLLoader(getClass().getResource("/edu/ntnu/k2g3/idatt1002/tournament16.fxml"));
                root = loader.load();
                Tournament16Controller controller16 = loader.getController();
                controller16.setTournament(this.tournament);
            }
            default -> throw new IllegalArgumentException("Number of teams are out of range.");
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
