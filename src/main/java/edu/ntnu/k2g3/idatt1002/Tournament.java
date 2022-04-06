package edu.ntnu.k2g3.idatt1002;


import java.util.HashSet;
import java.util.Random;

public class Tournament {
    private HashSet<Team> teams;
    private String name;
    private HashSet<DoublesMatch> matches;

    public Tournament(HashSet<Team> teams, String name, HashSet<DoublesMatch> matches) {
        this.teams = teams;
        this.name = name;
        this.matches = matches;
    }

    /*public void createMatches(){
        Random rand = new Random();
       for (int i = 0; i<(teams.size()/2); i++){
           matches.add(new DoublesMatch(teams.));
       }
    }*/

}