package com.team3.CreaterOfSocialGraph.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.Graph.Vertex;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.SocialObjectToJsonConverter;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    public static void graphBuilder() throws IOException {

        LinkedList<SocialObject> listOfSocialObjects = getDataFromServer();

        SocialGraph socialGraph = new SocialGraph();

        for (SocialObject socialObject : listOfSocialObjects) {
            socialGraph.addVertex(socialObject);
        }

/*        for (SocialObject socialObject : listOfSocialObjects) {
            for (String friend : socialObject.getFriendsList()) {
                socialGraph.addEdge(Integer.toString(socialObject.getId()), friend);
            }
        }*/

        System.out.println(socialGraph.getAdjVertices());

      for (SocialObject socialObject : listOfSocialObjects) {
            for (String friend : socialObject.getFriendsList()) {
                socialGraph.addEdge(Integer.toString(socialObject.getId()), friend);
            }
        }

        // Здесь формируем новый Json файл и кидаем в скрипт на D3
        JSONObject newJsonObjectsList = SocialObjectToJsonConverter.ConvertSocialGraphToJson(socialGraph);



      //  socialGraph.getAdjVertices();

        // Далее ищем когорты в полученном графе

        // Строим и выводим на экран новый граф с учетом когорт
    }

    private final static String baseFile = "user.json";

    public static void toJSON(Vertex vertex) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), vertex);
        System.out.println("json created!");

    }

}
