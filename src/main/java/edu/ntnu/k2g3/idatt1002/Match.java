package edu.ntnu.k2g3.idatt1002;

public class Match {

    private final Team team1, team2;
    public Team winner;
    private String result;

    public Match(Team one, Team two){
        this.team1 = one;
        this.team2 = two;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getResult() {
        return result;
    }

    public Team getWinner(){return winner;}

    public void setResult(int one, int two, Team winner){
        this.winner = winner;
        this.result = one + "-" + two;
    }

    @Override
    public String toString() {
        return "Match between " + team1.getTeamName() + "and" + team2.getTeamName() +
                '\n' + "Result: " + result;
    }
}

