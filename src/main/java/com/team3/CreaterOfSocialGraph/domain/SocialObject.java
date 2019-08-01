package com.team3.CreaterOfSocialGraph.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.util.LinkedList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String socialObjectGroup = "1";

    public String getSocialObjectGroup() {
        return socialObjectGroup;
    }

    public void setSocialObjectGroup(String socialObjectGroup) {
        this.socialObjectGroup = socialObjectGroup;
    }

    public void addFriendsList(String id) {
        friendsList.add(id);
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public LinkedList<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(LinkedList<String> friendsList) {
        this.friendsList = friendsList;
    }
}
