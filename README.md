# NexusSwaG

##  Hybrid Automation test Framework using BDD

Behaviour Driven Development test automaton framework for assessment

-- In this test framework I used below tech stacks --
* Cucumber - test layer
* Java - primary language

###### Prerequisites:
* Java 11
* Maven > 3.8.1


### Framework Structure:
* Config.properties (Path: assessment_automation_web/src/main/resources/config.properties)
    * Browser - firefox or chrome
    * Url
    * Type of Users (problem_user or standard_user)

* Utility
    * testBase  - BeforeSuite methods
    * baseClass - browser configuration
    * Constants - variables.

* Pages (Path: assessment_automation_web/src/main/java/assessment/web/ui/pages)
  * locators and functions and logics

* Steps (Path: assessment_automation_web/src/test/java/steps)
  * step definitions 

* assessment.feature (Path: assessment_automation_web/src/test/java/features/assessment.feature)
  * Scenario 01: Add items to cart and if any items fails print the names
  * Scenario 02: Sort the list and verify the list sorted correctly
    * currently sort value is set as "Name (A to Z)" can set any value as "Name (Z to A) | Price (low to high) | Price (high to low)"


### How to Execute:
* Navigate to assessment.feature -> Right-Click on the feature file -> click Run or Click Play / Run button near the Scenarios.
