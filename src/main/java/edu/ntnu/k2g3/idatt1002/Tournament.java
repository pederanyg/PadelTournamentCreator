package edu.ntnu.k2g3.idatt1002;

import java.util.*;

/**
 * Represents a Tournament.
 *
 * @author jenscl, annamarieboetvedt, williamlie
 */
public class Tournament {
    private final ArrayList<Team> teams;
    private final String name;
    private final ArrayList<Match> matches;
    private boolean isDoubles;


    /**
     * Constructor for instantiating a new tournament
     * A Tournament has a name, a list of the teams playing and a list of the matches in the tournament
     * It can be either a singles tournament or a doubles tournament
     *
     * @param name The name of the tournament
     */
    public Tournament(String name){
        if (name.isBlank()) {
            throw new IllegalArgumentException("The Tournament needs a name!");
        }
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.name = name;
    }

    /**
     * Method for getting the name of a tournament
     *
     * @return The name of the tournament
     */
    public String getName(){
        return name;
    }

    /**
     * Method for checking if the tournament is singles or doubles
     *
     * @return True if the tournament is a doubles tournament, false if it is a singles tournament
     */
    public boolean isDoubles(){
        return isDoubles;
    }

    /**
     * Method for setting the tournament to either being a doubles or a singles tournament
     *
     * @param doubles A boolean being true/false depending on the type of the tournament
     */
    public void setDoubles(boolean doubles){
        this.isDoubles = doubles;
    }

    /**
     * Method for adding a team to the list of teams playing in the tournament
     *
     * @param team The team to be added
     */
    public void addTeam(Team team){
        teams.add(team);
    }

    /**
     * Method for getting the list of teams in the tournament
     *
     * @return An ArrayList of the teams playing in the tournament
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Method for getting the list of matches in the tournament
     *
     * @return An ArrayList of the matches in the tournament
     */
    public ArrayList<Match> getMatches(){
        return matches;
    }

    /**
     * Method for adding a list of teams to the tournament's list of teams
     *
     * @param teamsToAdd The list of teams to be added
     */
    public void addAll(ArrayList<Team> teamsToAdd){
        teams.addAll(teamsToAdd);
    }

    /**
     * Method for creating matches in the tournament
     * The method creates matches by iterating through the list of teams
     * and creating matches
     * @param teams The list of teams to be used to create matches
     */

    private void createMatches(ArrayList<Team> teams){
        for (int i = 0; i<(teams.size()); i+=2){
            matches.add(new Match(teams.get(i), teams.get(i+1)));
       }
    }

    /**
     * Method used for creating new matches for the tournament
     * If there are no matches in the list of matches, the list of teams is shuffled and createMatches method is
     * called using the list of teams as the input
     *
     * If the tournament has progressed, it creates new matches based on the winners from the previous matches
     *
     */
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
                    break;
            }
        }
    }

}