Feature: Maintenance
Background:
Given The login page is displayed
When The user enters a valid username "Admin"
And  The user enters a valid password "admin123"
And The user clicks login button
Then The user lands on the Dashboard page

Scenario: Search and view past employee details
Given The user clicks on the Maintenance module
And The user enters valid credentials on the Administrator Access window
And The user clicks on the Access Records Menu
And The user enters "Peter" in the text box
And The user selects the first option in the drop-down
And The user clicks Submit
Then The user details are displayed

Scenario: Download past employee details
Given The user clicks on the Maintenance module
And The user enters valid credentials on the Administrator Access window
And The user clicks on the Access Records Menu
And The user enters "Peter" in the text box
And The user selects the first option in the drop-down
And The user clicks Submit
And The user clicks download button
Then The user data is downloaded
