package com.team3.CreaterOfSocialGraph.controller;


import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.OutPackage;
import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.CohortCounter;
import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
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
        modelAndView.setViewName("request");

        List<SocialObject> listOfSocialObjects = new ArrayList<>();
        model.addAttribute("listOfSocialObjects", listOfSocialObjects);

        return modelAndView;
    }

    @PostMapping("/getListOfSocialObjects")
    public @ResponseBody
    List getListOfSocialObjects(
            @RequestParam String name,
            @RequestParam String attributeName) throws IOException, InterruptedException {

        RequestMessage requestMessage = new RequestMessage(attributeName, name);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("request");

        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects(requestMessage);


 //       model.addAttribute("listOfSocialObjects", listOfSocialObjects);

        return listOfSocialObjects;
    }

    @PostMapping("/getSocialGraph")
    public @ResponseBody
    String getSocialGraph(
            @RequestParam String name,
            @RequestParam String attributeName) throws IOException, InterruptedException {

        RequestMessage requestMessage = new RequestMessage(attributeName, name);

        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects(requestMessage);
        String newJson = SocialGraphBuilder.JsonGraphBuilder(SocialGraphBuilder.graphBuilder(listOfSocialObjects));

        return newJson;
    }

    @PostMapping("/getSocialGraphAndList")
    public @ResponseBody
    OutPackage getSocialGraphAndList(
            @RequestParam String name,
            @RequestParam String attributeName) throws IOException, InterruptedException {

        RequestMessage requestMessage = new RequestMessage(attributeName, name);

        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects(requestMessage);

        CohortCounter cohortCounter = new CohortCounter();

        SocialGraph socialGraph = cohortCounter.getSocialObjectListWithRating(SocialGraphBuilder.graphBuilder(listOfSocialObjects));

        listOfSocialObjects = cohortCounter.getList(socialGraph);

        String newJson = SocialGraphBuilder.JsonGraphBuilder(socialGraph);
   //     String newJson = " ";

        OutPackage outPackage = new OutPackage(newJson,listOfSocialObjects);

        return outPackage;
    }

    @GetMapping("/aboutApplication")
    public String aboutApplication(Map<String, Object> model) {
        return "aboutPage";
    }


}
