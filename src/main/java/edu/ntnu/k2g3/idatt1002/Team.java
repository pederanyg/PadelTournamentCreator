package edu.ntnu.k2g3.idatt1002;

/**
 * The Team class.
 * Represents a team playing in a tournament.
 * Consists of a name and either one or two players.
 *
 * @author annamarieboetvedt, jenscl, pedernygaard, magnusforbord
 */
public class Team {

    private final String teamName;
    private final boolean isDoubles;
    private final Player player1;
    private final Player player2;

    /**
     * Constructor for instantiating a new Team.
     * This constructor is used when playing a doubles tournament
     *
     * @param teamName The team name
     * @param player1  The first player in the team
     * @param player2  The second player in the team
     * @throws IllegalArgumentException Throws an exception if the team is not given a name
     */
    public Team(String teamName, Player player1, Player player2) {
        if (teamName.isBlank()) {
            throw new IllegalArgumentException("The team needs a name!");
        }
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.isDoubles = true;
    }

    /**
     * Constructor for instantiating a new Team.
     * This constructor is used when playing a singles tournament
     * The team name is set to the name of the player
     *
     * @param player The player in the team
     */
    public Team(Player player){
        this.player1 = player;
        this.player2 = null;
        this.teamName = player.toString();
        this.isDoubles = false;
    }

    /**
     * Method for getting the name of the team
     *
     * @return The team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Method for getting the first player
     *
     * @return Returns the first player
     */
    public Player getPlayer1(){
        return player1;
    }

    /**
     * Method for getting the second player
     *
     * @return The second player
     */
    public Player getPlayer2(){
        return player2;
    }

    /**
     * Method for checking if the team is singels or doubles
     *
     * @return isDoubles
     */
    public boolean isDoubles(){
        return isDoubles;
    }

}
