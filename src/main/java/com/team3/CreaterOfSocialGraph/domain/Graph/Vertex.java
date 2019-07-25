package com.team3.CreaterOfSocialGraph.domain.Graph;


import lombok.Data;

import javax.persistence.Id;

@Data
public class Vertex {

    @Id
    private int inId;
    private String name;
    private String pageLink;
    private String groupOfObject;

   // private LinkedList<String> friendsList;

    public boolean isVisited;

    public Vertex(String name)
    {
        this.inId = 0;
        this.name = name;
        isVisited = false;
    }

    public Vertex(String name, int inId)
    {
        this.inId = inId;
        this.name = name;
        isVisited = false;
    }

    public Vertex(int inId, String name, String pageLink)
    {
        this.inId = inId;
        this.name = name;
        isVisited = false;
    }


    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}
