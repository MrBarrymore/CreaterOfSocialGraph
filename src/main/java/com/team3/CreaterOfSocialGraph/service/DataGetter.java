package com.team3.CreaterOfSocialGraph.service;

import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.JsonToSocialObjectConverter.CovvertJsonToSocialObjects;
import static com.team3.CreaterOfSocialGraph.service.helper.IOHelper.parseUrl;

public class DataGetter {

    private static String FILE_NAME = "E:\\Lessons Java\\Practice\\CreaterOfSocialGraph\\JsonTest.json"; // Статический заданый источник для тестов

    public static LinkedList<SocialObject> getDataFromServer() throws IOException {


        String resultJson = parseUrl(FILE_NAME);
        JSONObject listOfSocialObjectsJSON = new JSONObject(resultJson);

       LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON);

       return listOfSocialObjects;
    }


}
