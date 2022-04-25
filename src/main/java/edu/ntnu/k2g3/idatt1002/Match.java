package edu.ntnu.k2g3.idatt1002;

/**
 * The Match class
 * Represents a match between two Teams
 *
 * @author annamarieboetvedt, jenscl
 */
public class Match {

    private final Team team1, team2;
    public Team winner;
    private String result;

    /**
     * Constructor for instantiating a new Match.
     *
     * @param one The first team
     * @param two The second team
     */
    public Match(Team one, Team two){
        this.team1 = one;
        this.team2 = two;
    }

    /**
     * Method for getting the first team
     *
     * @return Returns the first team
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Method for getting the second team
     *
     * @return Returns the second team
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Returns the team that won the Match
     *
     * @return The team that won the match
     */
    public Team getWinner(){return winner;}

    /**
     * Method for setting the result of a match and the winner
     *
     * @param one    The score of the first team
     * @param two    The score of the second team
     * @param winner The winner of the match
     */
    public void setResult(int one, int two, Team winner){
        this.winner = winner;
        this.result = one + "-" + two;
    }

    @Override
    public String toString() {
        return "Match between " + team1.getTeamName() + " and " + team2.getTeamName() + "Result: " + result;
    }
}

