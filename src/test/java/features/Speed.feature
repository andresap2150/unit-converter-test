  Feature: Second flow (speed convert)

  Scenario: Flow validation converting kilometers/hours to miles/hours

    When I open the menu to select Speed
    And I set 60 kilometers/hours
    Then I see the 37.2823 converted units