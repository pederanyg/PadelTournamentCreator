package edu.ntnu.k2g3.idatt1002;


import edu.ntnu.k2g3.idatt1002.Matches.Match;

import java.util.*;

public class Tournament {
    private HashSet<Team> teams;
    private String name;
    private HashSet<Match> matches;
    private boolean singlesOrDoubles;

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