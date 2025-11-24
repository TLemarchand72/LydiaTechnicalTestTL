Feature: UserCase
    As a user
    I want to navigate through the app and search the city named Lydia
    So that I can switch to French language and find information about the city

Scenario: Navigate carousel, search Lydia city and change language
    Given the application is launched
    When I swipe through the carousel until the last image without skipping
    And I search for "Lydia"
    And I scroll until I find the city Lydia
    And I change the website language to French
    And I click on "Crésus"