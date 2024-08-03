package com.trello.ui;

import static com.trello.utils.testUtils.getBoardIdByName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.trello.model.Board;
import com.trello.service.TrelloBoardService;

public class TrelloBoardUITests extends BaseTest {
    private static final String TRELLO_LOGIN_URL = "https://trello.com/login";
    private final String apiKey = "yourApiKey"; // Replace with your API key
    private final String apiToken = "yourToken"; // Replace with your API token
    private String boardId;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        super.setUp();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCreateBoard() {
        driver.get(TRELLO_LOGIN_URL);
        loginToTrello();

        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[data-testid='header-create-menu-button']"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[data-testid='header-create-board-button']"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[data-testid='create-board-title-input']")))
                .sendKeys("UI Test Board");
        wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[data-testid='create-board-submit-button']"))).click();
        WebElement boardTitle = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("h1[data-testid='board-name-display']")));

        assertEquals("UI Test Board", boardTitle.getText());

        // Get the board ID for cleanup
        boardId = getBoardIdByName("UI Test Board", apiKey, apiToken);

        TrelloBoardService boardService = new TrelloBoardService();
        Board board = Board.fromJson(boardService.getBoard(boardId, apiKey, apiToken));
        assertNotNull(board);
        System.out.println(board.toString());
        System.out.println(
                "Deleting board: " + boardId + ", status: " + boardService.deleteBoard(boardId, apiKey, apiToken));
    }

    @Test
    public void testUpdateBoard() {
        // Could also be automated similarly to testCreateBoard()
    }

    @Test
    public void testDeleteBoard() {
        // Could also be automated similarly to testCreateBoard()
    }

    private void loginToTrello() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("your_email"); // Replace with your email
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).click();
        driver.findElement(By.id("password")).sendKeys("your_password"); // Replace with your password
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).sendKeys(Keys.RETURN);
    }
}