Feature: Account Page Feature

Background: 
Given User has logged into the application
|username|password|
|sagar.lankegowda@gmail.com|sagar@123|

Scenario: Accounts Page Title
Given User is on Accounts Page
When user gets the title of the page
Then page title should be "My Store"

Scenario: Accounts Section Account
Given User is on Accounts Page
Then User gets the Accounts Section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Account Section Count Should Be 6

