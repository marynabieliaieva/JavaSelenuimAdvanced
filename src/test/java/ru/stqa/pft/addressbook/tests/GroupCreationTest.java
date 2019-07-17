package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{"test 1"});
    list.add(new Object[]{"test 2"});
    list.add(new Object[]{"test 3"});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(String name) throws InterruptedException {
    app.goTo().contactPage();
    Groups before = app.getGroupHelper().all(); //list of the elements
    GroupData group = new GroupData().withName(name);
    app.getGroupHelper().createGroup(group);
    app.goTo().contactPage();
    assertThat(app.getGroupHelper().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.getGroupHelper().all(); //list of the elements
    assertThat(after.size(), equalTo(before.size() + 1));
    System.out.println("Was: " + before.size() + ", now: " + after.size());
    System.out.println("Was: " + before + ", now: " + after);
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // Hamcrest assert
  }

}


