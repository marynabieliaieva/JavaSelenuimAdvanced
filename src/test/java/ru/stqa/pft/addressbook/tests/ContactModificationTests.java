package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Lars", "Johansen", "google"), true);
    }
    app.getNavigationHelper().goToAddContactPage();
    //int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList(); //list of the elements
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactData(new ContactData("John", "Smith", null), false);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToAddContactPage();
    //int after = app.getContactHelper().getContactCount();
    List<ContactData> after = app.getContactHelper().getContactList(); //list of the elements
    Assert.assertEquals(after.size(), before.size());
    System.out.println("Was: " + before.size() + ", now: " + after.size());
  }
}
