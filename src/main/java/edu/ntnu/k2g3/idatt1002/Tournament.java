package edu.ntnu.k2g3.idatt1002;

import java.util.*;

public class Tournament {
    private ArrayList<Team> teams;
    private final String name;
    private ArrayList<Match> matches;
    private boolean singlesOrDoubles;

    public Tournament(String name){
        this.name = name;
    }

    public Tournament(ArrayList<Team> teams, String name, ArrayList<Match> matches) {
        this.teams = teams;
        this.name = name;
        this.matches = matches;
    }

    public boolean isSinglesOrDoubles(){
        return singlesOrDoubles;
    }

    public String getName(){
        return name;
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

    private void createMatches(ArrayList<Team> teams){
        Collections.shuffle(teams);
        for (int i = 0; i<(teams.size()); i+=2){
            matches.add(new Match(teams.get(i), teams.get(i+1)));
       }
    }

    public void createNewMatches(){
        if (matches.isEmpty()){
            createMatches(teams);
        }else{
            switch (teams.size()){
                case 4:
                    createMatches(new ArrayList<>(matches.stream().map(Match::getWinner).toList()));
                    break;
                case 8:
                    if (matches.size() == 4){
                        createMatches(new ArrayList<>(matches.stream().map(Match::getWinner).toList()));
                    }
                    else if (matches.size() == 6){
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(-1), matches.get(-2)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }
                    break;
                case 16:
                    if (matches.size() == 8){
                        createMatches(new ArrayList<>(matches.stream().map(Match::getWinner).toList()));
                    }
                    else if (matches.size() == 12){
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(-1),matches.get(-2), matches.get(-3), matches.get(-4)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }else if (matches.size() == 14){
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(-1), matches.get(-2)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }
                    break;}
        }
    }

}