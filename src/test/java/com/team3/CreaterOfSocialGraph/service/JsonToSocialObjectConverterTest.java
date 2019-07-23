package com.team3.CreaterOfSocialGraph.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JsonToSocialObjectConverterTest {

//    @Mock
//    private JsonToSocialObjectConverter

    @InjectMocks
    JsonToSocialObjectConverter sut;

    @Before
    public void setUp() throws Exception {
        sut = new JsonToSocialObjectConverter();
    }


    @Test
    public void covvertJsonToSocialObject() throws Exception{
        JsonToSocialObjectConverter.CovvertJsonToSocialObject();
    }
}