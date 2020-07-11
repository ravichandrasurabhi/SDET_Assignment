# Selenium - Cucumber Assignment by Ravi Chandra Surabhi
Feature: to register and send mail after successfull validation of profile

  @registration
  Scenario: to register an user
    Given the website is loaded
    And Engilsh is selected as Language on the home page
    When user wants to register
    When mandatory fields are populated
      | firstname | lastname | email                        | username    | password   |
      | ravi      | chandra  | ravichandrasurabhi@gmail.com | ravi2346678 | Welcome123 |
    And Clicking on the Register button
    Then display the valid message if registered successfully

  @profilevalidation
  Scenario: to validate name and email
    Given user registered successfully
    When clicked on profile dropdown at top right corner
    Then display profile details such as name and email
    And validate name and email of the user.

  @email
  Scenario: to check user is able to send mail
    Given user wants to send an message to other user in the system
    And clicked on Compose option in the home page
    When entered details such as To, subject and Message
      | To          | subject           | Message                        |
      | ravi1234567 | Hi for Assignment | About to finish the assignment |
    And finally clicks on send message
    Then acknowledgement is shown.
