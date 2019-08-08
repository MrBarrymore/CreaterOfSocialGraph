package com.team3.CreaterOfSocialGraph.controller;


import com.team3.CreaterOfSocialGraph.domain.DataStore;
import com.team3.CreaterOfSocialGraph.domain.Graph.SocialGraph;
import com.team3.CreaterOfSocialGraph.domain.OutPackage;
import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.CohortCounter;
import com.team3.CreaterOfSocialGraph.service.SocialGraphBuilder;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private DataStore graphDataStore;

    @GetMapping("/")
    public ModelAndView greeting(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        return modelAndView;
    }

    @GetMapping("/request")
    public ModelAndView request(@RequestParam(required = false, defaultValue = "") String filter, Model model ) throws IOException, InterruptedException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("request");

        List<SocialObject> listOfSocialObjects = new ArrayList<>();
        model.addAttribute("listOfSocialObjects", listOfSocialObjects);

        return modelAndView;
    }

    @PostMapping("/getSocialGraphAndList")
    public @ResponseBody
    OutPackage getSocialGraphAndList(
            @RequestParam String name,
            @RequestParam String attributeName, String ratingCount) throws IOException, InterruptedException, ClientException {

        // Формируем объект с данными запроса
        RequestMessage requestMessage = new RequestMessage(attributeName, name, ratingCount);
        // Получаем с сервера данные в форме социальных объектов
        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getListOfSocialObjects(requestMessage);

        //Формируем когорты социального графа
        CohortCounter cohortCounter = new CohortCounter();
        SocialGraph socialGraph = cohortCounter.getSocialObjectListWithRating(SocialGraphBuilder.graphBuilder(listOfSocialObjects), requestMessage);
        listOfSocialObjects = cohortCounter.getList(socialGraph);

        // Сохраняем обработанные данные в хранилище
        graphDataStore = new DataStore(listOfSocialObjects, socialGraph);

        // Перестраиваем граф исходя из необходимого значения рейтинга социального объекта
        SocialGraph socialGraphWithRating = SocialGraphBuilder.rebuiltSocialGraph(socialGraph, requestMessage.getRatingCount());
        listOfSocialObjects = cohortCounter.getList(socialGraphWithRating);

        // Формируем пакет для отправки на интерфейс
        String newJson = SocialGraphBuilder.JsonGraphBuilder(socialGraphWithRating);
        OutPackage outPackage = new OutPackage(newJson, listOfSocialObjects);

        return outPackage;
    }

    @PostMapping("/updateSocialGraphAndList")
    public @ResponseBody
    OutPackage updateSocialGraphAndList(
            @RequestParam String name,
            @RequestParam String attributeName, String ratingCount) throws IOException, InterruptedException, ClientException {

        // Формируем объект с данными нового запроса
        RequestMessage requestMessage = new RequestMessage(attributeName, name, ratingCount);

        List<SocialObject> listOfSocialObjects = new LinkedList<>();
        SocialGraph socialGraph = new SocialGraph();

        if (graphDataStore != null) {
            // Получаем список социальных объектов и социальный граф из хранилища данных
            listOfSocialObjects = graphDataStore.getListOfSocialObjects();
            socialGraph = graphDataStore.getSocialGraph();
        }

        // Перестраиваем граф исходя из необходимого значения рейтинга социального объекта
        SocialGraph socialGraphWithRating = SocialGraphBuilder.rebuiltSocialGraph(socialGraph, requestMessage.getRatingCount());

        String newJson = SocialGraphBuilder.JsonGraphBuilder(socialGraphWithRating);

        OutPackage outPackage = new OutPackage(newJson, listOfSocialObjects);

        return outPackage;
    }

    @PostMapping("/createExampleGraph")
    public @ResponseBody
    OutPackage createExampleGraph(
            @RequestParam String name,
            @RequestParam String attributeName, String ratingCount) throws IOException, InterruptedException, ClientException {

        // Формируем объект с данными запроса
        RequestMessage requestMessage = new RequestMessage(attributeName, name, ratingCount);

        // Получаем с сервера данные в форме социальных объектов
        List<SocialObject> listOfSocialObjects = SocialGraphBuilder.getExampleListOfSocialObjects(requestMessage);

        //Формируем когорты социального графа
        CohortCounter cohortCounter = new CohortCounter();
        SocialGraph socialGraph = cohortCounter.getSocialObjectListWithRating(SocialGraphBuilder.graphBuilder(listOfSocialObjects), requestMessage);
        listOfSocialObjects = cohortCounter.getList(socialGraph);

        // Сохраняем обработанные данные в хранилище
        graphDataStore = new DataStore(listOfSocialObjects, socialGraph);

        // Перестраиваем граф исходя из необходимого значения рейтинга социального объекта
        SocialGraph socialGraphWithRating = SocialGraphBuilder.rebuiltSocialGraph(socialGraph, requestMessage.getRatingCount());
        listOfSocialObjects = cohortCounter.getList(socialGraphWithRating);

        // Формируем пакет для отправки на интерфейс
        String newJson = SocialGraphBuilder.JsonGraphBuilder(socialGraphWithRating);
        OutPackage outPackage = new OutPackage(newJson, listOfSocialObjects);

        return outPackage;
    }


    @GetMapping("/aboutApplication")
    public String aboutApplication(Map<String, Object> model) {
        return "aboutPage";
    }


}
