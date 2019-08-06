package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;

import java.util.List;
import java.util.Map;

public class CohortCounter {

    private Map<Integer, SocialObject> vertexList;



    public SocialGraph getSocialObjectListWithRating(SocialGraph socialGraph) {

        vertexList = socialGraph.getAdjVertices();

        for (int i = 0; i < vertexList.size(); i++) {

           if (vertexList.get(i).getRating() == 100) continue;
           else {

               vertexList.get(i).setRating(getRating(vertexList.get(i).getFriendsList()));
           }
        }

        return socialGraph;
    }

    private int getRating(List<String> friendsList) {
        int rating = 0;

        int count = 0;
        for (String friendId : friendsList) {
            if (vertexList.get(friendId).getRating() == 100) {
                count++;
            }
        }

        // Пока что для теста
        if (count > 20 && friendsList.size() / count > 0.3)
             rating =  80;
            else rating = 25;

        return rating;
    }


}
