package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CohortCounter {

    private Map<Long, SocialObject> vertexList;



    public SocialGraph getSocialObjectListWithRating(SocialGraph socialGraph) {

        vertexList = socialGraph.getAdjVertices();

        // Продолжить отсюда

        for (Long key : vertexList.keySet()) {

           if (vertexList.get(key).getRating() == 100) continue;
           else {

  //             vertexList.get(key).setRating(getRating(vertexList.get(key).getFriendsList()));
           }
        }

        return socialGraph;
    }

    private int getRating(List<Long> friendsList) {
        int rating = 0;

        int count = 0;
        for (Long friendId : friendsList) {
            if (vertexList.containsKey(friendId))
                if (vertexList.get(friendId).getRating() == 100) {
                    count++;
                }
        }

        // Пока что для теста
        if (count > 10 )
             rating =  80;
            else rating = 25;

        return rating;
    }

    public List<SocialObject> getList(SocialGraph socialGraph) {

        Map <Long, SocialObject> list = socialGraph.getAdjVertices();

        List<SocialObject> listSO = new LinkedList<>();

        for (Long key : list.keySet()) {
            listSO.add(list.get(key));
        }

        return listSO;
    }


}
