Feature: Being able to login
Scenario: Login
  Login with some username

    Given a list of agents:
      | email   | password |
      | pepe@gmail.com    | 123456   |
      | paco@gmail.com    | 123456     |
      | maria@gmail.com    | 123456      |
    When I login with email "pepe@gmail.com" and password "123456"
    Then I receive a welcome message
