package com.team3.CreaterOfSocialGraph.domain.Graph;


import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
//@Builder
//@RequiredArgsConstructor
@Builder
//@NoArgsConstructor
public class SocialGraph {

    private Map<Vertex, List<Vertex>> adjVertices;

    public SocialGraph() {
        this.adjVertices = new HashMap<>();
    }

    public SocialGraph(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }


    public void addVertex(SocialObject socialObject) {
        adjVertices.putIfAbsent(new Vertex(socialObject), new ArrayList<>());
    }

    public void removeVertex(SocialObject socialObject) {
        Vertex v = new Vertex(socialObject);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(socialObject));
    }

    public void addEdge(Integer label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(Integer.valueOf(label2));
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void addEdge(SocialObject label1, SocialObject label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }


    public void removeEdge(SocialObject label1, SocialObject label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public List<Vertex> getAdjVertices(SocialObject label) {
        return adjVertices.get(new Vertex(label));
    }



}
