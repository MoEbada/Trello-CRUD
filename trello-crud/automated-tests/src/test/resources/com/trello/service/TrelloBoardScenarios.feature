Feature: Trello Board Service

  Scenario: Create a new board successfully
    Given I have a valid API key and token
    When I create a board with name "KNAB-Created"
    Then the board should be created successfully

  Scenario: Fail to create a new board with invalid token
    Given I have an invalid API key or token
    When I create a board with name "KNAB-Created"
    Then the board creation should fail

  Scenario: Update an existing board successfully
    Given I have a valid API key and token
    When I update the board with id "66ae23f3c293e2dd480b9b9b" to name "KNAB-Modified"
    Then the board should be updated successfully

  Scenario: Fail to update a non-existent board
    Given I have a valid API key and token
    When I update the board with id "nonExistentBoardId" to name "KNAB-Modified"
    Then the board update should fail

  Scenario: Delete an existing board successfully
    Given I have a valid API key and token
    When I delete a board with "existing" id
    Then the board should be deleted successfully

  Scenario: Fail to delete a non-existent board
    Given I have a valid API key and token
    When I delete a board with "non-existing" id
    Then the board deletion should fail