Feature:
  Verify different POST operation using REST-assured

  Scenario: Verify Post operation
    Given I perform POST operation for "/posts"

  Scenario: Verify Post operation for Profile
    Given I Perform POST operation for "/posts/{profileNo}/profile" with body
    Then I should see the body has name as "Sams"

