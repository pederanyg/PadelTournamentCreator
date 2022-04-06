package edu.ntnu.k2g3.idatt1002;

import java.util.HashSet;

public class TeamRegistry {

    private final HashSet<Team> teams;

    public TeamRegistry(){
        teams = new HashSet<>();
    }

    public HashSet<Team> getTeams() {
        return teams;
    }

    public boolean addNewTeam(String teamName, Player player1, Player player2){
        return teams.add(new Team(teamName, player1, player2));
    }

    public boolean removeTeam(String teamName){
        for (Team team: teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)){
                return teams.remove(team);
            }
        }
        return false;
    }


}