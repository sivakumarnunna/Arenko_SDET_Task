Feature: Getting Carbon Intensity Details
    
    @smoke @regression
    Scenario Outline: verify carbon intensity details <TCID> : <TC Description>
    When I get the carbon intensity details "<pathvariable>"
    Then validate the repsonse code <statuscode>
    #Then validate the repsonse body with SOT file "<sotfile>"
    Examples: 
      | TCID    | <TC Description>                                | pathvariable              | statuscode | sotfile                       |
      | TC_0001 | Get Carbon Intensity data for current half hour | intensity                 |        200 | carbonintensityper30mins.json |
      | TC_0002 | Get Carbon Intensity data for today             | intensity/date            |        200 | carbonintensityper30mins.json |
      | TC_0003 | Get Carbon Intensity data for specific date     | intensity/date/2021-08-25 |        200 | carbonintensityper30mins.json |

        
    @regression
    Scenario Outline: verify carbon intensity details with  invalid request <TCID> : <TC Description>
    When I get the carbon intensity details "<pathvariable>"
    Then validate the repsonse code <statuscode>
    #Then validate the repsonse body with SOT file "<sotfile>"
    Examples: 
      | TCID    | <TC Description>                                | pathvariable              | statuscode | sotfile                       |
      | TC_0004 | Get Carbon Intensity data for current half hour | intensiti                 |        400 | carbonintensityper30mins.json |
      | TC_0005 | Get Carbon Intensity data for today             | intensiti/date            |        400 | carbonintensityper30mins.json |
      | TC_0006 | Get Carbon Intensity data for specific date     | intensity/date/2021-14-25 |        400 | carbonintensityper30mins.json |
      