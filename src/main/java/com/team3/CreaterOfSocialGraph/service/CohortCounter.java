package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CohortCounter {

    private Map<Long, SocialObject> vertexList;

    public SocialGraph getSocialObjectListWithRating(SocialGraph socialGraph, RequestMessage requestMessage) {

        vertexList = socialGraph.getAdjVertices();

        for (Long key : vertexList.keySet()) {

           if (vertexList.get(key).getRating() == 100) continue;
           else {
                vertexList.get(key).setRating(getRating(vertexList.get(key).getFriendsList(), requestMessage));
           }
        }

        return socialGraph;
    }

    private int getRating(List<Long> friendsList, RequestMessage requestMessage) {

        int rating = 0;

        int count = 0;
        for (Long friendId : friendsList) {
            if (vertexList.containsKey(friendId))
                if (vertexList.get(friendId).getRating() == 100) {
                    count++;
                }
        }

        switch (requestMessage.getAttributeName()) {
            case "city":
                if (count > 20 ) {
                    rating =  80;
                    }
                else if (count > 10 && count < 20) {
                    rating =  40;
                } else rating = 10;

                break;
            case "university":
                if (count > 15 ) {
                    rating =  80;
                } if (count > 10 && count < 15) {
                rating =  40;
                } else rating = 10;
                break;
            case "school":
                if (count > 15 ) {
                    rating =  80;
                } if (count > 10 && count < 15) {
                    rating =  40;
                } else rating = 10;
                break;
        }

        return rating;
    }

    public List<SocialObject> getList(SocialGraph socialGraph) {

        Map <Long, SocialObject> list = socialGraph.getAdjVertices();

        List<SocialObject> listSO = new LinkedList<>();

        Long newId = 0L;
        for (Long key : list.keySet()) {
            list.get(key).setInId(newId);
            listSO.add(list.get(key));
            newId++;
        }

        return listSO;
    }


}
