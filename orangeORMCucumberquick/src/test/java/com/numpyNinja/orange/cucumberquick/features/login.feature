@open
Feature: Open and Login on Juiceshop

#Background:Set all browsers
       #Given set all Browsers
  @chrome
  Scenario: For chrome browser
    Given open url with "chrome" browser
  @firefox
   Scenario: For firefox browser
   Given open url with "firefox" browser
  @edge
    Scenario: For edge browser
   Given open url with "edge" browser
  
  @login
  Scenario Outline: Login Credentials
    Given Send Login "<name>" with password "<password>"
    Then  click Login Password Submit
    And I verify the "<status>" in step
		#And Quit Driver
  @valid
 # Scenario: +ve scenario
  Examples: Data for Orange login
   | name  | password | status |
   | Admin | admin123 | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |
  
  
  #@invalid 
 # Scenarios: Check -ve scenario
  #Examples: Invalid data for juice shop login
   #| name  | password | status |
   #| test1 | test123 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login |
   #
 