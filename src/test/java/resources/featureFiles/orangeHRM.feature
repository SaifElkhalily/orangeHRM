Feature: I want to Login to orangeHRM
          Navigate to Admin page
          Get the number of users listed
          Add new user
          Verify that the number of users listed increased by 1
          After that I want to search for the new user by their username
          Delete the user
          Verify the number of users listed decreased by 1
  
  Background: Initiate Chrome and Navigate to orangeHRM website | Login | Navigate to Admin | get the initial number of users listed
    Given Initiate Chrome Browser and navigate to "https://opensource-demo.orangehrmlive.com/"
    When User Login by entering their Username "Admin" and Password "admin123" then clicks on Login
    And User Click on "Admin" from left side menu
    Then Get the number of records found
    And Get the initial count of Users

    Scenario: TC01 | Add new user| Verify the number of users increase by 1
      When Admin clicks on Add to add a new user
      And Admin adds new user and fills the required data User Role "Admin",Status "Enabled",Employee name "sww",Select Employee "sww  test",Username "QA Automation",Password "s1234567",Confirm Password "s1234567" then clicks on Save
      Then Refresh the Admin page
      And Get the number of records found
      And Get the recent count of Users
      Then Verify that the number of Users increased by 1
      And Close the session and the browser

    Scenario: TC02 | Search for user | Delete that user | Verify the number of users decreased by 1
      When Admin searches for a user with the user name "QA Automation"
      And Admin delete user
      Then Refresh the Admin page
      And Get the number of records found
      And Get the recent count of Users
      Then Verify that the number of Users decreased by 1
      And Close the session and the browser