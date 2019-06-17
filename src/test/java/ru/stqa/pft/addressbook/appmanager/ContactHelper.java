package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initContactCreation(ContactData contactData) throws InterruptedException {
    click(By.cssSelector("span.button-group:nth-child(4) > button:nth-child(1)"));
    type(By.cssSelector(".person > div >dd >input"), contactData.getName());
    Thread.sleep(1000);
    type(By.cssSelector(".person > div:nth-child(6) > div >dd >input"), contactData.getLastName());
  }



  public void submitContactCreation() throws InterruptedException {
    Thread.sleep(1000);
    click(By.cssSelector("span.button-group:nth-child(7) > button:nth-child(2)"));
  }



  public void deleteContact(){
    click(By.cssSelector("div.toolbar:nth-child(6) > button:nth-child(3)"));
  }

  public void selectContact() {
    click(By.cssSelector(".person-list > li:nth-child(1) > a:nth-child(1) > span:nth-child(3)"));
  }
}
