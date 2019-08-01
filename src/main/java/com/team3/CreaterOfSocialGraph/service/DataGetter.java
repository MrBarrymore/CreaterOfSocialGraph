package com.team3.CreaterOfSocialGraph.service;

//import com.google.gson.JsonArray;

//import com.google.gson.JsonArray;

import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONArray;

import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.helper.IOHelper.parseUrl;
import static com.team3.CreaterOfSocialGraph.service.helper.JsonToSocialObjectConverter.CovvertJsonToSocialObjects;



public class DataGetter {

    private static String FILE_NAME = "E:\\Lessons Java\\Practice\\CreaterOfSocialGraph\\JsonTest.json"; // Статический заданый источник для тестов


    public static LinkedList<SocialObject> getDataFromServer() throws IOException, InterruptedException {

        String resultJson = parseUrl(FILE_NAME);


         JSONArray listOfSocialObjectsJSON = new JSONArray(resultJson);

        LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON);

      //  JsonArray bufarray = VkAPIConnector.getVkObjects();

       // String arr = bufarray.toString();

       // JSONArray listOfSocialObjectsJSON =  new JSONArray(arr);


       // Map<Integer, SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON);

        return listOfSocialObjects;
    }


}
