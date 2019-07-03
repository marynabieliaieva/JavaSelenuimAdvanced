package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().contactPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.goTo().contactPage();
      app.getGroupHelper().createGroup(new GroupData().withName("Work"));
    }
  }

  @Test
  public void testGroupDeletion() throws InterruptedException {
    app.goTo().contactPage();
    Set<GroupData> before = app.getGroupHelper().all(); //list of the elements
    GroupData deletedGroup = before.iterator().next();
    app.getGroupHelper().selectGroupNew(deletedGroup);
    app.getGroupHelper().deleteGroup();
    app.goTo().contactPage();
    Set<GroupData> after = app.getGroupHelper().all(); //list of the elements
    Assert.assertEquals(after.size(), before.size() - 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
    System.out.println(before);
    System.out.println(after);

  }
}
