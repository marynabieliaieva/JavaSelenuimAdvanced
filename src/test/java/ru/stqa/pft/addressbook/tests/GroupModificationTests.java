package ru.stqa.pft.addressbook.tests;

import net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
    Groups before = app.getGroupHelper().all(); //list of the elements
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("Personal");
    app.getGroupHelper().modifyGroup(group);
    app.goTo().contactPage();
    Groups after = app.getGroupHelper().all(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    System.out.println("Was: " + new HashSet<Object>(before) + ", now: " + new HashSet<Object>(after));
  }
}
