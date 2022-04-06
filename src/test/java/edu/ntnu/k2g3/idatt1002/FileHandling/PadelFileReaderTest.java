package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.PlayerRegistry;
import edu.ntnu.k2g3.idatt1002.TeamRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PadelFileReaderTest {

    @Test
    public void readPlayerRegistryFromFile() {
       PlayerRegistry registry = PadelFileReader.readPlayerRegistryFromFile("src/test/resources/test.csv");
       assertEquals(5, registry.getPlayers().size());
    }

    @Test
    public void readTeamRegistryFromFile() {
        TeamRegistry registry = PadelFileReader.readTeamRegistryFromFile("src/test/resources/testTeam.csv");
        assertEquals(4, registry.getTeams().size());
    }
}