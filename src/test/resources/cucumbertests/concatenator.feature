Feature: Concatenate

  Scenario: Concatenate Strings
    Given I have Tokens 'First' and 'Second'
    When I create a Concatenator
    Then the concatenate method should return the concatenated result
    
  Scenario: Concatenate Strings1
    Given I have Tokens 'Yellow' and 'Blue'
    When I create a Concatenator
    Then the concatenate method should return the concatenated result
    
    
        
  Scenario: Concatenate MultipleStrings
    Given I have multiple Tokens 'Red, Blue, Green, Yellow, Orange, White'
    When I create a Concatenator
    Then the concatenate method should return the concatenated result
    
  Scenario: Concatenate Three Strings
    Given I have Threee Tokens 'Yes',  'No' and 'Maybe'
    When I create a Concatenator
    Then the concatenate method should return the concatenated result
