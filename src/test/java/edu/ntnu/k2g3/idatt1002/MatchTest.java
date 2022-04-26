package edu.ntnu.k2g3.idatt1002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    public void testGetWinner() {
        Match match = new Match(new Team(new Player("player", "one")),
                new Team(new Player("player", "two")));
        match.setResult(4,3,match.getTeam1());
        assertEquals(match.getWinner(),match.getTeam1());
    }

    @Test
    public void testSetResult() {
        Match match = new Match(new Team(new Player("player", "one")),
                new Team(new Player("player", "two")));
        match.setResult(4,3,match.getTeam1());
        assertEquals(match.getResult(), "4-3");
    }

    @Test
    public void testToString() {
        Match match = new Match(new Team(new Player("player", "one")),
                new Team(new Player("player", "two")));
        match.setResult(4,3, match.getTeam1());
        assertEquals("Match between player one and player two\n  Result: 4-3", match.toString());
    }

    @Test
    public void testConstructor(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->{
                    Team teamOne = new Team("doublesTeam", new Player("player", "one"),
                                new Player("player", "two"));
                    Team teamTwo = new Team(new Player("player", "two"));
                    new Match(teamOne,teamTwo);
                        },
                "IllegalArgumentException was expected");

        assertEquals(thrown.getMessage(), "The match cannot be between a singles team and a doubles team.");
    }
}