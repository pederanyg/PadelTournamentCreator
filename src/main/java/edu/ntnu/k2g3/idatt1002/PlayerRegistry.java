package edu.ntnu.k2g3.idatt1002;

import java.util.HashSet;

public class PlayerRegistry {

    private final HashSet<Player> players; //lage klasse med kun et objekt av registeret? singelton??

    public PlayerRegistry() {
        this.players = new HashSet<>();
    }

    public boolean addNewPlayer(String firstName, String lastName){
        return players.add(new Player(firstName, lastName));
    }

    public boolean removePlayer(String firstName, String lastName){
        return players.remove(new Player(firstName, lastName));
    }
    
    public Player getPlayerByName(String fullName){ // Method for finding a player by name, if needed
        for (Player player: players){
          if (player.getName().equalsIgnoreCase(fullName.trim()))
              return player;
        }
        return null;
    }

    public HashSet<Player> getPlayers(){
        return players;
    }
}