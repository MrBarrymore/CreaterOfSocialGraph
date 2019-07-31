package com.team3.CreaterOfSocialGraph.controller;


import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
//@RequiredArgsConstructor
//@RequestMapping("request")
public class MainController {

    @GetMapping("/")
    public String getPage() {

        return "index";
    }

    @PostMapping("/")
    public String getSocialGraph() throws IOException, InterruptedException {

        String message = "";

        String SocialGraph = SocialGraphBuilder.graphBuilder();



        return SocialGraph;
    }



}
