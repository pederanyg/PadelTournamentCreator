package edu.ntnu.k2g3.idatt1002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testToString() {
        Player player = new Player("firstname", "lastname");
        assertEquals(player.toString(), "firstname lastname");
    }

    @Test
    public void testConstructor() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                    new Player("", "lastname"),
                "IllegalArgumentException was expected");

        assertEquals(thrown.getMessage(), "The player needs a full name!");
    }
}