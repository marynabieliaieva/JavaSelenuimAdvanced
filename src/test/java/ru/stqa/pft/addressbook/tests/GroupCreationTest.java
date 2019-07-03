package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws InterruptedException {
    app.goTo().contactPage();
    Groups before = app.getGroupHelper().all(); //list of the elements
    GroupData group = new GroupData().withName("Work");
    app.getGroupHelper().createGroup(group);
    app.goTo().contactPage();
    Groups after = app.getGroupHelper().all(); //list of the elements
    assertThat(after.size(), equalTo(before.size() + 1));
    System.out.println("Was: " + before.size() + ", now: " + after.size());

    System.out.println("Was: " + before + ", now: " + after);
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // Hamcrest assert
  }
}


