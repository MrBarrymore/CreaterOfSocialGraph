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

    private Map<Long, SocialObject> adjVertices;

    public SocialGraph() {
        this.adjVertices = new HashMap<>();
    }

    public SocialGraph(Map<Long, SocialObject> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Long, SocialObject> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Long, SocialObject> adjVertices) {
        this.adjVertices = adjVertices;
    }


    public void addVertex(Long id, SocialObject socialObject)
    {
        this.adjVertices.putIfAbsent(id, socialObject);
    }


    public void removeVertex(Long id) {

        for (int i = 0 ; i < adjVertices.get(id).getFriendsList().size(); i++) {
            if (adjVertices.containsKey(adjVertices.get(id).getFriendsList().get(i))) {
                Long idBuf = adjVertices.get(id).getFriendsList().get(i);
                adjVertices.get(idBuf).getFriendsList().remove(id);
            }
        }
        adjVertices.remove(id);
    }

    public void addEdge(Long id1, Long id2) {
//        adjVertices.get(id1).getFriendsList().add(adjVertices.get(id2).getId());
//        adjVertices.get(id2).getFriendsList().add(adjVertices.get(id1).getId());
    }

    public void removeEdge(Long id1, Long id2) {
        List<Long> eV1 = adjVertices.get(id1).getFriendsList();
        List<Long> eV2 = adjVertices.get(id2).getFriendsList();
        if (eV1 != null)
            eV1.remove(id1);
        if (eV2 != null)
            eV2.remove(id2);
    }

    public SocialObject getAdjVertices(String id) {
        return adjVertices.get(id);
    }



}
