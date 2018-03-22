Feature: add incidence
  Scenario: an agent creates an incidence
  	Given there are no incidences
    When the agent fills out the incidence form correctly
    Then the number of incidences is 1