package com.team3.CreaterOfSocialGraph.domain.jsondto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {

    private Long source;
    private Long target;
    private int value;
    private int weight;

    public LinkDTO(Long source, Long target, int value, int weight) {
        this.source = source;
        this.target = target;
        this.value = value;
        this.weight = weight;
    }
}
