package com.team3.CreaterOfSocialGraph.service.helper;


import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

@Component
public class JsonToSocialObjectConverter {

    public static LinkedList CovvertJsonToSocialObjects(JSONArray listOfSocialObjects, RequestMessage requestMessage)
            throws IOException {

        LinkedList SocialObjects = new LinkedList();
        JSONArray arrayOfSocialObjects = listOfSocialObjects;

        for (int i = 0; i < arrayOfSocialObjects.length(); i++) {
            SocialObject bufsocialObject = getSocialObject((JSONObject) arrayOfSocialObjects.get(i), requestMessage);
                bufsocialObject.setInId(Long.parseLong(String.valueOf(i)));
            SocialObjects.add(bufsocialObject);
        }

        return SocialObjects;
    }

    private static SocialObject getSocialObject(JSONObject personJsonObject, RequestMessage requestMessage) {

        SocialObject newSocialObject = new SocialObject();
        try {

            //JSONObject personData = (JSONObject) personJsonObject.get("information");
            // Получаем id, имя и фамилию
            newSocialObject.setId( Long.parseLong( String.valueOf(personJsonObject.get("id"))) ); // Здесь косяк
            newSocialObject.setLastname((String) personJsonObject.get("last_name"));
            newSocialObject.setName((String) personJsonObject.get("first_name"));

            newSocialObject.setRating(0);

            // Получаем название города
            if( personJsonObject.has("city") && personJsonObject.get("city") != JSONObject.NULL ) {
                JSONObject cityData = (JSONObject) personJsonObject.get("city");
                if (cityData != null) {
                    newSocialObject.setCity((String) cityData.get("title"));

                    // Определяем группу принадлежности
                    if (Objects.equals(requestMessage.getAttributeName(),"city")) {
                        if (Objects.equals(cityData.get("title"), requestMessage.getName())) {
                            newSocialObject.setRating(100);
                        }
                    }
                }
            }else {
                newSocialObject.setCity((String) "город не указан");
            }

            // Получаем название университета
            if( personJsonObject.has("universities") && personJsonObject.get("universities") != JSONObject.NULL){

                JSONArray universityData = (JSONArray) personJsonObject.get("universities");
                if (universityData.length() > 0) {
                    JSONObject firstUniversityData = (JSONObject) universityData.get(0);
                    newSocialObject.setUniversity((String) firstUniversityData.get("name"));

                    // Определяем группу принадлежности
                    if ( Objects.equals(requestMessage.getAttributeName().toString(),"university")) {
                        if (((String) firstUniversityData.get("name")).toLowerCase().contains(requestMessage.getName().toLowerCase())) {
                            newSocialObject.setRating(100);
                        }
                    }
                }
            } else {
                newSocialObject.setUniversity((String) "университет не указан");
            }

            if( personJsonObject.has("schools") && personJsonObject.get("schools") != JSONObject.NULL ) {
                JSONArray schoolData = new JSONArray();
                if (personJsonObject.get("schools") != JSONObject.NULL) schoolData = (JSONArray) personJsonObject.get("schools");
                if (schoolData.length() > 0) {
                    JSONObject firstSchoolData = (JSONObject) schoolData.get(0);
                    newSocialObject.setSchool((String) firstSchoolData.get("name"));

                    // Определяем группу принадлежности
                    if (Objects.equals(requestMessage.getAttributeName().toString(),"school")) {
                        if (((String) firstSchoolData.get("name")).toLowerCase().contains(requestMessage.getName().toLowerCase())) {
                            newSocialObject.setRating(100);
                        }
                    }
                }
            }
            else {
                newSocialObject.setSchool((String) "школа не указана");
            }

            newSocialObject.setPhotoLink((String)personJsonObject.get("photo_50"));


            newSocialObject.setPageLink("https://vk.com/id" + newSocialObject.getId().toString());



            JSONArray fiends = (JSONArray) personJsonObject.get("friends");
            if (fiends != null)
                for (int i = 0; i < fiends.length(); i++) {
                    Long.parseLong( String.valueOf(personJsonObject.get("id")));
                    newSocialObject.addFriendsList(Long.parseLong( String.valueOf(fiends.get(i))));
                }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        return newSocialObject;
    }
}
