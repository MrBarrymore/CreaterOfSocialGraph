package com.team3.CreaterOfSocialGraph.service;

import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SocialGraphBuilderTest {

    @Before
    public void setUp() throws Exception {
        SocialGraphBuilder socialGraphBuilder = new SocialGraphBuilder();
    }

    @Test
    public void graphBuilder() throws IOException, InterruptedException {
        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects();
        SocialGraphBuilder.graphBuilder(listOfSocialObjects);
    }
}