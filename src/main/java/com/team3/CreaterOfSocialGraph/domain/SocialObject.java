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
    private Long inId;
    private Long id;
    private String lastname;
    private String name;
    private String school;
    private String university;
    private String city;
    private String photoLink;
    private String pageLink;
    private LinkedList<Long> friendsList = new LinkedList<>();
    private Integer rating;

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void addFriendsList(Long id) {
        friendsList.add(id);
    }

}
