package com.trello.service;

import com.trello.model.Board;

public interface TrelloBoardServiceInterface {

    Board createBoard(String name, String apiKey, String apiToken);

    String getBoard(String boardId, String apiKey, String apiToken);

    Board updateBoard(String boardId, String apiKey, String apiToken, Board boardModification);

    boolean deleteBoard(String boardId, String apiKey, String apiToken);

}