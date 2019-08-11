package com.team3.CreaterOfSocialGraph.domain.jsondto;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class JsonDTO {

    public List<NodeDTO> nodes;
    public List<LinkDTO> links;

    public JsonDTO() {
        nodes = new LinkedList<>();
        links = new LinkedList<>();
    }

    public void addNode(NodeDTO newNode) {
        nodes.add(newNode);
    }

    public void addLink(LinkDTO newLink) {
        links.add(newLink);
    }

}
