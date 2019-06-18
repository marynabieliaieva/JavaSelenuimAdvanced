package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactData(new ContactData("John", "Smith", null), false);
    app.getContactHelper().submitContactCreation();
  }
}
