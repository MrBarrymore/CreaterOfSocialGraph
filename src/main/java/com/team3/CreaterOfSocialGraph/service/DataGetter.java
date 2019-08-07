package com.team3.CreaterOfSocialGraph.service;

//import com.google.gson.JsonArray;

//import com.google.gson.JsonArray;

import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.IOHelper;
import com.team3.CreaterOfSocialGraph.service.vkdatagetter.VkAPIConnector;
import com.vk.api.sdk.exceptions.ClientException;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.helper.JsonToSocialObjectConverter.CovvertJsonToSocialObjects;

@Service
public class DataGetter {

    public static LinkedList<SocialObject> getDataFromServer(RequestMessage requestMessage) throws IOException, InterruptedException, ClientException {

        // Работа через парсер
       JSONArray listOfSocialObjectsJSON = VkAPIConnector.getVkObjects(requestMessage);
       // Перезаписываем тестовый файл, при необходимости
      //  IOHelper.writeFile(FILE_NAME, listOfSocialObjectsJSON); // Запись полученной выборки в файл
        LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON, requestMessage);

        return listOfSocialObjects;
    }

    private final static String FILE_NAME = "src\\main\\resources\\testfiles\\graph.json"; // Статический заданый источник для тестов

    public static LinkedList<SocialObject> getExampleData(RequestMessage requestMessage) throws IOException, InterruptedException, ClientException {

        // Берем данные из тестового файла
        String resultJson = IOHelper.parseUrl(FILE_NAME);
        JSONArray listOfSocialObjectsJSON = new JSONArray(resultJson);
        LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON, requestMessage);

        return listOfSocialObjects;
    }

}
