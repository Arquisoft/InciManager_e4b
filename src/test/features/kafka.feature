Feature: kafka incidence
  Scenario: an agent sends a incidence to kafka stream
    When an agent creates an incidence
    Then the incidence is sent by kafka