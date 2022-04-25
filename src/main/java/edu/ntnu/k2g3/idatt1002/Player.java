package edu.ntnu.k2g3.idatt1002;

public class Player {

    private final String firstName;
    private final String surName;

    public Player(String firstName, String surName){
        if (firstName.isBlank()||surName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        this.firstName = firstName.trim();
        this.surName = surName.trim();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return firstName + " " + surName;
    }

    @Override
    public String toString() {
        return firstName + " " + surName;
    }

}

