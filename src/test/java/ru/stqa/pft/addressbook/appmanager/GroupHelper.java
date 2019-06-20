package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation(GroupData groupData) throws InterruptedException {
    click(By.cssSelector("span.button-group:nth-child(4) > button:nth-child(2)"));
    fillGroupName(groupData);
  }

  public void fillGroupName(GroupData groupData) {
    type(By.cssSelector(".group > input:nth-child(2)"), groupData.getgroupName());
  }


  public void submitGroup() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("span.button-group:nth-child(7) > button:nth-child(2)"));
  }

  public void selectGroup() {
    click(By.cssSelector(".icon-group"));
  }

  public void modifyGroup() {
    click(By.cssSelector("span.button-group:nth-child(6) > button:nth-child(2)"));
  }

  public void deleteGroup(){
    click(By.cssSelector("div.toolbar:nth-child(6) > button:nth-child(3)"));
  }

  public void createGroup(GroupData group) throws InterruptedException {
    initGroupCreation(group);
    submitGroup();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.cssSelector(".icon-group"));
  }

  public int getGroupCount() throws InterruptedException {
    Thread.sleep(1000);
    wd.navigate().refresh();
    return wd.findElements(By.cssSelector(".icon-group")).size();
  }
}
