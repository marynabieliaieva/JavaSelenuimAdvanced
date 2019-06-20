package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws InterruptedException {
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddContactPage();
      app.getGroupHelper().createGroup(new GroupData("Work"));
    }
    app.getGroupHelper().selectGroup();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().deleteGroup();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
    System.out.println("Was: " + before + ", now: " + after);
  }
}
