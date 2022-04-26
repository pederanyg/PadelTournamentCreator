package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.*;

import java.io.*;
import java.util.ArrayList;

public class PadelFileWriter {

    /**
     * Checks if the directory where files are stored exists, if not: creates the directory
     */
    public static void checkDirectory() {
        File recordsDir = new File(System.getProperty("user.home"), "PadelTournamentResults");
        if (! recordsDir.exists()) {
            recordsDir.mkdirs();
        }
    }

    public static void writeDoubleTournamentToFile(Tournament tournament) {
        if (tournament.getMatches().isEmpty()) {
            throw new IllegalArgumentException("The registry is empty.");
        }
        File file = new File(System.getProperty("user.home") + "/PadelTournamentResults/" + tournament.getName() + ".txt");

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)) {

            printer.println("Tournament name: " + tournament.getName());
            ArrayList<Team> allTeams = tournament.getTeams();
            printer.println();

            for (int i = 0; i < allTeams.size(); i++){
                printer.print("Team " + (i + 1) + ": " + allTeams.get(i).getTeamName() + ". Players: ");
                printer.println(allTeams.get(i).getPlayer1() + ", " + allTeams.get(i).getPlayer2());
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

    public static void writeSingleTournamentToFile(Tournament tournament) {
        if (tournament.getMatches().isEmpty()) {
            throw new IllegalArgumentException("The registry is empty.");
        }
        File file = new File(System.getProperty("user.home") + "/PadelTournamentResults/" + tournament.getName() + ".txt");

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)) {

            printer.println("Tournament name: " + tournament.getName());
            ArrayList<Team> allTeams = tournament.getTeams();
            printer.println();

            for (int i = 0; i < allTeams.size(); i++){
                printer.println("Team " + (i + 1) + ": " + allTeams.get(i).getTeamName());
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