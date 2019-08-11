package com.team3.CreaterOfSocialGraph.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OutPackage {
    private String jsonSocialGraph;
    private List<SocialObject> listOfSocialObjects;
}
