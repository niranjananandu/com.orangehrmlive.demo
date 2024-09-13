Feature: Time feature

Background:
Given The login page is displayed
When The user enters a valid username "Admin"
And  The user enters a valid password "admin123"
And The user clicks login button
Then The user lands on the Dashboard page

Scenario: User to add his timesheet
Given The user clicks on the Time Module
And The user clicks on the Timesheets drop-down
And The user clicks on My Timesheets
When The user clicks Edit button
And The user adds a new timesheet record 
And The user clicks Save
Then A new timesheet record is added
