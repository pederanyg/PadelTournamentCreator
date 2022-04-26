package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PadelFileWriterTest {

    @Test
    public void testCheckDirectory(){
        PadelFileWriter.checkDirectory();
    }

    @Test
    public void writeDoubleTournamentToFile() {
        Tournament tournament = new Tournament("Test double tournament");
        tournament.addAll(createDoubleTeamRegistry());
        tournament.createNewMatches();

        PadelFileWriter.checkDirectory();
        PadelFileWriter.writeDoubleTournamentToFile(tournament);
    }

    @Test
    public void writeSingleTournamentToFile() {
        Tournament tournament = new Tournament("Test single tournament");
        tournament.addAll(createSingleTeamRegistry());
        tournament.createNewMatches();

        PadelFileWriter.checkDirectory();
        PadelFileWriter.writeSingleTournamentToFile(tournament);
    }

    @Test
    public void writeTeamNamesToFile(){
        PadelFileWriter.writeTeamNamesToFile("src/test/resources/testTeamNames.csv", createListOfTeams());
    }


    private ArrayList<Team> createDoubleTeamRegistry(){
        ArrayList<Team> registry = new ArrayList<>();
        registry.add(new Team("team2", new Player("anna", "tvedt"), new Player("helle", "Tvedt")));
        registry.add(new Team("Jens Team",new Player("jens", "tvedt"), new Player("William", "Tvedt")));
        registry.add(new Team("BestTeam",new Player("jens", "tvedt"), new Player("William", "Lie")));
        registry.add(new Team("team6", new Player("anna", "tvedt"), new Player("helle", "Tvedt")));
        return registry;
    }

    private ArrayList<Team> createSingleTeamRegistry(){
        ArrayList<Team> registry = new ArrayList<>();
        registry.add(new Team(new Player("helle", "Tvedt")));
        registry.add(new Team(new Player("William", "Tvedt")));
        registry.add(new Team(new Player("William", "Lie")));
        registry.add(new Team(new Player("helle", "Tvedt")));
        return registry;
    }

    private ArrayList<String> createListOfTeams() {
        ArrayList<String> teamNames = new ArrayList<>();
        teamNames.add("Helle");
        teamNames.add("Finn");
        teamNames.add("pål");
        teamNames.add("per");
        teamNames.add("anna");
        teamNames.add("jens");
        return teamNames;
    }
}