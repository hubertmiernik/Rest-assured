Feature: DeletePost
  Test the delete operation

  @smoke
  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation for "/posts" with body as id = "12", title = "API Testing course" and author = "ExecuteAutomation"
    And I Perform DELETE operation for "/posts/{postid}/"
    And I perform GET operation for "/posts" new
    Then I shouldn't see the body with title as "API Testing course"

#    And I perform GET operation with path parameter for "/posts"
