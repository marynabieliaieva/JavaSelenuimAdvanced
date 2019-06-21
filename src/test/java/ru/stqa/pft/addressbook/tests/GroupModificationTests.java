package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification()throws InterruptedException {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToAddContactPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddContactPage();
      app.getGroupHelper().createGroup(new GroupData("Work"));
    }
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().modifyGroup();
    app.getGroupHelper().fillGroupName(new GroupData("Personal"));
    app.getGroupHelper().submitGroup();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
    System.out.println("Was: " + before + ", now: " + after);
  }
}
