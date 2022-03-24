public class Team {

    public String teamName;
    public Player player1;
    public Player player2;


    public Team(String teamName, Player player1, Player player2){
        if (teamName.isBlank()){throw new IllegalArgumentException("The team needs a name");}
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getTeamName() {
        return teamName;
    }

    public void changePlayerOneWithTwo(Player one, Player two){
        if (two.equals(player1)){
            player1 = one;
        }
        else if (two.equals(player2)){
            player2 = one;
        }
    }

    // Legg inn remove metode?

}
