Feature: Test Herokuapp endpoints

  Scenario Outline: Update user
    When user updates user with id 23 name "<name>" and username "<username>"
    Then user checks that user with id 23 is updated to name "<name>" and username "<username>" is updated

    Examples:
      | name | username |
      | test | test     |

    Scenario Outline: Delete user
    When user deletes user with id <id>
    Then user checks that user with id <id> is deleted
      Examples:
        | id |
        | 23 |

    Scenario Outline: Create user
    When user creates user with name "<name>" and username "<username>"
    Then user checks that user with name "<name>" and username "<username>" is created
        Examples:
          | name     | username     |
          | testName | testUserName |


