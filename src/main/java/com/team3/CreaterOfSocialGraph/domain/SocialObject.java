package com.team3.CreaterOfSocialGraph.domain;


import lombok.*;


import java.util.LinkedList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SocialObject {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int inId;
    private String id;
    private String lastname;
    private String name;
    private String school;
    private String university;
    private String city;
    private String photoLink;
    private String pageLink;
    private LinkedList<String> friendsList = new LinkedList<>();
    private Integer rating;

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void addFriendsList(String id) {
        friendsList.add(id);
    }

}
