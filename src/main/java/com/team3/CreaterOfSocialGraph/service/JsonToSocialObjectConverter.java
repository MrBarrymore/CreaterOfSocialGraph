package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;

@Component
public class JsonToSocialObjectConverter {

    public static LinkedList<SocialObject> CovvertJsonToSocialObjects(JSONObject listOfSocialObjects) throws IOException {

        LinkedList<SocialObject> SocialObjects = new LinkedList<>();

        JSONArray arrayOfSocialObjects = (JSONArray) listOfSocialObjects.get("listOfSocialObjects");

        for (int i = 0; i < arrayOfSocialObjects.length(); i++) {
            SocialObjects.add(getSocialObject((JSONObject) arrayOfSocialObjects.get(i)));
        }

        return SocialObjects;
    }

    private static SocialObject getSocialObject(JSONObject personJsonObject ) {

        SocialObject newSocialObject = new SocialObject();
        try {

            JSONObject personData = (JSONObject) personJsonObject.get("information");

            // Получаем id, имя и фамилию
            newSocialObject.setId((int) personData.get("id"));
            newSocialObject.setSurname((String) personData.get("last_name"));
            newSocialObject.setName((String) personData.get("first_name"));

            // Получаем название университета
            JSONArray universityData = (JSONArray) personData.get("universities");
            JSONObject firstUniversityData = (JSONObject) universityData.get(0);
                newSocialObject.setUniversity((String) firstUniversityData.get("name"));

            JSONArray schoolData = (JSONArray) personData.get("schools");
            JSONObject firstSchoolData = (JSONObject) schoolData.get(0);
            newSocialObject.setSchool((String) firstSchoolData.get("name"));

            JSONObject fiends = (JSONObject) personJsonObject.get("friends");

            // Для уточнения информации
//            System.out.println("ID пользователя: " + personData.get("id"));
//            System.out.println("Имя: " + personData.get("first_name"));
//            System.out.println("Фамилия: " + personData.get("last_name"));
//            System.out.println("Школа: " + firstSchoolData.get("name"));
//            System.out.println("Университет: " + firstUniversityData.get("name"));
//            System.out.println("Количество друзей: " + fiends.get("count"));

            LinkedList<Integer> friendsArray = new LinkedList<>();

            JSONArray fiendsArray = (JSONArray) fiends.get("items");
            for (int i = 0; i < (int) fiends.get("count"); i++) {
                friendsArray.add((int) fiendsArray.get(i));
             //   System.out.println(fiendsArray.get(i));
                newSocialObject.addFriendsList(String.valueOf(fiendsArray.get(i)));
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return newSocialObject;
    }
}
