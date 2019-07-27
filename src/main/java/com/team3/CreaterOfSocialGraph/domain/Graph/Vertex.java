package com.team3.CreaterOfSocialGraph.domain.Graph;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import lombok.Data;

import javax.persistence.Id;


@Data
public class Vertex {

    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String last_name;
    @JsonProperty("name")
    private String first_name;
    @JsonProperty("photoLink")
    private String photoLink;
    @JsonProperty("objectGroup")
    private String groupOfObject;
    @JsonProperty("pageLink")
    private String pageLink;

   // private LinkedList<String> friendsList;

    public boolean isVisited;

    public Vertex(String name)
    {
        this.id = 0;
        this.first_name = name;
        isVisited = false;
    }

    public Vertex(SocialObject socialObject)
    {
        this.id = socialObject.getId();
        this.last_name = socialObject.getLastname();
        this.first_name = socialObject.getName();
        this.photoLink = socialObject.getPhotoLink();
        isVisited = false;
    }


    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}
