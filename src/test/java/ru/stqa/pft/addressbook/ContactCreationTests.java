package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation(){
    goToAddContactPage();
    initContactCreation(new ContactData("Lars", "Jochansen"));
    submitContactCreation();
  }

}
