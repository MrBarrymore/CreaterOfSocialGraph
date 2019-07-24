package com.team3.CreaterOfSocialGraph.service.helper;


import java.io.BufferedReader;
import java.io.FileReader;
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
}
