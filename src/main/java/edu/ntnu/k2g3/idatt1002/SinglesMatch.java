package edu.ntnu.k2g3.idatt1002;

public class SinglesMatch {

    private Player playerOne;
    private Player playerTwo;
    private Player winner;

    public SinglesMatch(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void setSinglesResult(Player winner){
        if (winner.equals(playerOne)){
            this.winner = playerOne;
        } else {
            this.winner = playerTwo;}
    }

    @Override
    public String toString() {
        return "Match {" +
                "Player One = " + playerOne + " | Player Two = " + playerTwo + "}";
    }
}
