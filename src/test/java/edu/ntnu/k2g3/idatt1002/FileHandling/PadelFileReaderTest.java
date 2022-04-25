package edu.ntnu.k2g3.idatt1002.FileHandling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PadelFileReaderTest {

    @Test
    public void readTeamNames(){
        ArrayList<String> list = PadelFileReader.readTeamNames("src/test/resources/testTeamNames.csv");
        assertEquals("Helle", list.get(0));
    }
}