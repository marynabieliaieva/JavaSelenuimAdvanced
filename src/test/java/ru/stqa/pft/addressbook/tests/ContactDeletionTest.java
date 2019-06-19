package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Lars", "Johansen", "google"), true);
    }
    app.getNavigationHelper().goToAddContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }
}
