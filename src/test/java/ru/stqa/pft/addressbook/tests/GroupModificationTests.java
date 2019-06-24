package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification()throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    //int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddContactPage();
      app.getGroupHelper().createGroup(new GroupData("Work"));
    }
    app.getNavigationHelper().goToAddContactPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    app.getGroupHelper().selectGroup(before.size() - 1); //delete the last group
    app.getGroupHelper().modifyGroup();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Personal");
    app.getGroupHelper().fillGroupName(group); // change group name
    app.getGroupHelper().submitGroup();
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(before.size() - 1); // delete group with old name from the list
    before.add(group); // add group with new name to list
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // compare collections without order
  }
}
