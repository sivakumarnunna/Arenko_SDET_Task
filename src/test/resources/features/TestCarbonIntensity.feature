Feature: Getting Carbon Intensity Details

  Scenario Outline: verify carbon intensity details for last 30 mins
    When I get the carbon intensity for last thirty mins "<pathvariable>"
    Then validate the repsonse code <statuscode>
    Then validate the repsonse body with SOT file "<sotfile>"

    Examples: 
      | pathvariable | statuscode | sotfile                     |
      | intensity    |        200 | TestCarbonIntensity.feature |
