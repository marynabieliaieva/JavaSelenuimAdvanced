package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    app.getGroupHelper().createGroup(new GroupData("Work"));
  }
}


