package edu.ntnu.k2g3.idatt1002;

import java.util.ArrayList;

public class TeamRegistry {

    public ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Team addNewTeam(String teamName, Player player1, Player player2){
        Team newTeam = new Team(teamName, player1, player2);
        teams.add(newTeam);
        return newTeam;
    }


}