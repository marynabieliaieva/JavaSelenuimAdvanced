package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws InterruptedException {
    //int before = app.getGroupHelper().getGroupCount(); - amount of the elements
    app.getNavigationHelper().goToAddContactPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    GroupData group = new GroupData("Work");
    app.getGroupHelper().createGroup(group);
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size() + 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    /*int max = 0; - old option to find maximum value in the list
    for (GroupData g : after){ // search maximum value for id
      if (g.getId() > max)
        max = g.getId();
    }*/

    Comparator<? super GroupData> byId = new Comparator<GroupData>() { // new (java 8) option to find maximum value in the list
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getId(), o2.getId());
      }
    };
    int max1 = after.stream().max(byId).get().getId();
    group.setId(max1);
    before.add(group);
    System.out.println("Was: " + before + ", now: " + after);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // compare collections without order
  }
}


