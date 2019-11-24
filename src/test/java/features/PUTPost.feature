Feature: PutPost
  Test the delete operation

  @smoke
  Scenario: Verify PUT operation after POST
    Given I ensure to Perform POST operation for "/posts" with body as id = "12", title = "API Testing course" and author = "ExecuteAutomation"
    And I Perform PUT operation for "/posts/{postid}/"
    And I perform GET operation for "/posts" new
    Then I should see the body with title as "API Testing course"

  #      And I perform GET operation with path parameter for "/posts"

