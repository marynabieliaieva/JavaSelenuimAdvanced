package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddContactPage();
      app.getGroupHelper().createGroup(new GroupData("Work"));
    }
    app.getNavigationHelper().goToAddContactPage();
    //int before = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteGroup();
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size() - 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    System.out.println(before);
    System.out.println(after);

  }
}
