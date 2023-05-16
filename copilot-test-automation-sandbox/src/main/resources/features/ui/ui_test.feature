Feature: Test Duck Duck Go search
  Scenario: Search images
    Given user opens home page
    When user searches for 'Test'
    Then at least 1 result is found

    Scenario: Change language
    Given user opens home page
    When user changes search language to 'Deutsch'
    Then user sees search language is 'Deutsch'
