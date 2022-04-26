package edu.ntnu.k2g3.idatt1002;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {



    @Test
    public void addTeam() {
        Tournament tournament = new Tournament("Padel tournament");
        Team team =new Team(new Player("player", "one"));
        tournament.addTeam(team);
        assertEquals(tournament.getTeams().get(0), team);
    }

    @Test
    public void addAll() {
        Tournament tournament = new Tournament("Padel tournament");
        ArrayList<Team> teams = new ArrayList<>(Arrays.asList(
                new Team(new Player("player", "one")),
                new Team(new Player("player", "two"))));
        tournament.addAll(teams);
        assertEquals(tournament.getTeams().size(), 2);
    }

    @Test
    public void createNewMatches() {
        Tournament tournament = new Tournament("Padel tournament");
        ArrayList<Team> teams = new ArrayList<>(Arrays.asList(
                new Team(new Player("player", "one")),
                new Team(new Player("player", "two")),
                new Team(new Player("player", "three")),
                new Team(new Player("player", "four"))));
        tournament.addAll(teams);
        tournament.createNewMatches();
        assertEquals(tournament.getMatches().size(), 2);
    }
}