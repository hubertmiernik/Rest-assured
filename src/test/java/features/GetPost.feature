Feature:
  Verify different GET operation using REST-assured

  Scenario: Verify one author of the employee
    Given I perform GET operation for "/employees"
    Then I should see the first_name as "Sebastian"

  Scenario: Verify collection of the names in the employees
    Given I perform GET operation for "/employees"
    Then I should see the employees names

  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/employees"
    Then I should see verify GET Parameter
