package com.team3.CreaterOfSocialGraph.service.helper;

import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SocialObjectToJsonConverterTest {

    private static String FILE_NAME = "JsonTest.json"; // Статический заданый источник для тестов
    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void getJson() throws JSONException, IOException, InterruptedException {
        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects();
        SocialGraph socialGraph = SocialGraphBuilder.graphBuilder(listOfSocialObjects);
        SocialGraphBuilder.JsonGraphBuilder(socialGraph);
    }
}