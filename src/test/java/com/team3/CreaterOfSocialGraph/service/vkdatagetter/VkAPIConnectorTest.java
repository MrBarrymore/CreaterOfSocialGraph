package com.team3.CreaterOfSocialGraph.service.vkdatagetter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VkAPIConnectorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getVkObjects() throws InterruptedException {
        VkAPIConnector.getVkObjects();
    }
}