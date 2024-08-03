package com.trello.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.trello.model.Board;

public class TrelloBoardService implements TrelloBoardServiceInterface {

    @Override
    public Board createBoard(String name, String apiKey, String apiToken) {
        try {
            HttpResponse<String> response = Unirest.post("https://api.trello.com/1/boards")
                    .header("Accept", "application/json")
                    .queryString("key", apiKey)
                    .queryString("token", apiToken)
                    .queryString("name", name)
                    .asString();
            return Board.fromJson(response.getBody().toString());
        } catch (Exception e) {
            System.out.println("Could not create board with name: " + name + " due to: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String getBoard(String boardId, String apiKey, String apiToken) {
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://api.trello.com/1/boards/" + boardId)
                    .header("Accept", "application/json")
                    .queryString("key", apiKey)
                    .queryString("token", apiToken)
                    .asJson();
            return response.getBody().toString();
        } catch (Exception e) {
            System.out.println("Could not get board with id: " + boardId + " due to: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Board updateBoard(String boardId, String apiKey, String apiToken, Board boardModification) {
        try {
            HttpResponse<String> response = Unirest.put("https://api.trello.com/1/boards/" + boardId)
                    .header("Accept", "application/json")
                    .queryString("key", apiKey)
                    .queryString("token", apiToken)
                    .queryString("name", boardModification.getName())
                    .asString();
            return Board.fromJson(response.getBody().toString());
        } catch (Exception e) {
            System.out.println("Could not update board with id: " + boardId + " due to: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteBoard(String boardId, String apiKey, String apiToken) {
        try {
            HttpResponse<String> response = Unirest.delete("https://api.trello.com/1/boards/" + boardId)
                    .header("Accept", "application/json")
                    .queryString("key", apiKey)
                    .queryString("token", apiToken)
                    .asString();     
            return response.getStatusText().equals("OK");
        } catch (Exception e) {
            System.out.println("Could not delete board with id: " + boardId + " due to: " + e.getMessage());
        }
        return false;
    }
}