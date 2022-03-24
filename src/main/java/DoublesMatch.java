public class DoublesMatch {

    private Team teamOne;
    private Team teamTwo;
    private Team winner;

    public DoublesMatch(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public void setDoublesResult(Team winner){
        if (winner.equals(teamOne)){
            this.winner = teamOne;
        }else{
            this.winner = teamTwo;}
    }

    @Override
    public String toString() {
        return "Match {" +
                "Team One = " + teamOne + " | Team Two = " + teamTwo + "}";
    }
}
