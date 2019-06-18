package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification()throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup();
    app.getGroupHelper().fillGroupName(new GroupData("Personal"));
    app.getGroupHelper().submitGroup();
  }
}
