# language: en
Feature: Agent login

Scenario: An agent logs into the system
	Given a registered agent
	When the username and password are correct
	Then the agent can create an incidence
