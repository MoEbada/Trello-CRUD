package com.trello.service;

import static org.junit.jupiter.api.Assertions.*;
import static com.trello.utils.testUtils.getBoardIdByName;
import java.io.IOException;
import com.trello.model.Board;
import io.cucumber.java.en.*;

public class TrelloBoardServiceSteps {

    TrelloBoardServiceInterface trelloBoardService = new TrelloBoardService();
    private String apiKey;
    private String apiToken;
    private Board board;
    private boolean deleteSuccess;
    private String boardId;

    @Given("I have a valid API key and token")
    public void i_have_a_valid_api_key_and_token() {
        apiKey = "yourApiKey"; // Replace with your API key
        apiToken = "yourToken"; // Replace with your API token
    }

    @Given("I have an invalid API key or token")
    public void i_have_an_invalid_api_key_or_token() {
        apiKey = "invalidApiKey";
        apiToken = "invalidApiToken";
    }

    @When("I create a board with name {string}")
    public void i_create_a_board_with_name(String name) throws IOException {
        board = trelloBoardService.createBoard(name, apiKey, apiToken);
    }

    @Then("the board should be created successfully")
    public void the_board_should_be_created_successfully() {
        assertNotNull(board);
        assertEquals("KNAB-Created", board.getName());

        // Get the board ID for cleanup
        boardId = getBoardIdByName("KNAB-Created", apiKey, apiToken);
    }

    @Then("the board creation should fail")
    public void the_board_creation_should_fail() {
        assertNull(board);
    }

    @When("I update the board with id {string} to name {string}")
    public void i_update_the_board_with_id_to_name(String boardId, String name) throws IOException {
        Board boardModification = new Board();
        boardModification.setName(name);
        board = trelloBoardService.updateBoard(boardId, apiKey, apiToken, boardModification);
    }

    @Then("the board should be updated successfully")
    public void the_board_should_be_updated_successfully() {
        assertNotNull(board);
        assertEquals("KNAB-Modified", board.getName());
    }

    @Then("the board update should fail")
    public void the_board_update_should_fail() {
        assertNull(board);
    }

    @When("I delete a board with {string} id")
    public void i_delete_the_board_with_id(String existingOrNonExisting) throws IOException {
        if (existingOrNonExisting.equals("existing")) {
            boardId = getBoardIdByName("KNAB-Created", apiKey, apiToken);
        } else {
            boardId = "invalidBoardId";
        }
        deleteSuccess = trelloBoardService.deleteBoard(boardId, apiKey, apiToken);
    }

    @Then("the board should be deleted successfully")
    public void the_board_should_be_deleted_successfully() {
        assertTrue(deleteSuccess);
    }

    @Then("the board deletion should fail")
    public void the_board_deletion_should_fail() {
        assertFalse(deleteSuccess);
    }
}