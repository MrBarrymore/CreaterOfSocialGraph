package com.team3.CreaterOfSocialGraph.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DataGetterTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDataFromServer() throws IOException {
        DataGetter.getDataFromServer();
    }
}