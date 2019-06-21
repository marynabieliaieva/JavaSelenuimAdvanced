package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws InterruptedException {
    //int before = app.getGroupHelper().getGroupCount(); - amount of the elements
    app.getNavigationHelper().goToAddContactPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    app.getGroupHelper().createGroup(new GroupData("Work"));
    app.getNavigationHelper().goToAddContactPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    //int after = app.getGroupHelper().getGroupCount(); - amount of the elements
    Assert.assertEquals(after.size(), before.size() + 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());
  }
}


