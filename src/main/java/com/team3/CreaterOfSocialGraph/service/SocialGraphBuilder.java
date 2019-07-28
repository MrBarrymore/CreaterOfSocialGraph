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
import java.util.List;
import java.util.Map;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    public static void graphBuilder() throws IOException {

        Map<Integer, SocialObject> listOfSocialObjects = getDataFromServer();

        SocialGraph socialGraph = new SocialGraph();

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            socialGraph.addVertex(listOfSocialObjects.get(i));
        }

     // System.out.println(socialGraph.getAdjVertices());

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            for (String friend : listOfSocialObjects.get(i).getFriendsList()) {
                socialGraph.addEdge(listOfSocialObjects.get(i).getId(), friend);
            }
        }

        // Здесь формируем новый Json файл и кидаем в скрипт на D3
        JSONObject newJsonObjectsList = SocialObjectToJsonConverter.ConvertSocialGraphToJson(socialGraph);


        toJSON(socialGraph);

        listOfSocialObjects.size();
      //  socialGraph.getAdjVertices();

        // Далее ищем когорты в полученном графе

        // Строим и выводим на экран новый граф с учетом когорт
    }

    private final static String baseFile = "src\\main\\resources\\static\\js\\graph.json";

    public static void toJSON(SocialGraph socialGraph) throws IOException {

        Map<Vertex, List<Vertex>> vartexs = socialGraph.getAdjVertices();


        String json = "{  "  ;
        ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < vartexs.size(); i++) {

            json +=  "\" nodes: \": [";
         //   for (vartexs.get(i) )
            //"{ \"name\": \"" + vartexs.get(i) + "\", \"children\": [ ";
        }

        System.out.println(json);


        mapper.writeValue(new File(baseFile), vartexs);


     //   System.out.println("json created!");
        System.out.println();

    }

}
