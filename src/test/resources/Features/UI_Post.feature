Feature: Adding post from UI

  @tag=TEST-1
  Scenario: User is adding a post through UI
    Given User lounches to the log in page
    When User enters "username" and "password" and logs in
    And User creates a new post and submits
    Then User verifies the post from UI and DataBase

