  Feature: First flow (dimension convert)

  Scenario: Flow Validation convert an area from hectareas to squared km

    When I open the menu to select Area
    And I set 250 hectareas to squaredkilometers
    Then I see the 2.5 converted units