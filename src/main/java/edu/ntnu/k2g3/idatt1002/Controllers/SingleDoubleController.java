package edu.ntnu.k2g3.idatt1002.Controllers;

import edu.ntnu.k2g3.idatt1002.Main;
import edu.ntnu.k2g3.idatt1002.Tournament;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * The controller for the singles/doubles scene
 *
 * @author jenscl, annamarieboetvedt, williamlie
 */
public class SingleDoubleController {
    @FXML
    public AnchorPane singlesDoublesPane, namePane;
    @FXML
    public TextField tournamentName;
    @FXML
    private RadioButton singlesButton, doublesButton;
    @FXML
    private Button confirm;

    private Tournament tournament;

    /**
     * Initializing the scene.
     */
    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        singlesButton.setToggleGroup(group);
        doublesButton.setToggleGroup(group);
        confirm.setDisable(true);
        singlesDoublesPane.setVisible(false);

        doublesButton.setOnAction((event) -> {
            tournament.setDoubles(true);
            confirm.setDisable(false);
        }
        );

        singlesButton.setOnAction((event) -> {
            tournament.setDoubles(false);
            confirm.setDisable(false);
        }
        );
    }


    /**
     * Creates a new tournament with the name given by the user
     */
    public void createTournament() {
        this.tournament = new Tournament(tournamentName.getText());
        namePane.setDisable(true);
        singlesDoublesPane.setVisible(true);
    }

    /**
     * Method for sending the user to the name teams scene
     *
     * @param event The event
     * @throws IOException May throw an exception if something goes wrong
     */
    public void goToNameTeams(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("nameTeam.fxml"));
        Parent root = fxmlLoader.load();

        NameTeamsController controller = fxmlLoader.getController();
        controller.setTournament(this.tournament);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
