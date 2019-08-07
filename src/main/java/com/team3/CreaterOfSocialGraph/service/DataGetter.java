package com.team3.CreaterOfSocialGraph.service;

//import com.google.gson.JsonArray;

//import com.google.gson.JsonArray;

import com.team3.CreaterOfSocialGraph.domain.RequestMessage;
import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import com.team3.CreaterOfSocialGraph.service.helper.IOHelper;
import com.vk.api.sdk.exceptions.ClientException;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import static com.team3.CreaterOfSocialGraph.service.helper.JsonToSocialObjectConverter.CovvertJsonToSocialObjects;

@Component
public class DataGetter {

  private final static String FILE_NAME = "src\\main\\resources\\testfiles\\graph.json"; // Статический заданый источник для тестов
 //  private final static String FILE_NAME = "JsonTest.json"; // Статический заданый источник для тестов

    public static LinkedList<SocialObject> getDataFromServer(RequestMessage requestMessage) throws IOException, InterruptedException, ClientException {

        // Работа через парсер
//       JSONArray listOfSocialObjectsJSON = VkAPIConnector.getVkObjects(requestMessage);
//       // Записываем тестовый файл
//        writeFile(listOfSocialObjectsJSON); // Запись полученной выборки в файл
//        LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON, requestMessage);


        // Берем данные из тестового файла
        String resultJson = IOHelper.parseUrl(FILE_NAME);
        JSONArray listOfSocialObjectsJSON = new JSONArray(resultJson);
        LinkedList<SocialObject> listOfSocialObjects = CovvertJsonToSocialObjects(listOfSocialObjectsJSON, requestMessage);

        return listOfSocialObjects;
    }


    public static void writeFile(JSONArray listOfSocialObjectsJSON) {

        try (FileWriter writer = new FileWriter(FILE_NAME, false)){
            writer.write(listOfSocialObjectsJSON.toString());
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
