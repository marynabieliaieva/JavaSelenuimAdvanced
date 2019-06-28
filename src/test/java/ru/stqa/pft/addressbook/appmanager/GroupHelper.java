package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectGroup(int index) throws InterruptedException {
    Thread.sleep(1000);
    wd.findElements(By.cssSelector("a[href*='group']>span.name >strong")).get(index).click();
  }

  public void modifyGroup() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("span.button-group:nth-child(6) > button:nth-child(2)"));
  }

  public void deleteGroup() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("div.toolbar:nth-child(6) > button:nth-child(3)"));
  }

  public void createGroup(GroupData group) throws InterruptedException {
    initGroupCreation(group);
    submitGroup();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.cssSelector("a[href*='group']>span.name >strong"));
  }

  public int getGroupCount() throws InterruptedException {
    Thread.sleep(1000);
    wd.navigate().refresh();
    return wd.findElements(By.cssSelector("a[href*='group']>span.name >strong")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("a[href*='group']>span.name >strong"));
    for (WebElement element : elements) {
      String name = wd.findElement(By.cssSelector("a[href*='group']>span.name >strong")).getText();
      int id = Integer.parseInt(wd.findElement(By.cssSelector("a[href*='group']")).getAttribute("href").substring(37));
      GroupData group = new GroupData(id, name);
      groups.add(group);
      System.out.println(groups);
    }
    return groups;

  }
}
