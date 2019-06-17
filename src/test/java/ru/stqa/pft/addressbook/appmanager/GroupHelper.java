package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initGroupCreation(GroupData groupData) throws InterruptedException {
    click(By.cssSelector("span.button-group:nth-child(4) > button:nth-child(2)"));
    type(By.cssSelector(".group > input:nth-child(2)"), groupData.getgroupName());
  }

  public void submitGroupCreation() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("span.button-group:nth-child(7) > button:nth-child(2)"));
  }

  public void selectGroup() {
    click(By.cssSelector(".icon-group"));
  }

  public void deleteGroup(){
    click(By.cssSelector("div.toolbar:nth-child(6) > button:nth-child(3)"));
  }

}
