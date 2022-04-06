package edu.ntnu.k2g3.idatt1002;

public class Player {

    private String firstname;
    private String surname;

    public Player(String firstName, String lastName){
        if (firstName.isBlank()||lastName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        this.firstname = firstName.trim();
        this.surname = lastName.trim();
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSurName() {
        return surname;
    }

    public String getName() {
        return firstname + " " + surname;
    }

    public void setName(String firstName, String lastName) {
        if (firstName.isBlank()||lastName.isBlank()){throw new IllegalArgumentException("The player needs a full name!");}
        this.firstname = firstName;
        this.surname = lastName;
    }
}
