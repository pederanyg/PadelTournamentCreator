package edu.ntnu.k2g3.idatt1002;

import java.util.ArrayList;

public class PlayerRegistry {

    public ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player newPlayer(String firstName, String lastName, int age, String gender){
        Player newPlayer = new Player(firstName, lastName, age, gender);
        players.add(newPlayer);
        return newPlayer;
    }
    
    // Method for finding a player by name, if necessary
    
    public ArrayList<Player> getPlayerByName(String firstName, String lastName){
        ArrayList<Player> playerName = new ArrayList<>();
        for (int i = 0; i < getPlayers().size(); i++){
            if(getPlayers().get(i).getName().equals(playerName)){
                playerName.add(getPlayers().get(i));
            }
        }
        return playerName;
    }
    
}