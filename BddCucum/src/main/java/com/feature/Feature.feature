Feature: JBK

@test1
Scenario Outline: Login Page

Given user should be on login page
When user enters "<user>" and "<password>"
Then user will be on home page

Examples:
|user           |password|
|kiran@gmail.com|123456  |
|hanu@gmail.com |123     |

@test2
Scenario: Register New User

Given user should be on login page
When user click on new register
When and user enter "<name>" and "<mobile>" and "<email>" and "<password>"
And user click on submit
And user handle alert
Then user will on registraion page