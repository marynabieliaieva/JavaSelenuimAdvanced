package ru.stqa.pft.addressbook.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GroupStepDefinitions {

  private ApplicationManager app;
  private Groups groups;
  private GroupData newGroup;

  @Before
  public void init() throws IOException, InterruptedException {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  @After
  public void stop() {
    app.stop();
    app = null;
  }

  @Given("^a set of groups$")
  public void loadGroups() {
    groups = app.db().groups();
  }

  @When("^I create a new group with name (.+)$")
  public void createGroup(String name) throws InterruptedException {
    app.goTo().contactPage();
    newGroup = new GroupData().withName(name);
    app.getGroupHelper().createGroup(newGroup);
  }

  @Then("^the vew set of groups is equal to the old set with the added group$")
  public void verifyGroupCreated() {
    Groups newGroups = app.db().groups();
    assertThat(newGroups, equalTo(groups.withAdded(newGroup)));
  }
}
