Feature: View All Feature
  Verify if user is able to view 100 crypto currencies

  Scenario: Navigate to homepage and view all
    Given user is  on homepage
    When user clicks on ViewAll link
    Then user is able to see a list of 100 crypto currency providers
