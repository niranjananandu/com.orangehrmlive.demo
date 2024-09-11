Feature: Login

Scenario: Positive Login Test
Given The login page is displayed
When The user enters a valid username "Admin"
And  The user enters a valid password "admin123"
And The user clicks login button
Then The user lands on the Dashboard page

Scenario Outline: Negative Login Test
Given The login page is displayed
When The user enters an invalid username <username>
And  The user enters an invalid password <password>
And The user clicks login button
Then The user is shown an Invalid credentials alert

Examples:
|username|password|
|Admin|123|
|test|admin123|