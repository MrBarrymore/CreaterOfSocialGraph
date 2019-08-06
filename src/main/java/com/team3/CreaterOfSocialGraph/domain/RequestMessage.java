package com.team3.CreaterOfSocialGraph.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
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
