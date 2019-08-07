package com.team3.CreaterOfSocialGraph.service.helper;


import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOHelper {

    public static String parseUrl(String url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {

            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void writeFile(String baseFile, String newJsonObjectsList) {

        // Запись нового Json файла
        try (FileWriter writer = new FileWriter(baseFile, false)){
            writer.write(newJsonObjectsList);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile(String FILE_NAME, JSONArray listOfSocialObjectsJSON) {

        try (FileWriter writer = new FileWriter(FILE_NAME, false)){
            writer.write(listOfSocialObjectsJSON.toString());
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
