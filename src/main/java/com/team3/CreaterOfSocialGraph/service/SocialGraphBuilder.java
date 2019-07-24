package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    public static void graphBuilder() throws IOException {

        LinkedList<SocialObject> listOfSocialObjects = getDataFromServer();

        SocialGraph socialGraph = new SocialGraph();

        for (SocialObject socialObject : listOfSocialObjects) {
            socialGraph.addVertex(Integer.toString(socialObject.getId()));
        }

        for (SocialObject socialObject : listOfSocialObjects) {
            for (String friend : socialObject.getFriendsList()) {
                socialGraph.addEdge(Integer.toString(socialObject.getId()), friend);
            }
        }


        // Здесь формируем новый Json файл и кидаем в скрипт на D3

        // Далее ищем когорты в полученном графе

        // Строим и выводим на экран новый граф с учетом когорт
    }

}
