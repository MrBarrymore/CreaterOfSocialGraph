package com.team3.CreaterOfSocialGraph.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonToSocialObjectConverter {

    public SocialObject CovvertJsonToSocialObject(String jsonString)  throws IOException {


        // jsonString example
        // :[{"id":210700286,"first_name":"Lindsey","last_name":"Stirling", "friends": {363634, 457457, 54745745}},
        ObjectMapper mapper = new ObjectMapper();

        // convert from json
        SocialObject newSocialObject = mapper.readValue(jsonString, SocialObject.class);

        return newSocialObject;
    }

}
