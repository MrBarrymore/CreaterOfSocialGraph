package com.team3.CreaterOfSocialGraph.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialObject {

    private long id;
    private String surname;
    private String name;
    private String school;
    private String university;
    private String city;
    private List<String> friendsList;

}
