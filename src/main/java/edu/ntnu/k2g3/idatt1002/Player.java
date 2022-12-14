package edu.ntnu.k2g3.idatt1002;

/**
 * The player class.
 * Represents a player in a team.
 *
 * @author annamarieboetvedt, jenscl
 */
public class Player {

    private final String firstName;
    private final String surName;

    /**
     * Constructor for instantiating a new Player.
     *
     * @param firstName The first name of the player
     * @param surName   The surname of the player
     */
    public Player(String firstName, String surName){
        if (firstName.isBlank()||surName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        this.firstName = firstName.trim();
        this.surName = surName.trim();
    }

    /**
     * Gets firstname.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return firstName + " " + surName;
    }

}

