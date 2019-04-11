@example
Feature: This is an example feature for Selenide Testing

  This test will demonstrate opening a browser and doing some automated testing
  using the Selenide library https://github.com/selenide/selenide

  These are far from complex example but are to simply demonstrate using Cucumber framework with Selenide.

  Scenario: Open a website and check page title
    Given I am on the home page of the following site "https://www.google.com"
    When I get the page title
    Then the page title will be "Google"

  Scenario: Complete a basic search using Google
    Given I am on the home page of the following site "https://www.google.com"
    When I search for the term "Chocolate"
    Then I will get a list of results to chose from