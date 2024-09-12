Feature: Recruitment

Background:
Given The login page is displayed
When The user enters a valid username "Admin"
And  The user enters a valid password "admin123"
And The user clicks login button
Then The user lands on the Dashboard page

Scenario: Add a candidate
Given The user clicks on Recruitment Module
When The user clicks on the Add button
And The user fills in the Add Candidate form
|John|Guy|Doe|Senior QA Lead|john@test.com|123456|\src\test\resources\Files\Test1.txt|johnTest|2024-05-05|This is a test|
And The user clicks Save on Add Candidate	
Then A success toast message is displayed