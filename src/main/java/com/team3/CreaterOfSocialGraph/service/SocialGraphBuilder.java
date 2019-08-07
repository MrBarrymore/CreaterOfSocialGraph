package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.SocialObjectToJsonConverter;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    private final static String baseFile = "src\\main\\resources\\static\\js\\graph.json";

    public static List<SocialObject> getListOfSocialObjects(RequestMessage requestMessage) throws IOException, InterruptedException, ClientException {

        LinkedList<SocialObject> listOfSocialObjects = getDataFromServer(requestMessage);

        return listOfSocialObjects;
    }

    public static SocialGraph graphBuilder(List<SocialObject> listOfSocialObjects) throws IOException, InterruptedException {

        SocialGraph socialGraph = new SocialGraph();

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            socialGraph.addVertex(listOfSocialObjects.get(i).getId(), listOfSocialObjects.get(i));
        }

        return socialGraph;
    }


    public static SocialGraph rebuiltSocialGraph(SocialGraph socialGraph, String Rating ) {

        int needRating = Integer.valueOf(Rating);

        SocialGraph newSocialGraph = new SocialGraph();
        Map<Long, SocialObject> socialObjectMap = socialGraph.getAdjVertices();

        Long count = 0L;
        for (Long key : socialObjectMap.keySet()) {
            if (socialObjectMap.get(key).getRating() >= needRating) {
                newSocialGraph.addVertex(socialObjectMap.get(key).getId(), socialObjectMap.get(key));
                newSocialGraph.getAdjVertices().get(key).setInId(count);
                count++;
            }
        }

        return newSocialGraph;
    }

    public static String JsonGraphBuilder(SocialGraph socialGraph) throws IOException {

        String newJsonObjectsList = SocialObjectToJsonConverter.getNewJson(socialGraph.getAdjVertices());

//        // Запись нового Json файла
//        try (FileWriter writer = new FileWriter(baseFile, false)){
//            writer.write(newJsonObjectsList);
//            writer.flush();
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }

        return newJsonObjectsList;
    }

}
