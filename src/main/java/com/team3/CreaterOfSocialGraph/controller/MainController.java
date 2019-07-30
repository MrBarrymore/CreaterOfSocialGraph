package com.team3.CreaterOfSocialGraph.controller;


import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
//@RequiredArgsConstructor
@RequestMapping("request")
public class MainController {

    @GetMapping("/")
    public String getPage() {

        return "main";
    }

    @PostMapping("/")
    public String getSocialGraph() throws IOException {
        String message = "";

        String SocialGraph = SocialGraphBuilder.graphBuilder();



        return SocialGraph;
    }



}
