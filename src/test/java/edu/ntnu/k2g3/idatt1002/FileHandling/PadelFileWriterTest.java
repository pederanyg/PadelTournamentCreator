package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.Player;
import edu.ntnu.k2g3.idatt1002.PlayerRegistry;
import edu.ntnu.k2g3.idatt1002.Team;
import edu.ntnu.k2g3.idatt1002.TeamRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PadelFileWriterTest {

    @Test
    public void writePlayerRegistryToFile() {
        PadelFileWriter.writePlayerRegistryToFile("src/test/resources/test.csv", createPlayerRegistry());
    }

    @Test
    public void writeTeamRegistryToFile() {
        PadelFileWriter.writeTeamRegistryToFile("src/test/resources/testTeam.csv", createTeamRegistry());
    }

    private PlayerRegistry createPlayerRegistry(){
        PlayerRegistry registry = new PlayerRegistry();
        registry.addNewPlayer("anna", "tvedt");
        registry.addNewPlayer("marie", "tvedt");
        registry.addNewPlayer("jens", "tvedt");
        registry.addNewPlayer("william", "tvedt");
        registry.addNewPlayer("helle", "tvedt");
        return registry;
    }

    private TeamRegistry createTeamRegistry(){
        TeamRegistry registry = new TeamRegistry();
        registry.addNewTeam("team2", new Player("anna", "tvedt"), new Player("helle", "Tvedt"));
        registry.addNewTeam("Jens Team",new Player("jens", "tvedt"), new Player("William", "Tvedt"));
        registry.addNewTeam("BestTeam",new Player("jens", "tvedt"), new Player("William", "Lie"));
        registry.addNewTeam("team6", new Player("anna", "tvedt"), new Player("helle", "Tvedt"));
        return registry;
    }
}