Feature: Free CRM Pro Test

Scenario: Register Page Test

Given user is on start page
When user clicks on sign up link
Then user is navigated to register page
Then window is closed

Scenario: Free CRM login test

Given crmpro Login Page is opened
When UserName and Password is entered
And Login Button is clicked
Then HomePage Opens
Then Browser is closed
 


