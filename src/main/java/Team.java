public class Team {

    public String teamName;
    public ArrayList<Player> players = new ArrayList<>();

    public Team(String teamName){
        this.teamName = teamName;
    }

    public Team(String teamName, ArrayList<Player> players){
        this.teamName = teamName;
        this.players = players;
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

    /* if (players.size() == 2){
    }
    else if (players.size() == 1){
        throw new IllegalArgumentException("You have registered one player. Please register in a singles match instead.");
    } else if(players.size() > 2){
        throw new IllegalArgumentException("Too many players registered.The maximum is 2 players.");
    } else if(players.size() < 1){
        throw new IllegalArgumentException("You haven't registered any players.");
    } */

}
