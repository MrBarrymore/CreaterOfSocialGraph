package com.team3.CreaterOfSocialGraph.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RequestController {

    //private final RequestMessageRepo requestMessageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    /*
    @GetMapping
    public String main(Map<String, Object> model) {

        //Iterable<RequestMessage> requestMessage = requestMessageRepo.findAll();

        //model.put("messages", requestMessage);

        model.put("messages", "Запрос принят");

        return "main";
    }


    @PostMapping
    public String add(@RequestParam String requesttext, @RequestParam String attributeName, Map<String, Object> model) {

        RequestMessage requestMessage = new RequestMessage(requesttext, attributeName);

        //requestMessageRepo.save(requestMessage);

        // Iterable<RequestMessage> messages = requestMessageRepo.findAll();

        model.put("messages", "Запрос принят");

        return "main";
    }
*/

}
