package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

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
  public void testGroupModification() throws InterruptedException {
    app.goTo().contactPage();
    int index = 0; //can be 'before.size() - 1'
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    GroupData group = new GroupData()
            .withId(before.get(index).getId())
            .withName("Personal");
    app.getGroupHelper().modifyGroup(index, group);
    app.goTo().contactPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(index); // delete group with old name from the list
    before.add(group); // add group with new name to list

    //List sorted and comparation via lambda expressions
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    System.out.println("Was: " + new HashSet<Object>(before) + ", now: " + new HashSet<Object>(after));
    // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));// compare collections without order - obsolete
  }


}
