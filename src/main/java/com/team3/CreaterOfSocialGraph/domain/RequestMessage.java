package com.team3.CreaterOfSocialGraph.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RequestMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String text;
    private String attributeName;

    public RequestMessage() {
    }

    public RequestMessage(String text, String attributeName) {
        this.text = text;
        this.attributeName = attributeName;
    }
}
