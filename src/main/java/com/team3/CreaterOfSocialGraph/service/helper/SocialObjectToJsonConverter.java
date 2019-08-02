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

        String newjson = "{ \"nodes\": [ ";
        for (int i = 0; i < listOfSocialObjects.size(); i++) {

            newjson += "{ \"name\": \"" + listOfSocialObjects.get(i).getId() + "\", " +
                    " \"group\": 1}";

            if (i != listOfSocialObjects.size() - 1) newjson += ", ";

        }
        newjson += "], \"links\" : [";

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            for (int j = 0; j < listOfSocialObjects.get(i).getFriendsList().size(); j++) {

                newjson += "{ \"source\": \"" + listOfSocialObjects.get(i).getId() + "\", \"target\": \"" +
                        listOfSocialObjects.get(i).getFriendsList().get(j) + "\", ";
                newjson += "\"value\": 1 }";

                if (i != listOfSocialObjects.size() - 1 || j != listOfSocialObjects.get(i).getFriendsList().size() - 1 ) newjson += ",";

            }
        }
        newjson += "] }";

        newjson = newjson.replaceAll("\"", "\\\"");


        System.out.println(newjson);

        return newjson;
    }

    /*    public static String toJSON(SocialGraph socialGraph) throws IOException {

        Map<Vertex, List<Vertex>> vertexs = socialGraph.getAdjVertices();

        ObjectMapper mapper = new ObjectMapper();


        Map<Integer, List<Integer>> newmap = vertexs.entrySet()
                .stream()
                .collect(Collectors.toMap(o -> o.getKey().getId(),
                        o2 -> o2.getValue().stream()
                                .map(Vertex::getId)
                                .collect(Collectors.toList())));



        String jsonstring = mapper.writeValueAsString(newmap);
        System.out.println(jsonstring);

        mapper.writeValue(new File(baseFile), vertexs);

        return jsonstring;
    }*/


}
