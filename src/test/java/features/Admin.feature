Feature: Maintenance
Background:
Given The login page is displayed
When The user enters a valid username "Admin"
And  The user enters a valid password "admin123"
And The user clicks login button
Then The user lands on the Dashboard page

Scenario: Add a new admin user
Given The user clicks on the Admin module
And The user clicks on the User Management tab
And The user clicks on the Add button
And The user fills in the user data
And The user clicks save
And The user searches by the username
Then The added user is displayed
