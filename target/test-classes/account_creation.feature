Feature: Account creation and login on Magento website

  Scenario: User registers and logs in successfully
    Given User is on the Magento homepage
    When User clicks on Create an Account link
    And User fills in registration form with "Dhanushkodi", "Raj", "dhanushtest@test.com", and "TestUser123"
    Then User should be logged in successfully