Feature:
  Verify different GET operation using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author as "Karthik KK"

  Scenario: Verify collection of the names in the posts
    Given I perform GET operation for "/posts"
    Then I should see the posts authors

  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/posts"
    Then I should see verify GET Parameter

  Scenario: Verify Post operation
    Given I perform POST operation for "/posts"

    Scenario: Verify Post operation for Profile
      Given I Perform POST operation for "/posts/{profileNo}/profile" with body
#        | name | profile |
#        | Sams | 2       |
      Then I should see the body has name as "Sams"
