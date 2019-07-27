package com.team3.CreaterOfSocialGraph.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inId;
    private int id;
    private String lastname;
    private String name;
    private String school;
    private String university;
    private String city;
    private String photoLink;
    private LinkedList<String> friendsList = new LinkedList<>();

    public void addFriendsList(String id) {
        friendsList.add(id);
    }

}
