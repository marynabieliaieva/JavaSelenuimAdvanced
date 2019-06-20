package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

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
    if (creation){
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

  public void selectContact() {
    click(By.cssSelector(".person-list > li:nth-child(1) > a:nth-child(1) > span:nth-child(3)"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("ul.person-list:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2) > img:nth-child(1)"));
  }

  public void createContact(ContactData contactData, boolean creation) throws InterruptedException {
    initContactCreation(contactData, creation);
    submitContactCreation();
  }
  
}





