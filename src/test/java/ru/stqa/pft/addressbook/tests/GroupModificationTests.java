package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    //int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddContactPage();
      app.getGroupHelper().createGroup(new GroupData("Work"));
    }
    app.getNavigationHelper().goToAddContactPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    app.getGroupHelper().selectGroup(0); //delete first group
    app.getGroupHelper().modifyGroup();
    GroupData group = new GroupData(before.get(0).getId(), "Personal");
    app.getGroupHelper().fillGroupName(group); // change group name
    app.getGroupHelper().submitGroup();
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    before.remove(0); // delete group with old name from the list
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
