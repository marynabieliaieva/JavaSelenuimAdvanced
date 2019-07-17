package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation(ContactData contactData, boolean creation) throws InterruptedException {
    click(By.cssSelector("span.button-group:nth-child(4) > button:nth-child(1)"));
    fillContactData(contactData, creation);
  }

  public void fillContactData(ContactData contactData, boolean creation) throws InterruptedException {
    type(By.cssSelector(".person > div >dd >input"), contactData.getName());
    Thread.sleep(1000);
    type(By.cssSelector(".person > div:nth-child(6) > div >dd >input"), contactData.getLastName());
    //Method bellow added just for example how to use boolean condition
    if (creation) {
      type(By.cssSelector(".person > div:nth-child(3)> dd > input"), contactData.getFirma());
    } else {
      Assert.assertTrue(isElementPresent(By.cssSelector(".person > div:nth-child(3)> dd > input")));
    }
  }


  public void submitContactCreation() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("span.button-group:nth-child(7) > button:nth-child(2)"));
  }

  public void deleteContact() {
    click(By.cssSelector("div.toolbar:nth-child(6) > button:nth-child(3)"));
  }

  public void modifyContact() {
    click(By.cssSelector("span.button-group:nth-child(6) > button:nth-child(2)"));
  }

  public void selectContact(int index) {
    wd.findElements(By.cssSelector("img[src*='public-avatar']")).get(index).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("a[href*='person']>span.name >strong"));
  }

  public void createContact(ContactData contactData, boolean creation) throws InterruptedException {
    initContactCreation(contactData, creation);
    submitContactCreation();
  }

  public int getContactCount() throws InterruptedException {
    Thread.sleep(1000);
    wd.navigate().refresh();
    return wd.findElements(By.cssSelector("img[src*='public-avatar']")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("a[href*='person']>span.name >strong"));
    for (WebElement element : elements) {
      String contactName = element.getText();
      ContactData contact = new ContactData(contactName, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

  //Function for clearing telephone number of the special characters
  public static String cleaned(String phone){
    //Array of the telephones which is starting from new line
    //String[] phones = wd.findElements(locator).getText().split("\n");
    return phone.replaceAll("\\s","").replaceAll("[-()]]","");
  }

  //Function for concatenation data except data which is equals null
  /*public String mergePhones(ContactData contact){
    return Arrays.asList(contact.getTel_1(), contact.getTel_2(), contact.getTel_3())
        .stream().filter((s) -> ! s.equals(""))
        .map(ContactHelper::cleaned)
        .collect(Collectors.joining("\n"));

  }*/


}





