Feature: Test Login feature

  Background:
    Given I am on OpenCart login page

  @SearchProduct
  Scenario: Search a product
    When I search a product
    Then Verify results count