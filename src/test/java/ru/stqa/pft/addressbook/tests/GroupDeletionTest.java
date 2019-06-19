package ru.stqa.pft.addressbook.tests;

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
    app.getGroupHelper().deleteGroup();
  }
}
