package com.team3.CreaterOfSocialGraph.domain.jsondto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeDTO {

    private Long id;
    private String name;
    private int rating;
    private String photo;

    public NodeDTO(Long id, String name, int rating, String photo) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.photo = photo;
    }
}
