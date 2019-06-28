package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws InterruptedException {
    //int before = app.getGroupHelper().getGroupCount(); - amount of the elements
    app.goTo().contactPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //list of the elements
    GroupData group = new GroupData().withName("Work");
    app.getGroupHelper().createGroup(group);
    app.goTo().contactPage();
    //int after = app.getGroupHelper().getGroupCount(); - amount of the elements
    List<GroupData> after = app.getGroupHelper().getGroupList(); //list of the elements
    Assert.assertEquals(after.size(), before.size() + 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    /*int max = 0; - old option to find maximum value in the list
    for (GroupData g : after){ // search maximum value for id
      if (g.getId() > max)
        max = g.getId();
    }*/

    // new (java 8) option to find maximum value in the list


    // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); - get maximum id
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    System.out.println("Was: " + before + ", now: " + after);
    Assert.assertEquals(before, after);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // compare collections without order  - obsolete
  }
}


