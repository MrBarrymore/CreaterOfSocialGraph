package com.team3.CreaterOfSocialGraph.domain;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Component
@Getter
@Setter
//@RequiredArgsConstructor
public class DataStore {

    private List<SocialObject> listOfSocialObjects;
    private SocialGraph socialGraph;

    public DataStore(List<SocialObject> listOfSocialObjects, SocialGraph socialGraph) {
        this.listOfSocialObjects = listOfSocialObjects;
        this.socialGraph = socialGraph;
    }
}
