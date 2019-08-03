package com.team3.CreaterOfSocialGraph.domain;

import org.springframework.stereotype.Component;

@Component
public class RequestMessage {

    private String name;
    private String attributeName;

    public RequestMessage() {
    }

    public RequestMessage(String attributeName, String name) {
        this.name = name;
        this.attributeName = attributeName;
    }
}
