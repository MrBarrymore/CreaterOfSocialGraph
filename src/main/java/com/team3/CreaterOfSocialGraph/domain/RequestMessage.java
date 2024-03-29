package com.team3.CreaterOfSocialGraph.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class RequestMessage {

    private String attributeName;
    private String name;
    private Integer objectsCount;
    private String ratingCount;

    public RequestMessage() {
    }

    public RequestMessage(String attributeName, String name) {
        this.name = name;
        this.attributeName = attributeName;
    }

    public RequestMessage(String attributeName, String name, String ratingCount) {
        this.attributeName = attributeName;
        this.name = name;
        this.ratingCount = ratingCount;
    }

    public RequestMessage(String attributeName, String name, Integer objectsCount, String ratingCount) {
        this.attributeName = attributeName;
        this.name = name;
        this.objectsCount = objectsCount;
        this.ratingCount = ratingCount;
    }
}
