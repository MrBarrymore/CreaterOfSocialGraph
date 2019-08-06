package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.SocialObjectToJsonConverter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.team3.CreaterOfSocialGraph.service.DataGetter.getDataFromServer;

@Component
public class SocialGraphBuilder {

    public static List<SocialObject> getListOfSocialObjects(RequestMessage requestMessage) throws IOException, InterruptedException {

        LinkedList<SocialObject> listOfSocialObjects = getDataFromServer(requestMessage);

        return listOfSocialObjects;
    }

    public static SocialGraph graphBuilder(List<SocialObject> listOfSocialObjects) throws IOException, InterruptedException {

        SocialGraph socialGraph = new SocialGraph();

        for (int i = 0; i < listOfSocialObjects.size(); i++) {
            socialGraph.addVertex(listOfSocialObjects.get(i).getId(), listOfSocialObjects.get(i));
        }

        // Далее ищем когорты в полученном графе

        return socialGraph;
    }


    public static String JsonGraphBuilder(SocialGraph socialGraph) throws IOException {

        String newJsonObjectsList = SocialObjectToJsonConverter.getNewJson(socialGraph.getAdjVertices());


       // ObjectMapper mapper = new ObjectMapper();
       // mapper.writeValue(new File(baseFile), newJsonObjectsList);

        try (FileWriter writer = new FileWriter(baseFile, false)){
            writer.write(newJsonObjectsList);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


        return newJsonObjectsList;
    }


   private final static String baseFile = "src\\main\\resources\\static\\js\\graph.json";

}
