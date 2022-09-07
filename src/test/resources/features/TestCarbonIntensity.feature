Feature: Getting Carbon Intensity Details

  @smoke @regression @TCID
  Scenario Outline: verify carbon intensity details
    When I get the carbon intensity details "<pathvariable>"
    Then validate the repsonse code <statuscode>

    Examples: 
      | TCID    | TC Description                                  | pathvariable              | statuscode |
      | TC_0001 | Get Carbon Intensity data for current half hour | intensity                 |        200 |
      | TC_0002 | Get Carbon Intensity data for today             | intensity/date            |        200 |
      | TC_0003 | Get Carbon Intensity data for specific date     | intensity/date/2021-08-25 |        200 |

  @regression
  Scenario Outline: verify carbon intensity details with  invalid request "<TCID>"
    When I get the carbon intensity details "<pathvariable>"
    Then validate the repsonse code <statuscode>

    Examples: 
      | TCID    | TC Description                                  | pathvariable              | statuscode |
      | TC_0004 | Get Carbon Intensity data for current half hour | intensiti                 |        400 |
      | TC_0005 | Get Carbon Intensity data for today             | intensiti/date            |        400 |
      | TC_0006 | Get Carbon Intensity data for specific date     | intensity/date/2021-14-25 |        400 |

  #pre req : Shut down the carbonintensity service.
  #@regression
  #Scenario Outline: verify carbon intensity details when service is down "<TCID>" : "<TC Description>"
    #When I get the carbon intensity details "<pathvariable>"
    #Then validate the repsonse code <statuscode>
#
    #Examples: 
      #| TCID    | TC Description                                | pathvariable              | statuscode |
      #| TC_0007 | Get Carbon Intensity data for current half hour | intensity                 |        500 |
      #| TC_0008 | Get Carbon Intensity data for today             | intensity/date            |        500 |
      #| TC_0009 | Get Carbon Intensity data for specific date     | intensity/date/2021-08-25 |        500 |
