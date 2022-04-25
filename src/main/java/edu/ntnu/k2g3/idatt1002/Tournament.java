package edu.ntnu.k2g3.idatt1002;

import java.util.*;

public class Tournament {
    private final ArrayList<Team> teams;
    private final String name;
    private final ArrayList<Match> matches;
    private boolean isDoubles;


    public Tournament(String name){
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean isDoubles(){
        return isDoubles;
    }

    public void setDoubles(boolean doubles){
        this.isDoubles = doubles;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Match> getMatches(){
        return matches;
    }

    public void addAll(ArrayList<Team> teamsToAdd){
        teams.addAll(teamsToAdd);
    }

    private void createMatches(ArrayList<Team> teams){
        for (int i = 0; i<(teams.size()); i+=2){
            matches.add(new Match(teams.get(i), teams.get(i+1)));
       }
    }

    public void createNewMatches(){
        if (matches.isEmpty()){
            Collections.shuffle(teams);
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
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(matches.size()-1), matches.get(matches.size()-2)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }
                    break;
                case 16:
                    if (matches.size() == 8){
                        createMatches(new ArrayList<>(matches.stream().map(Match::getWinner).toList()));
                    }
                    else if (matches.size() == 12){
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(matches.size()-1),matches.get(matches.size()-2), matches.get(matches.size()-3), matches.get(matches.size()-4)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }else if (matches.size() == 14){
                        ArrayList<Match> match = new ArrayList<>(Arrays.asList(matches.get(matches.size()-1), matches.get(matches.size()-2)));
                        createMatches(new ArrayList<>(match.stream().map(Match::getWinner).toList()));
                    }
                    break;}
        }
    }

}