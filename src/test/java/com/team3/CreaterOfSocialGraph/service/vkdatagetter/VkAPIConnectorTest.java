package com.team3.CreaterOfSocialGraph.service.vkdatagetter;

import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import org.junit.Before;
import org.junit.Test;

public class VkAPIConnectorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getVkObjects() throws InterruptedException {
        RequestMessage requestMessage = new RequestMessage("university", "АлтГТУ");
        VkAPIConnector.getVkObjects(requestMessage);
    }
}