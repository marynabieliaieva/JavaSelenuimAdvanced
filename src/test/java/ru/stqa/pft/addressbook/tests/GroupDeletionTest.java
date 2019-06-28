package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().contactPage();
    //int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.goTo().contactPage();
      app.getGroupHelper().createGroup(new GroupData().withName("Work"));
    }
  }

  @Test
  public void testGroupDeletion() throws InterruptedException {
    app.goTo().contactPage();
    //int before = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().deleteGroup();
    app.goTo().contactPage();
    //int after = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size() - 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(0);
    Assert.assertEquals(before, after);
    System.out.println(before);
    System.out.println(after);

  }
}
