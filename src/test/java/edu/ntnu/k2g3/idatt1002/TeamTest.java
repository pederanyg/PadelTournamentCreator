package edu.ntnu.k2g3.idatt1002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    public void testGetTeamName() {
        Team team = new Team("Team name",
                new Player("player", "one"),
                new Player("player", "two"));
        assertEquals(team.getTeamName(), "Team name");
    }

    @Test
    public void testConstructor(){
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                    new Team("", new Player("player", "one"),
                            new Player("player", "two")),
                "IllegalArgumentException was expected");

        assertEquals(thrown.getMessage(), "The team needs a name!");
    }

    @Test
    public void testConstructor2(){
        Team team = new Team(new Player("player", "one"));
        assertNull(team.getPlayer2());
    }
}