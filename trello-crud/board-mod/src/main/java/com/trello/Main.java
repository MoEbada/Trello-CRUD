package com.trello;

import com.trello.model.Board;
import com.trello.service.TrelloBoardService;
import com.trello.service.TrelloBoardServiceInterface;

/**
 * Main class to demonstrate the usage of the TrelloBoardService
 * to perform CRUD operations on a Trello board.
 * 
 * @see TrelloBoardService
 * 
 * Note: Replace the <placeholders> with your actual API key, token, and board ID.
 */
public class Main {
    public static void main(String[] args) {
        TrelloBoardServiceInterface trelloService = new TrelloBoardService();
        try {
            // Get a board
            String boardJson = trelloService.getBoard("<existing-board-id>", 
            "<apiKey>", 
            "<token>");

            Board board = Board.fromJson(boardJson);
            if (board != null) {
                System.out.println(board.toString());
            } else {
                System.out.println("Failed to parse JSON");
            }

            // Update a board
            Board boardModification = new Board();
            boardModification.setName("KNAB-Modified");
            Board updatedBoard = trelloService.updateBoard("<existing-board-id>", "<apiKey>", 
            "<apiToken>", boardModification); 
            if (updatedBoard != null) {
                System.out.println(updatedBoard.toString());
            } else {
                System.out.println("Failed to parse JSON");
            }

            // Create a new board
            Board createdBoard = trelloService.createBoard("KNAB-Created", "<apiKey>", 
            "<apiToken>"); 
            if (createdBoard != null) {
                System.out.println(createdBoard.toString());
            } else {
                System.out.println("Failed to parse JSON");
            }
            
            // Delete a board
            System.out.println(trelloService.deleteBoard("<existing-board-id>", "<apiKey>", 
            "<apiToken>"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}