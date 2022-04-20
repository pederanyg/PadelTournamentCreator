package edu.ntnu.k2g3.idatt1002.FileHandling;

import edu.ntnu.k2g3.idatt1002.Player;
import edu.ntnu.k2g3.idatt1002.PlayerRegistry;
import edu.ntnu.k2g3.idatt1002.Team;
import edu.ntnu.k2g3.idatt1002.TeamRegistry;

import java.io.*;
import java.util.ArrayList;

public class PadelFileReader {

    public static PlayerRegistry readPlayerRegistryFromFile(String path){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        PlayerRegistry registry = new PlayerRegistry();
        File fileToRead = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))){
            String line = reader.readLine();
            while ((line = reader.readLine()) != null ){
                String [] list = line.split(",");
                registry.addNewPlayer(list[0], list[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return registry;
    }

    public static TeamRegistry readTeamRegistryFromFile(String path){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        TeamRegistry registry = new TeamRegistry();
        File fileToRead = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))){
            String line = reader.readLine();
            while ((line = reader.readLine()) != null ){
                String [] list = line.split(",");
                registry.addNewTeam(list[0], new Player(list[1], list[2]), new Player(list[3], list[4]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return registry;
    }

    public static ArrayList<String> readTeamNames(String path){
        if (path.isBlank()){throw new IllegalArgumentException("Path must be specified.");}
        ArrayList<String> list = new ArrayList<>();
        File fileToRead = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))){
            String line = reader.readLine();
            while ((line = reader.readLine()) != null ){
                list.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }



}
