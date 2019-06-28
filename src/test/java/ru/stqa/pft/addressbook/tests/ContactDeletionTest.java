package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() throws InterruptedException {
    app.goTo().contactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Lars", "Johansen", "google"), true);
    }
    app.goTo().contactPage();
    //int before = app.getContactHelper().getContactCount(); - amount of the elements
    List<ContactData> before = app.getContactHelper().getContactList(); //list of the elements
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
    app.goTo().contactPage();
    //int after = app.getContactHelper().getContactCount(); - amount of the elements
    List<ContactData> after = app.getContactHelper().getContactList(); //list of the elements
    Assert.assertEquals(after.size(), before.size() -1);
    System.out.println("Was: " + before.size() + ", now: " + after.size());
  }
}
