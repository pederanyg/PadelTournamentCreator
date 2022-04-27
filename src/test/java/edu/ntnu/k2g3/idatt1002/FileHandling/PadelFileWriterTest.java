package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class PadelFileWriterTest {

    @Test
    public void writeDoubleTournamentToFile() {
        Tournament tournament = new Tournament("TestDoubleTournament");
        tournament.addAll(createDoubleTeamRegistry());
        tournament.setDoubles(true);
        tournament.createNewMatches();
        PadelFileWriter.writeTournamentToFile(tournament);

        File recordsDir = new File(System.getProperty("user.home"), "PadelTournamentResults");
        assertTrue(recordsDir.exists());

        assertTrue(new File(System.getProperty("user.home") + "/PadelTournamentResults/" + tournament.getName() + ".txt").exists());
    }

    @Test
    public void writeSingleTournamentToFile() {
        Tournament tournament = new Tournament("Test single tournament");
        tournament.addAll(createSingleTeamRegistry());
        tournament.setDoubles(false);
        tournament.createNewMatches();
        PadelFileWriter.writeTournamentToFile(tournament);

        File recordsDir = new File(System.getProperty("user.home"), "PadelTournamentResults");
        assertTrue(recordsDir.exists());

        assertTrue(new File(System.getProperty("user.home") + "/PadelTournamentResults/" + tournament.getName() + ".txt").exists());

    }

    private ArrayList<Team> createDoubleTeamRegistry(){
        return new ArrayList<>(Arrays.asList(
                new Team("team2", new Player("anna", "tvedt"), new Player("helle", "Tvedt")),
                new Team("Jens Team",new Player("jens", "tvedt"), new Player("William", "Tvedt")),
                new Team("BestTeam",new Player("jens", "tvedt"), new Player("William", "Lie")),
                new Team("team6", new Player("anna", "tvedt"), new Player("helle", "Tvedt")))
        );
    }

    private ArrayList<Team> createSingleTeamRegistry(){
        return new ArrayList<>(Arrays.asList(
            new Team(new Player("helle", "Tvedt")),
            new Team(new Player("William", "Tvedt")),
            new Team(new Player("William", "Lie")),
            new Team(new Player("helle", "Tvedt"))
        ));
    }
}