@login
Feature: Login verification

Scenario: Login with Valid Credentials

When Enter the username
And Enter the Password
And Click the login button
Then Veify the login status
