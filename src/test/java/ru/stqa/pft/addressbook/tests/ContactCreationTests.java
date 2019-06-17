package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    app.getContactHelper().initContactCreation(new ContactData("Lars", "Jochansen"));
    app.getContactHelper().submitContactCreation();
  }
}
