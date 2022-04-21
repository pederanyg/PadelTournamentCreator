package edu.ntnu.k2g3.idatt1002;

public class Team {

    private String teamName;
    private Player player1, player2;


    public Team(String teamName, Player player1, Player player2) {
        if (teamName.isBlank()) {
            throw new IllegalArgumentException("The team needs a name.");
        }
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Team(Player player){
        this.player1 = player;
        this.teamName = player.getName();
    }

    public String getTeamName() {
        return teamName;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public boolean changePlayers(Player playerToRemove, Player playerToAdd){
        if (playerToRemove.equals(player1)){
            player1 = playerToAdd;
            return true;
        }else if (playerToRemove.equals(player2)){
            player2 = playerToAdd;
            return true;
        }else return false;
    }
}
