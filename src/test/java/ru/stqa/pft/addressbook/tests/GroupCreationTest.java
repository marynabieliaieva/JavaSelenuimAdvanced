package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws InterruptedException {
    int before = app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToAddContactPage();
    app.getGroupHelper().createGroup(new GroupData("Work"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
    System.out.println("Was: " + before + ", now: " + after);
  }
}


