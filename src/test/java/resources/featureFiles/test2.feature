Feature: Test2

  Background: OpenChrome
    Given User opens chrome and navigates to "https://opensource-demo.orangehrmlive.com/"
  Scenario: Test2
    When User enters their Username "Admin"
    And User enters their password "admin123"
    And User clicks on Login

    Scenario: Test 3
      When User open URL
      And User enters username "Admin" , password "admin123" and login