package e4b.InciManager_e4b.steps;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asw.controllers.AgentsController;
import asw.database.entities.Agent;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
  
  private static final Logger LOG = LoggerFactory.getLogger(AgentsController.class);

  @Given("^a list of agents:$")
  public void a_list_of_users(List<Agent> agents) throws Throwable {
    for (Agent a: agents) {
      System.out.println("Inserting agent..." + a.getEmail() + " - " + a.getPassword());
    }
  }

  @When("^I login with email \"(.+)\" and password \"(.+)\"$")
  public void i_login_with_name_and_password(String email, String password) throws Throwable {
    System.out.println("Login with values..." + email + " - " + password);
  }

  @Then("^I receive a welcome message$")
  public void i_receive_a_welcome_message() throws Throwable {
    System.out.println("Wellcome value received");
  }
  
  @Given("^there are no users$")
  public void there_are_no_users() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("Creating an empty DB");
  }

  @When("^I create a user \"([^\"]*)\" with password \"([^\"]*)\"$")
  public void i_create_a_user_with_password(String arg1, String arg2) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("Creating user " + arg1 + " with password " + arg2);
  }

  @Then("^The number of users is (\\d+)$")
  public void the_number_of_users_is(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      System.out.println("Checking numbers");

  }
  
  public static class User {
    private String name;
    private String password;
  }
}
