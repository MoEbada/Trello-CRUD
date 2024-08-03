package com.trello.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testUtils {
    public static String getBoardIdByName(String boardName, String apiKey, String apiToken) {
        Response response = RestAssured.given()
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .get("https://api.trello.com/1/members/me/boards");
        return response.jsonPath().getString("find { it.name == '" + boardName + "' }.id");
    }
}
