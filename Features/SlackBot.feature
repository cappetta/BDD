# Created by cappetta at 11/21/17
@slackbot
Feature: Create a slackbot using jbot
  # Enter This is

  Scenario: Tell slackbot to start a test execution
    Given the SlackBot is listening for messages
    And  a user is Direct messaging the Slackbot
    Then the Slackbot responds to the inquiry
    Then user enters "@slackbot function args"
    Then the Slackbot calls the function passing in the args
    Then the Slackbot responds to the user indicating the response of the function call
    Then the user enters "@slackbot start <args>" to start the execution of a test scenario
    Then the Slackbot responds with an update indicating the results of the execution

  Scenario: Ask slackbot to run a python script
    Given the SlackBot is listening for messages
    And  a user is Direct messaging the Slackbot
    Then the user enters "@slackbot runpy <args>" to start the execution of a python script
    Then the Slackbot responds with an update indicating the results of the execution

