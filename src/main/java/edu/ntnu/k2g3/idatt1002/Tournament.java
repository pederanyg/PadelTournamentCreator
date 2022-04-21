package edu.ntnu.k2g3.idatt1002;


import edu.ntnu.k2g3.idatt1002.Match;

import java.util.*;

public class Tournament {
    private ArrayList<Team> teams;
    private String name;
    private HashSet<Match> matches;
    private boolean singlesOrDoubles;

    public Tournament(String name){
        this.name = name;
    }

    public Tournament(ArrayList<Team> teams, String name, HashSet<Match> matches) {
        this.teams = teams;
        this.name = name;
        this.matches = matches;
    }

    public void setSinglesOrDoubles(boolean doubles){
        this.singlesOrDoubles = doubles;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public void addAll(ArrayList<Team> teamsToAdd){
        teams.addAll(teamsToAdd);
    }

    public void createMatches(){
        Collections.shuffle(teams);
        for (int i = 0; i<(teams.size()); i+=2){
            matches.add(new Match(teams.get(i), teams.get(i+1)));
       }
    }


}