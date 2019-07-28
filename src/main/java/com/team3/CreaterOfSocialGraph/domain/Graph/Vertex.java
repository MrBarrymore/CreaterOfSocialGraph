package com.team3.CreaterOfSocialGraph.domain.Graph;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import lombok.Data;


@Data
public class Vertex {

    //@Id
    @JsonProperty("id")
    private int id;

   // public boolean isVisited;

    public Vertex(Integer id)
    {
        this.id = id;
    }

    public Vertex(SocialObject socialObject)
    {
        this.id = socialObject.getId();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}
