package com.team3.CreaterOfSocialGraph.domain.Graph;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class Vertex {

    //@Id
    @JsonProperty("id")

    private Map<Integer, SocialObject> socialObjectDTO;

    private SocialObject socialObject;

    // public boolean isVisited;

    public Vertex()
    {
        socialObjectDTO = new HashMap<>();
    }

    public Vertex(Integer id, SocialObject socialObject)
    {
        this.socialObjectDTO.putIfAbsent(id, socialObject);
    }


}
