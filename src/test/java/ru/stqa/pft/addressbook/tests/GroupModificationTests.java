package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().contactPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.goTo().contactPage();
      app.getGroupHelper().createGroup(new GroupData().withName("Work"));
    }
  }

  @Test
  public void testGroupModification() throws InterruptedException {
    app.goTo().contactPage();
    Set<GroupData> before = app.getGroupHelper().all(); //list of the elements
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("Personal");
    app.getGroupHelper().modifyGroup(group);
    app.goTo().contactPage();
    Set<GroupData> after = app.getGroupHelper().all(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(modifiedGroup); // delete group with old name from the list
    before.add(group); // add group with new name to list

    Assert.assertEquals(before, after);
    System.out.println("Was: " + new HashSet<Object>(before) + ", now: " + new HashSet<Object>(after));
  }
}
