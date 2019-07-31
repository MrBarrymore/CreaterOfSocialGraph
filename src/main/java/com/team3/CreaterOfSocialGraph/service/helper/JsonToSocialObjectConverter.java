package com.team3.CreaterOfSocialGraph.service.helper;


import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Component
public class JsonToSocialObjectConverter {

    public static Map<Integer, SocialObject> CovvertJsonToSocialObjects(JSONArray listOfSocialObjects)
            throws IOException {

        Map<Integer, SocialObject> SocialObjects = new HashMap<>();

        JSONArray arrayOfSocialObjects = listOfSocialObjects;

        for (int i = 0; i < arrayOfSocialObjects.length(); i++) {
            SocialObject bufsocialObject = getSocialObject((JSONObject) arrayOfSocialObjects.get(i));
            bufsocialObject.setInId(i);
            SocialObjects.put(bufsocialObject.getInId(), bufsocialObject);
        }

        return SocialObjects;
    }

    private static SocialObject getSocialObject(JSONObject personJsonObject ) {

        SocialObject newSocialObject = new SocialObject();
        try {

            //JSONObject personData = (JSONObject) personJsonObject.get("information");
            // Получаем id, имя и фамилию
            newSocialObject.setId( Integer.toString((Integer) personJsonObject.get("id"))  );
            newSocialObject.setLastname((String) personJsonObject.get("last_name"));
            newSocialObject.setName((String) personJsonObject.get("first_name"));

            // Получаем название университета
            JSONObject cityData = (JSONObject) personJsonObject.get("city");
                if (cityData != null) newSocialObject.setCity((String) cityData.get("title"));

            // Получаем название университета
            JSONArray universityData = (JSONArray) personJsonObject.get("universities");
            if (universityData != null) {
                JSONObject firstUniversityData = (JSONObject) universityData.get(0);
                newSocialObject.setUniversity((String) firstUniversityData.get("name"));
            }

     //       JSONArray schoolData = (JSONArray) personJsonObject.get("schools");
       //     JSONObject firstSchoolData = (JSONObject) schoolData.get(0);
       //     newSocialObject.setSchool((String) firstSchoolData.get("name"));

            LinkedList<Integer> friendsArray = new LinkedList<>();

            JSONArray fiends = (JSONArray) personJsonObject.get("friends");
            if (fiends != null)
                for (int i = 0; i < (int) fiends.length(); i++) {
                    friendsArray.add((int) fiends.get(i));
                    newSocialObject.addFriendsList(String.valueOf(fiends.get(i)));
                }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return newSocialObject;
    }
}
