package com.team3.CreaterOfSocialGraph.service.helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.domain.jsondto.JsonDTO;
import com.team3.CreaterOfSocialGraph.domain.jsondto.LinkDTO;
import com.team3.CreaterOfSocialGraph.domain.jsondto.NodeDTO;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SocialObjectToJsonConverter {

    public static String getNewJson(Map<Long, SocialObject> listOfSocialObjects) {

        String newjson = "";

        JsonDTO jsonDTO = new JsonDTO();

        for (Long key : listOfSocialObjects.keySet()) {
            jsonDTO.addNode(new NodeDTO(listOfSocialObjects.get(key).getId(),listOfSocialObjects.get(key).getLastname()
                    + " " + listOfSocialObjects.get(key).getName(),
                    listOfSocialObjects.get(key).getRating(),
                    listOfSocialObjects.get(key).getPhotoLink()));
        }

        for (Long key : listOfSocialObjects.keySet()) {
            for (int i = 0; i < listOfSocialObjects.get(key).getFriendsList().size(); i++) {
                if (listOfSocialObjects.containsKey(listOfSocialObjects.get(key).getFriendsList().get(i))) {
                    jsonDTO.addLink(new LinkDTO(listOfSocialObjects.get(key).getInId(),
                            listOfSocialObjects.get(listOfSocialObjects.get(key).getFriendsList().get(i)).getInId(), 5, 1));
                }
            }
        }

        newjson = ConvertSocialGraphToJson(jsonDTO);
        return newjson;
    }


    public static String ConvertSocialGraphToJson(JsonDTO socialGraph) {

        JSONObject newJsonObjects = new JSONObject();
        String JASON = "";
        ObjectMapper om = new ObjectMapper();
        try {
            JASON = om.writeValueAsString(socialGraph);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return JASON;
    }

}
