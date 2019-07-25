package com.team3.CreaterOfSocialGraph.domain.Graph;


import lombok.Data;

import javax.persistence.Id;


@Data
public class Vertex {

    @Id
  //  @JsonIgnore
    private int id;
  //  @JsonProperty("name")
    private String name;
   // @JsonProperty("pageLink")
    private String pageLink;
   // @JsonProperty("objectGroup")
    private String groupOfObject;

   // private LinkedList<String> friendsList;

    public boolean isVisited;

    public Vertex(String name)
    {
        this.id = 0;
        this.name = name;
        isVisited = false;
    }

    public Vertex(String name, int id)
    {
        this.id = id;
        this.name = name;
        isVisited = false;
    }

    public Vertex(int id, String name, String pageLink)
    {
        this.id = id;
        this.name = name;
        isVisited = false;
    }


    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}
