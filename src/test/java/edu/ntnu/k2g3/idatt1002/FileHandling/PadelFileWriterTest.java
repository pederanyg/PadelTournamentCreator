package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PadelFileWriterTest {

    @Test
    public void writeTournamentToFile() {
        Tournament tournament = new Tournament("Test tournament");
        tournament.addAll(createTeamRegistry());
        tournament.createNewMatches();

        PadelFileWriter.checkDirectory();
        PadelFileWriter.writeTournamentToFile("src/test/resources/testTeamNames.csv", tournament);

    }

    @Test
    public void writeTeamNamesToFile(){
        PadelFileWriter.writeTeamNamesToFile("src/test/resources/testTeamNames.csv", createListOfTeams());
    }


    private ArrayList<Team> createTeamRegistry(){
        ArrayList<Team> registry = new ArrayList<Team>();
        registry.add(new Team("team2", new Player("anna", "tvedt"), new Player("helle", "Tvedt")));
        registry.add(new Team("Jens Team",new Player("jens", "tvedt"), new Player("William", "Tvedt")));
        registry.add(new Team("BestTeam",new Player("jens", "tvedt"), new Player("William", "Lie")));
        registry.add(new Team("team6", new Player("anna", "tvedt"), new Player("helle", "Tvedt")));
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