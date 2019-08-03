package com.team3.CreaterOfSocialGraph.controller;


import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
//@RequiredArgsConstructor
//@RequestMapping("request")
public class MainController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/request")
    public ModelAndView main(@RequestParam(required = false, defaultValue = "") String filter, Model model ) throws IOException, InterruptedException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

       List<SocialObject> listOfSocialObjects = null;

        return modelAndView;
    }

    @PostMapping("/request")
    public ModelAndView getSocialGraph(
            @RequestParam String name,
            @RequestParam String attributeName, Model model) throws IOException, InterruptedException {

        RequestMessage requestMessage = new RequestMessage(attributeName, name);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("request");

        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects(requestMessage);


        model.addAttribute("listOfSocialObjects", listOfSocialObjects);


        return modelAndView;
    }



}
