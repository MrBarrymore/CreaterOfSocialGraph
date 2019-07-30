package com.team3.CreaterOfSocialGraph.service.helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONObject;

import java.util.Map;

public class SocialObjectToJsonConverter {


    public static String ConvertSocialGraphToJson(SocialGraph socialGraph) {

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

    public static String getJson(Map<Integer, SocialObject> listOfSocialObjects) {

     //   String baseFile = "src\\main\\resources\\static\\js\\graph.json";

        String newjson = "{ \"nodes\": [ \"";
        for (int i = 0; i < listOfSocialObjects.size(); i++) {

            newjson += "{ \"id\": \"" + listOfSocialObjects.get(i).getId() + "\", " +
                    " \"group:\" 1}";

            if (i != listOfSocialObjects.size() - 1) newjson += ", \n";
            else newjson += "\n";
        }
        newjson += "], \n \"links\" : [";

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            for (int j = 0; j < listOfSocialObjects.get(i).getFriendsList().size(); j++) {

                newjson += "{ \"source\": \"" + listOfSocialObjects.get(i).getId() + "\", \"target\": \"" +
                        listOfSocialObjects.get(i).getFriendsList().get(j) + "\"";
                newjson += "\"value\": 1 }";

                if (i != listOfSocialObjects.size() - 1 || j != listOfSocialObjects.get(i).getFriendsList().size() - 1 ) newjson += ", \n";
                else newjson += "\n";
            }
        }
        newjson += "] \n }";

        System.out.println(newjson);
        return newjson;
    }


}
