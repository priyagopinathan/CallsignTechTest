# new feature
# Tags: optional

Feature: Add to watchlist
  Verify if user can add to watchlist and view them in watchlist tab.

  Scenario: Add to watchlist
    Given user is able to view all currencies on homepage
    When user is able to randomly select 5 currencies
    And user is able to add them to watchlist
    Then user is able to see the selected currencies on watchlist tab