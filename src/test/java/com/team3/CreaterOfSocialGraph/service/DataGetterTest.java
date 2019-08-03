package com.team3.CreaterOfSocialGraph.service;

import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DataGetterTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDataFromServer() throws IOException, InterruptedException {
        RequestMessage requestMessage = new RequestMessage("university", "АлтГТУ");
        DataGetter.getDataFromServer(requestMessage);
    }
}