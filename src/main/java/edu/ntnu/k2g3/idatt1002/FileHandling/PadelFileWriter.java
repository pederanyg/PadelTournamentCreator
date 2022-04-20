package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.Player;
import edu.ntnu.k2g3.idatt1002.PlayerRegistry;
import edu.ntnu.k2g3.idatt1002.Team;
import edu.ntnu.k2g3.idatt1002.TeamRegistry;

import java.io.*;
import java.util.ArrayList;

public class PadelFileWriter {

    public static void writePlayerRegistryToFile(String path, PlayerRegistry registry){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        if (registry.getPlayers().isEmpty()){throw new IllegalArgumentException("The registry is empty.");}
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)){
            printer.println("Player registry:");
            for (Player player: registry.getPlayers()){
               printer.println(player.getFirstName() + "," + player.getSurName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTeamRegistryToFile(String path, TeamRegistry registry){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        if (registry.getTeams().isEmpty()){throw new IllegalArgumentException("The registry is empty.");}
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)){
            printer.println("Team registry:");
            for (Team team: registry.getTeams()){
                printer.println(team.getTeamName() + "," + team.getPlayer1().getFirstName()
                        + "," + team.getPlayer1().getSurName() + "," + team.getPlayer2().getFirstName()
                        + "," + team.getPlayer2().getSurName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTeamNamesToFile(String path, ArrayList<String> teamNames){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        if (teamNames.isEmpty()){throw new IllegalArgumentException("There is no teams in this list");}
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter writer = new BufferedWriter(fileWriter);
             PrintWriter printer = new PrintWriter(writer)){
            printer.println("Team names");
            for (String teamName: teamNames){
                printer.println(teamName);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}