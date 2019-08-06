package com.team3.CreaterOfSocialGraph.service;

import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.service.helper.JsonToSocialObjectConverter;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.team3.CreaterOfSocialGraph.service.helper.IOHelper.parseUrl;

@RunWith(MockitoJUnitRunner.class)
public class JsonToSocialObjectConverterTest {

    private static String FILE_NAME = "JsonTest.json"; // Статический заданый источник для тестов

    @InjectMocks
    JsonToSocialObjectConverter sut;

    @Before
    public void setUp() throws Exception {
        sut = new JsonToSocialObjectConverter();
    }


    @Test
    public void covvertJsonToSocialObject() throws Exception{
        String resultJson = parseUrl(FILE_NAME);
        RequestMessage requestMessage = new RequestMessage("universaty", "АлтГТУ им. И.И. Ползунова");
        JSONArray listOfSocialObjectsJSON = new JSONArray(resultJson);
        JsonToSocialObjectConverter.CovvertJsonToSocialObjects(listOfSocialObjectsJSON, requestMessage);
    }
}