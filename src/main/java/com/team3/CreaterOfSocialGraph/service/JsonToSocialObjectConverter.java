package com.team3.CreaterOfSocialGraph.service;


import com.team3.CreaterOfSocialGraph.domain.SocialObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

@Component
public class JsonToSocialObjectConverter {

    private static String FILE_NAME = "E:\\Lessons Java\\Practice\\CreaterOfSocialGraph\\JsonTest.json"; // Статический заданый источник для тестов

    public static void CovvertJsonToSocialObject()  throws IOException {

        //SocialObject newSocialObject = mapper.readValue(jsonString, SocialObject.class);

        SocialObject newSocialObject = new SocialObject();

        try {
            String resultJson = parseUrl(FILE_NAME);

            System.out.println("\nПолученный JSON:\n" + resultJson);

            JSONObject personJsonObject = new JSONObject(resultJson);

            // получаем массив элементов для поля weather

            // печатаем текущую погоду в консоль
            JSONObject personData = (JSONObject) personJsonObject.get("information");

            System.out.println("ID пользователя: " + personData.get("id"));
            System.out.println("Имя: " + personData.get("first_name"));
            System.out.println("Фамилия: " + personData.get("last_name"));

            // Получаем название университета
            JSONArray universatyData = (JSONArray) personData.get("universities");
                JSONObject firstUniversatyData = (JSONObject) universatyData.get(0);
                System.out.println("Университет: " + firstUniversatyData.get("name"));

            JSONArray schoolData = (JSONArray) personData.get("schools");
            JSONObject firstSchoolData = (JSONObject) schoolData.get(0);
            System.out.println("Школа: " + firstSchoolData.get("name"));

                JSONObject fiends = (JSONObject) personJsonObject.get("friends");

            System.out.println("Количество друзей: " + fiends.get("count"));

            JSONArray fiendsArray = (JSONArray) fiends.get("items");

            LinkedList<Integer> friendsArray = new LinkedList<>();

            for (int i = 0; i < (int)fiends.get("count"); i++) {
                friendsArray.add((int) fiendsArray.get(i));
                System.out.println(fiendsArray.get(i));
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }


//
//        return newSocialObject;

    }

    public static String parseUrl(String url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    // формируем новый JSON объект из нужных нам погодных данных
    public static String buildWeatherJson() {
        // для простоты примера просто хардкодим нужные данные в методе
        JSONObject jsonObject = new JSONObject();
        // задаем идентификатор
        jsonObject.put("weather_id", 0);

        // создаем поле с именем
        jsonObject.put("name", "Лондон");

        // используем функцию аккумулирования для добавления
        // элемента к существующему значению. В результате мы получим список значений
        jsonObject.accumulate("name", "Англия");
        // добавляет элемент в уже существующий список
        jsonObject.append("name", "(Великобритания)");

        // увеличиваем значение на единицу
        jsonObject.increment("weather_id");

        jsonObject.put("main", "Солнечно");
        jsonObject.put("description", "Мороз трескучий, На небе ни единой тучи");

        // позволяет представить JSON в удобном для HTML виде
        System.out.println(JSONObject.quote(jsonObject.toString()));

        return jsonObject.toString();
    }




}
