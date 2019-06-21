package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

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
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().modifyGroup();
    app.getGroupHelper().fillGroupName(new GroupData("Personal"));
    app.getGroupHelper().submitGroup();
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());
  }
}
