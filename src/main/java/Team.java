import java.util.ArrayList;

public class Team extends Player {

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

    public void addAll(ArrayList<Player> players){
        this.players.addAll(players);
    }

    public void add(Player player) {
        players.add(player);
    }

    // Legg inn remove metode senere?

   /* public ArrayList<Team> tournamentTeams(){

        if (teams.size() == 2){
            this.teams.add(player);
        }
        else if (teams.size() == 1){
            throw new IllegalArgumentException("You have registered one player. Please register in a singles match instead.");
        } else if(teams.size() > 2){
            throw new IllegalArgumentException("Too many players registered.");
        } else if(teams.size() < 1){
            throw new IllegalArgumentException("You haven't registered any players.");
        }
    }

    */

}
