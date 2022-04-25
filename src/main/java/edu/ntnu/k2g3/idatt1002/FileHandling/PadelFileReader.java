package edu.ntnu.k2g3.idatt1002.FileHandling;

import java.io.*;
import java.util.ArrayList;

public class PadelFileReader {

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
