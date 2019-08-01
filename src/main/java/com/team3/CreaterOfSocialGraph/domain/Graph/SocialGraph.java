package com.team3.CreaterOfSocialGraph.domain.Graph;


import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

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

    private Map<Integer, SocialObject> adjVertices;

    public SocialGraph() {
        this.adjVertices = new HashMap<>();
    }

    public SocialGraph(Map<Integer, SocialObject> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Integer, SocialObject> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Integer, SocialObject> adjVertices) {
        this.adjVertices = adjVertices;
    }


    public void addVertex(Integer id, SocialObject socialObject)
    {
        this.adjVertices.putIfAbsent(id, socialObject);
    }


    public void removeVertex(Integer id) {

        for (int i = 0 ; i < adjVertices.get(id).getFriendsList().size(); i++) {
            String idBuf = adjVertices.get(id).getFriendsList().get(i);
            adjVertices.get(id).getFriendsList().remove(idBuf);
        }

        adjVertices.remove(id);
    }

    public void addEdge(Integer id1, Integer id2) {
        adjVertices.get(id1).getFriendsList().add(adjVertices.get(id2).getId());
        adjVertices.get(id2).getFriendsList().add(adjVertices.get(id1).getId());
    }

    public void removeEdge(Integer id1, Integer id2) {
        List<String> eV1 = adjVertices.get(id1).getFriendsList();
        List<String> eV2 = adjVertices.get(id2).getFriendsList();
        if (eV1 != null)
            eV1.remove(id1);
        if (eV2 != null)
            eV2.remove(id2);
    }

    public SocialObject getAdjVertices(String id) {
        return adjVertices.get(id);
    }



}
