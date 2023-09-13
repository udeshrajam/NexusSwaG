Feature: Assessment Test Execution


  Scenario: Q1 : Add items to cart and if any items fails print the name
    Given user enters "problem user" username
    When user enters the password
    And user clicks on login button
    And add items to the cart
    Then user logouts from application

  Scenario: Q2 : Sort the list and verify the list sorted correctly
    Given user enters "standard user" username
    When user enters the password
    And user clicks on login button
    And select "Name (Z to A)" as sorting
    And verify the product list
    Then user logouts from application


