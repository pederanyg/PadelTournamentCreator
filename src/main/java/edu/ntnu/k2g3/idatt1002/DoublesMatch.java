package edu.ntnu.k2g3.idatt1002;

public class DoublesMatch {

    private final Team teamOne, teamTwo;
    private Team winner;
    private String result;

    public DoublesMatch(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner, String result) {
        this.result = result;
        this.winner = winner;
    }

    public void setDoublesResult(Team winner){
        if (winner.equals(teamOne)){
            this.winner = teamOne;
        }else{
            this.winner = teamTwo;}
    }

    @Override
    public String toString() {
        return teamOne.getTeamName() + " vs " + teamTwo.getTeamName();
    }
}
