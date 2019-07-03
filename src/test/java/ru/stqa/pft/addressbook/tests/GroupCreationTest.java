package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws InterruptedException {
    app.goTo().contactPage();
    Set<GroupData> before = app.getGroupHelper().all(); //list of the elements
    GroupData group = new GroupData().withName("Work");
    app.getGroupHelper().createGroup(group);
    app.goTo().contactPage();
    Set<GroupData> after = app.getGroupHelper().all(); //list of the elements
    assertThat(after.size(), equalTo(before.size() + 1));
    assertEquals(after.size(), before.size() + 1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    System.out.println("Was: " + before + ", now: " + after);
    assertThat(after, equalTo(before)); // Hamcrest assert
    assertEquals(before, after);

  }
}


