@APITest
Feature: Search List of Charities

  Scenario Outline: Search a Charity from List of Charities
    Given user set TradeMe sandbox API URI
    When user send "<Request>"  http request on "<Endpoint>"
    Then user recieves valid response code as "<Response>"
    And List of charities are displayed
    And List contains "<Charity>" in Description

    Examples: 
      | Request | Endpoint           | Response | Charity |
      | Get     | /v1/Charities.json |      200 | St John |
