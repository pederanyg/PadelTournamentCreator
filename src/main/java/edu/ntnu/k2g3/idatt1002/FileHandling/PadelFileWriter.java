package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.*;

import java.io.*;
import java.util.ArrayList;

public class PadelFileWriter {

    private static void checkDirectory() {
        File recordsDir = new File(System.getProperty("user.home"), "PadelTournamentResults");
        if (! recordsDir.exists()) {
            recordsDir.mkdirs();
        }
    }

    public static void writeTournamentToFile(Tournament tournament) {
        if (tournament.getMatches().isEmpty()) {throw new IllegalArgumentException("The registry is empty.");}
        checkDirectory();
        File file = new File(System.getProperty("user.home") + "/PadelTournamentResults/" + tournament.getName() + ".txt");

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)) {

            printer.println("Tournament name: " + tournament.getName());
            ArrayList<Team> allTeams = tournament.getTeams();
            printer.println();

            for (int i = 0; i < allTeams.size(); i++)
            if(tournament.isDoubles()){
                    printer.print("Team " + (i + 1) + ": " + allTeams.get(i).getTeamName() + ". Players: ");
                    printer.println(allTeams.get(i).getPlayer1() + ", " + allTeams.get(i).getPlayer2());
            }else {
                    printer.println("Player " + (i + 1) + ": " + allTeams.get(i).getTeamName());
            }
            printer.println();

            for (Match match : tournament.getMatches()) {
                printer.println(match.toString());
                printer.println();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}