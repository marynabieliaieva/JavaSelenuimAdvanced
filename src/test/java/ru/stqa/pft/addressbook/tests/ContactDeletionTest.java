package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getNavigationHelper().goToAddContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }




}
