package com.team3.CreaterOfSocialGraph.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.SocialObjectToJsonConverter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    public static List<SocialObject> getListOfSocialObjects() throws IOException, InterruptedException {

        LinkedList<SocialObject> listOfSocialObjects = getDataFromServer();

        return listOfSocialObjects;
    }

    public static String graphBuilder(List<SocialObject> listOfSocialObjects) throws IOException, InterruptedException {

        SocialGraph socialGraph = new SocialGraph();

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            socialGraph.addVertex(listOfSocialObjects.get(i).getId(), listOfSocialObjects.get(i));
        }

        // Здесь формируем новый Json файл и кидаем в скрипт на D3
        String newJsonObjectsList = SocialObjectToJsonConverter.getJson(socialGraph.getAdjVertices());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), newJsonObjectsList);


        // Далее ищем когорты в полученном графе



        // Строим и выводим на экран новый граф с учетом когорт

        return newJsonObjectsList;
    }

   private final static String baseFile = "src\\main\\resources\\static\\js\\graph.json";

}
