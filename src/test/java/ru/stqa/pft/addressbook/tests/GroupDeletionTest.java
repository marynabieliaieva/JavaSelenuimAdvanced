package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.getGroupHelper().all(); //list of the elements
    GroupData deletedGroup = before.iterator().next();
    app.getGroupHelper().selectGroupNew(deletedGroup);
    app.getGroupHelper().deleteGroup();
    app.goTo().contactPage();
    Groups after = app.getGroupHelper().all(); //list of the elements
    assertEquals(after.size(), before.size() - 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(deletedGroup);
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(deletedGroup)));
    System.out.println(before);
    System.out.println(after);

  }
}
