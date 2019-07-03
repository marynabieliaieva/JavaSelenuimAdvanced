package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectGroupNew(GroupData group) throws InterruptedException {
    Thread.sleep(1000);
    selectGroupById(group.getId());
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("a[href='/#abook/group/" + id + "']")).click();
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

  public Set<GroupData> all() {
    Set<GroupData> groups = new HashSet<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("a[href*='group']>span.name >strong"));
    for (WebElement element : elements) {
      String name = wd.findElement(By.cssSelector("a[href*='group']>span.name >strong")).getText();
      int id = Integer.parseInt(wd.findElement(By.cssSelector("a[href*='group']")).getAttribute("href").substring(37));
      groups.add(new GroupData().withId(id).withName(name));
      System.out.println(groups);
    }
    return groups;
  }

  public void modifyGroup(GroupData group) throws InterruptedException {
    selectGroupById(group.getId()); //delete first group
    modifyGroup();
    fillGroupName(group); // change group name
    submitGroup();
  }
}
